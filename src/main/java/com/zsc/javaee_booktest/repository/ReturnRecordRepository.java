package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.ReturnRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRecordRepository extends JpaRepository<ReturnRecord, Integer> {
}
