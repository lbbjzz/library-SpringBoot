package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User> {

    @Query(value = "select * from t_user where user_name = ?1", nativeQuery = true)
    public User getByUserName(String userName);

//    @Query(value = "insert into t_user(user_name,password,email,sex,phone,age) value(?1,?2,?3,?4,?5,?6)", nativeQuery = true)
//    @Modifying
//    public void insertUser(String userName, String password, String emil, String phone, String sex, int age);
//
//    @Query(value = "update t_user set user_name=?1 where id=?2 ", nativeQuery = true)
//    @Modifying
//    public void updateUserName(String userName,int id);
//
//    @Query(value = "delete from t_user where id=?1 ", nativeQuery = true)
//    @Modifying
//    public void deleteUserById(int id);

}
