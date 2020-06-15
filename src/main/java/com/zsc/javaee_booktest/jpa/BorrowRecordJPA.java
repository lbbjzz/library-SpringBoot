package com.zsc.javaee_booktest.jpa;

import com.zsc.javaee_booktest.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordJPA extends JpaRepository<BorrowRecord, Integer> {
}
