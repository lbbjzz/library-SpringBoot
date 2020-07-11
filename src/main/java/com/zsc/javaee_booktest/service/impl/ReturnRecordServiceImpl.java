package com.zsc.javaee_booktest.service.impl;

import com.zsc.javaee_booktest.entity.ReturnRecord;
import com.zsc.javaee_booktest.repository.ReturnRecordRepository;
import com.zsc.javaee_booktest.service.ReturnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnRecordServiceImpl implements ReturnRecordService {
    @Autowired
    private ReturnRecordRepository returnRecordRepository;

    @Override
    @Cacheable(cacheNames = "returnRecord", key = "'getByBookId' + #bookId")
    public List<ReturnRecord> getByBookId(int bookId) {
        return returnRecordRepository.findByBookId(bookId);
    }

    @Override
    @Cacheable(cacheNames = "returnRecord", key = "'getByBookId' + #userId")
    public List<ReturnRecord> getByUserId(int userId) {
        return returnRecordRepository.findByUserId(userId);
    }

    @Override
    @Cacheable(cacheNames = "returnRecord", key = "'getByBookIdAndUserId' + #bookId + '-' + #userId")
    public ReturnRecord getByBookIdAndUserId(int bookId, int userId) {
        return returnRecordRepository.findByBookIdAndUserId(bookId, userId);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames = "returnRecord", allEntries = true),
            @CacheEvict(cacheNames = "book", allEntries = true)
    })
    public ReturnRecord save(ReturnRecord returnRecord) {
        return returnRecordRepository.save(returnRecord);
    }
}
