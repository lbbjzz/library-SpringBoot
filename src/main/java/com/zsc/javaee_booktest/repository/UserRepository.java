package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.Authority;
import com.zsc.javaee_booktest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User> {
    @Query(value = "select * from t_user where user_name = ?1", nativeQuery = true)
    public List<User> getByUserName(String userName);

}
