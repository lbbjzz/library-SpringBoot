package com.zsc.javaee_booktest.jpa;

import com.zsc.javaee_booktest.entity.ReturnRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRecordJPA extends JpaRepository<ReturnRecord, Integer> {
}
