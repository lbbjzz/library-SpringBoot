package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReposityTest {
    @Autowired
    private BookReposity bookReposity;

    @Test
    void findAll(){
        System.out.println(bookReposity.findAll());
    }

    @Test
    void findById(){
        Book book = bookReposity.findById(1).get();
        System.out.println(book);
    }

    @Test
    void save(){
        Book book = new Book();
        book.setBookName("qqqs");
        book.setAuthor("dddd");
        book.setPubHouse("yyyy");
        book.setPubDate("2001");
        Book book1 = bookReposity.save(book);
        System.out.println(book1);
    }

    @Test
    void update(){
        Book book = new Book();
        book.setId(3);
        book.setBookName("测试");
        book.setAuthor("测试");
        book.setPubHouse("测试");
        book.setPubDate("测试");
        Book book1 = bookReposity.save(book);
        System.out.println(book1);
    }

    @Test
    void delete(){
        bookReposity.deleteById(3);
    }
}