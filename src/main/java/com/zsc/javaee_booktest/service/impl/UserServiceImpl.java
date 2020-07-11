package com.zsc.javaee_booktest.service.impl;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zsc.javaee_booktest.entity.*;
import com.zsc.javaee_booktest.repository.RoleRepository;
import com.zsc.javaee_booktest.repository.UserRepository;
import com.zsc.javaee_booktest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JPAQueryFactory queryFactory;

    @Autowired
    private RoleRepository roleRepository;


    QAuthority qAuthority = QAuthority.authority1;
    QRole qRole = QRole.role;
    QUser qUser = QUser.user;

    @Override
    @Cacheable(cacheNames = "user", key = "'getAllUsers'", unless = "#result == null")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /*
    * @Author Kami
    * @Description 得到用户拥有的所有权限
    * @Date 3:52 2020/6/24
    * @Param [userName]
    * @return java.util.List<com.zsc.javaee_booktest.entity.Authority>
    **/
    @Override
    @Cacheable(cacheNames = "user", key = "'getAuthorityByUserName' + #userName", unless = "#result == null")
    public List<Authority> getAuthorityByUserName(String userName) {
        Predicate predicate = qUser.userName.eq(userName);
        List<Authority> authorities = queryFactory.select(qAuthority)
                .from(qRole)
                .leftJoin(qUser)
                .on(qRole.userId.eq(qUser.id))
                .leftJoin(qAuthority)
                .on(qRole.authorityId.eq(qAuthority.id))
                .where(predicate)
                .fetch();
        return authorities;
    }

    @Override
    @Cacheable(cacheNames = "user", key = "'getRoleByUserId' + #userId", unless = "#result == null")
    public List<Role> getRoleByUserId(int userId){
        return roleRepository.findByUserId(userId);
    }

    /*
    * @Author Kami
    * @Description 用户注册功能，将用户密码转换为密文后写入数据库中
    * @Date 3:50 2020/6/24
    * @Param [user]
    * @return java.lang.String
    **/
    @Override
    @CacheEvict(cacheNames = "user", allEntries = true)
    public User saveWithEncoding(User user) {
        if(userRepository.getByUserName(user.getUserName()) != null){
            return userRepository.save(user);
        }else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User newUser = userRepository.save(user);
            Role role = new Role();
            role.setUserId(newUser.getId());
            role.setAuthorityId(2);
            roleRepository.save(role);
            return newUser;
        }
}

    @Override
    @Cacheable(cacheNames = "user", key = "'getByUserName-' + #userName", unless = "#result == null")
    public User getByUserName(String userName){
        return userRepository.getByUserName(userName);
    }

    @Override
    @Cacheable(cacheNames = "user", key = "'getById-' + #userId")
    public User getById(int userId){
        return userRepository.findUserById(userId);
    }

    /*
    * @Author Kami
    * @Description 获取当前登录的用户
    * @Date 3:51 2020/6/24
    * @Param []
    * @return com.zsc.javaee_booktest.entity.User
    **/
    @Override
    public User getUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String userName = principal.getUsername();
        User user = getByUserName(userName);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = getByUserName(userName);
        if(user != null){
            List<Authority> authorities = userService.getAuthorityByUserName(userName);
            List<SimpleGrantedAuthority> list = authorities.stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                    .collect(Collectors.toList());
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                    user.getUserName(), user.getPassword(), list);
            return userDetails;
        } else{
            System.out.println("用户名不存在");
            throw new UsernameNotFoundException("当前用户不存在");
        }
    }

    //修改密码
    @Override
    @CacheEvict(cacheNames = "user", allEntries = true)
    public void resetPwd(int userId, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String newPws = passwordEncoder.encode(password);
        userRepository.resetPassword(userId, newPws);
        System.out.println("修改成功。");
    }

    //激活
    @Override
    @CacheEvict(cacheNames = "user", allEntries = true)
    public void activeUser(int userId) {
        User findUser = userRepository.findUserById(userId);
        int valid = 1;
        if (findUser.getValid() == 1) {
            System.out.println("用户已激活，请勿重复操作。");
        }
        userRepository.activeOrDeActiveUser(findUser.getId(), valid);
        System.out.println("用户已激活。");
    }

    //停用账户
    @Override
    @CacheEvict(cacheNames = "user", allEntries = true)
    public void deActiveUser(int userId) {
        User findUser = userRepository.findUserById(userId);
        int valid = 0;
        if (findUser.getValid() == 0) {
            System.out.println("用户已停用，请勿重复操作。");
        }
        userRepository.activeOrDeActiveUser(findUser.getId(), valid);
        System.out.println("用户已停用。");
    }

    @Override
    @CacheEvict(cacheNames = "user", allEntries = true)
    public void deleteById(int userId){
        userRepository.deleteById(userId);
    }
}
