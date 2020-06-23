package com.zsc.javaee_booktest.service.impl;

import com.zsc.javaee_booktest.entity.Book;
import com.zsc.javaee_booktest.entity.BorrowRecord;
import com.zsc.javaee_booktest.entity.User;
import com.zsc.javaee_booktest.repository.BookRepository;
import com.zsc.javaee_booktest.repository.BorrowRecordRepository;
import com.zsc.javaee_booktest.service.BookService;
import com.zsc.javaee_booktest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private UserService userService;

    /**
    * @Author Kami
    * @Description
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
}
