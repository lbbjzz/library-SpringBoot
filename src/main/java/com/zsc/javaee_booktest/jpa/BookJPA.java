package com.zsc.javaee_booktest.jpa;

import com.zsc.javaee_booktest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJPA extends JpaRepository<Book, Integer> {
}
