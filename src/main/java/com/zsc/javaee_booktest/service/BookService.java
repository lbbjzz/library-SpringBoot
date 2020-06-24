package com.zsc.javaee_booktest.service;


public interface BookService {
    public String bookBorrow(int bookId);
    public String bookReturn(int bookId);
}
