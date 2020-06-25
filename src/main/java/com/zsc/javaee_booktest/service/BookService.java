package com.zsc.javaee_booktest.service;


import com.zsc.javaee_booktest.entity.Book;

import java.util.List;

public interface BookService {
    public String bookBorrow(int bookId);
    public String bookReturn(int bookId);
    public List<Book> getAllBooks();
}
