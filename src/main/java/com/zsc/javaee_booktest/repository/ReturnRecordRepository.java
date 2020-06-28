package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.ReturnRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReturnRecordRepository extends JpaRepository<ReturnRecord, Integer> {
    public ReturnRecord findByBookIdAndUserId(int bookId, int userId);
    public List<ReturnRecord> findByBookId(int bookId);
    public List<ReturnRecord> findByUserId(int userId);
}
