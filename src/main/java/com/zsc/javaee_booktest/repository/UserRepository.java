package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User> {

    @Query(value = "select * from t_user where user_name = ?1", nativeQuery = true)
    public User getByUserName(String userName);

    @Query(value = "select * from t_user where id = ?1", nativeQuery = true)
    public User getByUserId(int userId);

}
