package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
