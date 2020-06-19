package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookReposityTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());
    }

    @Test
    void findById(){
        Book book = bookRepository.findById(1).get();
        System.out.println(book);
    }

    @Test
    void save(){
        Book book = new Book();
        book.setBookName("qqqs");
        book.setAuthor("dddd");
        book.setPubHouse("yyyy");
        book.setPubDate("2001");
        Book book1 = bookRepository.save(book);
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
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void delete(){
        bookRepository.deleteById(3);
    }

    @Test
    void findByBookName(){
        System.out.println(bookRepository.getByBookName("白夜行"));
    }

}