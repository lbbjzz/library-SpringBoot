package com.zsc.javaee_booktest.service.impl;

import com.zsc.javaee_booktest.entity.Book;
import com.zsc.javaee_booktest.entity.BorrowRecord;
import com.zsc.javaee_booktest.entity.ReturnRecord;
import com.zsc.javaee_booktest.entity.User;
import com.zsc.javaee_booktest.repository.BookRepository;
import com.zsc.javaee_booktest.repository.ReturnRecordRepository;
import com.zsc.javaee_booktest.service.BookService;
import com.zsc.javaee_booktest.service.BorrowRecordService;
import com.zsc.javaee_booktest.service.ReturnRecordService;
import com.zsc.javaee_booktest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRecordService borrowRecordService;

    @Autowired
    private ReturnRecordService returnRecordService;

    @Autowired
    private UserService userService;



    @Override
    @Cacheable(cacheNames = "book", key = "'getAllBooks'", unless = "#result == null")
    public List<Book> getAllBooks(int page, int size) {
        return bookRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "book", key = "'getByBookName-' + #bookName", unless = "#result == null")
    public List<Book> getByBookName(String bookName){
        bookName = "%" + bookName + "%";
        return bookRepository.getByBookName(bookName);
    }

    @Override
    @Cacheable(cacheNames = "book", key = "'getByBookId-' + #id", unless = "#result == null")
    public Book getByBookId(int id){
        return bookRepository.findById(id).get();
    }

    @Override
    @CacheEvict(cacheNames = "book", allEntries = true)
    public Book save(Book book){
        return bookRepository.save(book);
    }

    @Override
    @CacheEvict(cacheNames = "book", allEntries = true)
    public void delete(int id){
        bookRepository.deleteById(id);
    }



    /**
    * @Author Kami
    * @Description 用户借阅书籍功能，并将借阅记录写入借阅记录表,如果用户已经借阅了此书，则不能再借阅。
    * @Date 3:09 2020/6/24
    * @Param [bookId]
    * @return java.lang.String
    **/
    @Override
    public String bookBorrow(int bookId) {
        User user = userService.getUser();
        Book book = getByBookId(bookId);
        if(book.getQuantity() <= 0){
            return "fail";
        } else if(borrowRecordService.getByBookIdAndUserId(book.getId(), user.getId()) != null){
            return "exist";
        } else {
            book.setQuantity(book.getQuantity() - 1);
            save(book);
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            BorrowRecord borrowRecord = new BorrowRecord();
            borrowRecord.setBookId(book.getId());
            borrowRecord.setUserId(user.getId());
            borrowRecord.setBorrow_date(calendar.getTime());
            calendar.add(Calendar.DATE, 30);
            borrowRecord.setReturnDate(calendar.getTime());
            borrowRecordService.save(borrowRecord);
            return "success";
        }
    }

    /*
    * @Author Kami
    * @Description 用户归还书籍功能，并将归还记录写入归还记录表，如果归还时间超过规定的时间，则为逾期
    * @Date 6:24 2020/6/24
    * @Param [bookId]
    * @return java.lang.String
    **/
    @Override
    public String bookReturn(int bookId) {
        User user = userService.getUser();
        Book book = getByBookId(bookId);
        BorrowRecord borrowRecord = borrowRecordService.getByBookIdAndUserId(book.getId(), user.getId());
        if(borrowRecord == null){
            return "fail";
        } else{
            ReturnRecord returnRecord = new ReturnRecord();
            Date date = new Date();
            returnRecord.setBookId(book.getId());
            returnRecord.setUserId(user.getId());
            returnRecord.setReturnDate(date);
            if(borrowRecord.getReturnDate().compareTo(date) < 0){
                returnRecord.setIsOverdue(1);
            }
            returnRecordService.save(returnRecord);
            borrowRecord.setIsReturned(1);
            borrowRecordService.save(borrowRecord);
            book.setQuantity(book.getQuantity() + 1);
            save(book);
            return "success";
        }
    }
}
