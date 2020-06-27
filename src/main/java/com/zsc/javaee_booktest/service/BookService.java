package com.zsc.javaee_booktest.service;


import com.zsc.javaee_booktest.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    public String bookBorrow(int bookId);
    public String bookReturn(int bookId);
    public List<Book> getAllBooks(int page, int size);
    public List<Book> getByBookName(String bookName);
    public Book getByBookId(int bookId);
    public Book save(Book book);
    public void delete(int id);
}
