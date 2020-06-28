package com.zsc.javaee_booktest.service.impl;

import com.zsc.javaee_booktest.entity.BorrowRecord;
import com.zsc.javaee_booktest.repository.BorrowRecordRepository;
import com.zsc.javaee_booktest.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Override
    @Cacheable(cacheNames = "borrowRecord", key = "'getByBookId' + #bookId")
    public List<BorrowRecord> getByBookId(int bookId) {
        return borrowRecordRepository.findByBookId(bookId);
    }

    @Override
    @Cacheable(cacheNames = "borrowRecord", key = "'getByBookId' + #userId")
    public List<BorrowRecord> getByUserId(int userId) {
        return borrowRecordRepository.findByUserId(userId);
    }

    @Override
    @Cacheable(cacheNames = "borrowRecord", key = "'getByBookIdAndUserId' + #bookId + '-' + #userId")
    public BorrowRecord getByBookIdAndUserId(int bookId, int userId){
        return borrowRecordRepository.findByBookIdAndUserId(bookId,userId);
    }

    @CachePut
    @Override
    @CacheEvict(cacheNames = "borrowRecord", allEntries = true)
    public BorrowRecord save(BorrowRecord borrowRecord) {
        return borrowRecordRepository.save(borrowRecord);
    }
}
