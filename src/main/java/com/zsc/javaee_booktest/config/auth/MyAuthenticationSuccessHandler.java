package com.zsc.javaee_booktest.config.auth;

import com.alibaba.fastjson.JSON;
import com.zsc.javaee_booktest.entity.Authority;
import com.zsc.javaee_booktest.entity.User;
import com.zsc.javaee_booktest.service.UserService;
import com.zsc.javaee_booktest.utils.Menu;
import com.zsc.javaee_booktest.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AuthenticationSuccessHandler
 * @Description 登录成功处理器
 * @Author Kami
 * @Date 2020/6/29 17:39
 * @Version 1.0
 **/
@Component
public class MyAuthenticationSuccessHandler extends JSONAuthentication implements AuthenticationSuccessHandler {
    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        SecurityContext context = SecurityContextHolder.getContext();
        authentication = context.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        User user = userService.getUser();
        List<Authority> authority = userService.getAuthorityByUserName(user.getUserName());
        Map<String, Object> map = new HashMap<>();
        List<Menu> menuList = new ArrayList<>();

        Menu home = new Menu("/home","home","首页","s-home","Home/Home", null);
        Menu userManager = new Menu("/user", "usermanage", "用户管理", "user", "UserManage/Usermanage", null);
        Menu bookManager = new Menu("/bookmanage", "bookmanage", "图书管理", "reading", "Book/Bookmanage", null);
        Menu bookBorrow = new Menu("/bookborrow", "bookborrow", "图书借阅", "setting", "Book/Bookborrow", null);
        Menu userInfo = new Menu("/userinfo", "userinfo", "个人中心", "user", "UserInfo/UserInfo", null);
        //Menu bookManagerMenu = new Menu(null, null, "图书", "reading", null, bookManager);
        //Menu bookGuestMenu = new Menu(null, null, "图书", "reading", null, bookBorrow);

        menuList.add(home);
        System.out.println(authority.get(0).getAuthority());
        if (authority.get(0).getAuthority().equals("manager")){
            menuList.add(userManager);
            menuList.add(bookManager);
            menuList.add(userInfo);
        }else {
            menuList.add(userInfo);
            menuList.add(bookBorrow);
        }



        map.put("username", userDetails.getUsername());
        map.put("auth", userDetails.getAuthorities());
        map.put("menu", menuList);
        jsonResult = ResultUtils.success(map);
        this.writeJSON(httpServletRequest, httpServletResponse, jsonResult);
    }
}
