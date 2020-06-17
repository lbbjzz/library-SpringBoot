package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReposity extends JpaRepository<Book,Integer> {
}
