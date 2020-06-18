package com.zsc.javaee_booktest.controller;

import com.zsc.javaee_booktest.entity.Book;
import com.zsc.javaee_booktest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable int page, @PathVariable int size){
        Pageable pageable = PageRequest.of(page - 1, size);
        return bookRepository.findAll(pageable);
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
}
