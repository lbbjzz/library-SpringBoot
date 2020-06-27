package com.zsc.javaee_booktest.controller;

import com.zsc.javaee_booktest.entity.Book;
import com.zsc.javaee_booktest.repository.BookRepository;
import com.zsc.javaee_booktest.service.BookService;
import com.zsc.javaee_booktest.service.UserService;
import com.zsc.javaee_booktest.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;


    @GetMapping("/findAll/{page}/{size}")
    public Map<String, Object> findAll(@PathVariable int page, @PathVariable int size){
        List<Book> books = bookService.getAllBooks(page, size);
        PageUtils pageUtils = new PageUtils();
        Map<String, Object> pageInfo = pageUtils.startPage(books, page, size);
        return pageInfo;
    }

    @GetMapping("/findByName/{bookName}/{page}/{size}")
    public Map<String, Object> findByName(@PathVariable String bookName, @PathVariable int page, @PathVariable int size){
        List<Book> booksByName = bookService.getByBookName(bookName);
        PageUtils pageUtils = new PageUtils();
        Map<String, Object> pageInfo = pageUtils.startPage(booksByName, page, size);
        return pageInfo;
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result = bookService.save(book);
        if(result != null){
            return "success";
        } else {
            return "fail";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable int id){
        return bookService.getByBookId(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookService.save(book);
        if(result != null){
            return "success";
        } else {
            return "fail";
        }
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id){
        bookService.delete(id);
    }

    @GetMapping("/borrow/{bookId}")
    public String borrow(@PathVariable int bookId){
        return bookService.bookBorrow(bookId);
    }
    
    @GetMapping("/return/{bookId}")
    public String returned(@PathVariable int bookId){
        return bookService.bookReturn(bookId);
    }
}
