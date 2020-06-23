package com.zsc.javaee_booktest.controller;

import com.zsc.javaee_booktest.entity.Book;
import com.zsc.javaee_booktest.entity.User;
import com.zsc.javaee_booktest.repository.BookRepository;
import com.zsc.javaee_booktest.repository.UserRepository;
import com.zsc.javaee_booktest.service.BookService;
import com.zsc.javaee_booktest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

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
    public Page<Book> findAll(@PathVariable int page, @PathVariable int size){
        Pageable pageable = PageRequest.of(page - 1, size);
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/findByName/{bookName}/{page}/{size}")
    public Page<Book> findByName(@PathVariable String bookName, @PathVariable int page, @PathVariable int size){
        Pageable pageable = PageRequest.of(page - 1, size);
        return bookRepository.getByBookName(bookName, pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result != null){
            return "success";
        } else {
            return "fail";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable int id){
        return bookRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result != null){
            return "success";
        } else {
            return "fail";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id){
        bookRepository.deleteById(id);
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
