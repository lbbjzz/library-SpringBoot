package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {
    public BorrowRecord findByBookIdAndUserId(int bookId, int userId);
}
