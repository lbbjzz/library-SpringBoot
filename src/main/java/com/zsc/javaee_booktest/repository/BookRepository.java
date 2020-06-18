package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>{
    @Query(value = "select * from t_book where book_name = ?1", nativeQuery = true)
    List<Book> findByBookName(String bookName);
}
