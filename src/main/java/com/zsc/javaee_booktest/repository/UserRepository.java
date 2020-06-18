package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from t_user where user_name = ?1", nativeQuery = true)
    public List<User> findByUserName(String userName);
}
