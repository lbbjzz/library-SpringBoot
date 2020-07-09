package com.zsc.javaee_booktest.service.impl;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zsc.javaee_booktest.entity.*;
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

    @Autowired
    private JPAQueryFactory queryFactory;

    QBook qBook = QBook.book;
    QBorrowRecord qBorrowRecord = QBorrowRecord.borrowRecord;
    QUser qUser = QUser.user;

    @Override
    @Cacheable(cacheNames = "borrowRecord", key = "'getBookById-' + #recordId")
    public List<Book> getBookById(int recordId) {
        Predicate predicate = qBorrowRecord.id.eq(recordId);
        List<Book> books = queryFactory.select(qBook)
                .from(qUser)
                .leftJoin(qBorrowRecord)
                .on(qBorrowRecord.userId.eq(qUser.id))
                .leftJoin(qBook)
                .on(qBorrowRecord.bookId.eq(qBook.id))
                .where(predicate)
                .fetch();
        return books;
    }

    @Override
    @Cacheable(cacheNames = "borrowRecord", key = "'getReturnDate'")
    public List<String> getReturnDate() {
        return borrowRecordRepository.getReturnDate();
    }

    @Override
    @Cacheable(cacheNames = "borrowRecord", key = "'getByBookId-' + #bookId", unless = "#result == null")
    public List<BorrowRecord> getByBookId(int bookId) {
        return borrowRecordRepository.findByBookId(bookId);
    }

    @Override
    @Cacheable(cacheNames = "borrowRecord", key = "'getByUserId-' + #userId", unless = "#result == null")
    public List<BorrowRecord> getByUserId(int userId) {
        return borrowRecordRepository.findByUserId(userId);
    }

    @Override
    @Cacheable(cacheNames = "borrowRecord", key = "'getByBookIdAndUserId-' + #bookId + '-' + #userId", unless = "#result == null")
    public BorrowRecord getByBookIdAndUserId(int bookId, int userId){
        return borrowRecordRepository.findByBookIdAndUserId(bookId,userId);
    }

    @Override
    @CacheEvict(cacheNames = "borrowRecord", allEntries = true)
    public BorrowRecord save(BorrowRecord borrowRecord) {
        return borrowRecordRepository.save(borrowRecord);
    }
}
