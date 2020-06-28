package com.zsc.javaee_booktest.service;

import com.zsc.javaee_booktest.entity.BorrowRecord;

import java.util.List;

public interface BorrowRecordService {
    public List<BorrowRecord> getByBookId(int bookId);
    public List<BorrowRecord> getByUserId(int userId);
    public BorrowRecord getByBookIdAndUserId(int bookId, int userId);
    public BorrowRecord save(BorrowRecord borrowRecord);
}
