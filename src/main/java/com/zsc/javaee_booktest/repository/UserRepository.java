package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User> {

    @Query(value = "select * from t_user where user_name = ?1", nativeQuery = true)
    public User getByUserName(String userName);

    public User findUserById(int userId);

    @Modifying
    @Transactional
    @Query(value = "update t_user set password = ?2 where id = ?1", nativeQuery = true)
    public void resetPassword(Integer id, String password);

    @Modifying
    @Transactional
    @Query(value = "update t_user set valid = ?2 where id = ?1", nativeQuery = true)
    public void activeOrDeActiveUser(Integer id, Integer valid);
}
