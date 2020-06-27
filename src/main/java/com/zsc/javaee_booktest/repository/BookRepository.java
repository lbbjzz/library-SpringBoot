package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>{
    @Query(value = "select * from t_book where book_name like %?1%", nativeQuery = true)
    public List<Book> getByBookName(String bookName);
}
