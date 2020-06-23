package com.zsc.javaee_booktest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BorrowRecordRepositoryTest {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Test
    void findByBookIdAndUserId(){
        System.out.println(borrowRecordRepository.findByBookIdAndUserId(1,5));
    }
}