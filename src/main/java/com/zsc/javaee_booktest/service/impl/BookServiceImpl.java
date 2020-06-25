package com.zsc.javaee_booktest.service.impl;

import com.zsc.javaee_booktest.entity.Book;
import com.zsc.javaee_booktest.entity.BorrowRecord;
import com.zsc.javaee_booktest.entity.ReturnRecord;
import com.zsc.javaee_booktest.entity.User;
import com.zsc.javaee_booktest.repository.BookRepository;
import com.zsc.javaee_booktest.repository.BorrowRecordRepository;
import com.zsc.javaee_booktest.repository.ReturnRecordRepository;
import com.zsc.javaee_booktest.service.BookService;
import com.zsc.javaee_booktest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private ReturnRecordRepository returnRecordRepository;

    @Autowired
    private UserService userService;

    @Override
    @Cacheable(value = "getAllBooks")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
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
        Book book = bookRepository.findById(bookId).get();
        if(book.getQuantity() <= 0){
            return "fail";
        } else if(borrowRecordRepository.findByBookIdAndUserId(book.getId(), user.getId()) != null){
            return "exist";
        } else {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            System.out.println(calendar.getTime());
            BorrowRecord borrowRecord = new BorrowRecord();
            borrowRecord.setBookId(book.getId());
            borrowRecord.setUserId(user.getId());
            borrowRecord.setBorrow_date(calendar.getTime());
            calendar.add(Calendar.DATE, 30);
            System.out.println(calendar.getTime());
            borrowRecord.setReturnDate(calendar.getTime());
            borrowRecordRepository.save(borrowRecord);
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
        Book book = bookRepository.findById(bookId).get();
        BorrowRecord borrowRecord = borrowRecordRepository.findByBookIdAndUserId(book.getId(), user.getId());
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
            returnRecordRepository.save(returnRecord);
            borrowRecord.setIsReturned(1);
            borrowRecordRepository.save(borrowRecord);
            book.setQuantity(book.getQuantity() + 1);
            bookRepository.save(book);
            return "success";
        }
    }
}
