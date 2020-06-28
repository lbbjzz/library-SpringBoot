package com.zsc.javaee_booktest.service;

import com.zsc.javaee_booktest.entity.ReturnRecord;

import java.util.List;

public interface ReturnRecordService {
    public List<ReturnRecord> getByBookId(int bookId);
    public List<ReturnRecord> getByUserId(int userId);
    public ReturnRecord getByBookIdAndUserId(int bookId, int userId);
    public ReturnRecord save(ReturnRecord returnRecord);
}
