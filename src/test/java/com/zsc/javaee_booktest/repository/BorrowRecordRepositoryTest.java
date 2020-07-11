package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.service.BorrowRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BorrowRecordRepositoryTest {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private BorrowRecordService borrowRecordService;

    @Test
    void findByBookIdAndUserId(){
        System.out.println(borrowRecordRepository.findByBookIdAndUserId(1,5));
    }

    @Test
    void test(){
        System.out.println(borrowRecordService.getBookById(2));
    }
}