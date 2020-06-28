package com.zsc.javaee_booktest.controller;

import com.zsc.javaee_booktest.entity.BorrowRecord;
import com.zsc.javaee_booktest.service.BorrowRecordService;
import com.zsc.javaee_booktest.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowRecordService borrowRecordService;

    @GetMapping("/findByBookId/{bookId}/{page}/{size}")
    public Map<String, Object> findByBookId(@PathVariable int bookId, @PathVariable int page, @PathVariable int size){
        List<BorrowRecord> recordsBy = borrowRecordService.getByBookId(bookId);
        PageUtils pageUtils = new PageUtils();
        Map<String, Object> pageInfo = pageUtils.startPage(recordsBy, page, size);
        return pageInfo;
    }

    @GetMapping("/findByUserId/{userId}/{page}/{size}")
    public Map<String, Object> findByUserId(@PathVariable int userId, @PathVariable int page, @PathVariable int size){
        List<BorrowRecord> records = borrowRecordService.getByUserId(userId);
        PageUtils pageUtils = new PageUtils();
        Map<String, Object> pageInfo = pageUtils.startPage(records, page, size);
        return pageInfo;
    }

    @GetMapping("/findByUserId/{userId}")
    public BorrowRecord findByBookIdAndUserId(@PathVariable int bookId, @PathVariable int userId){
        BorrowRecord record = borrowRecordService.getByBookIdAndUserId(bookId, userId);
        return record;
    }

    @PostMapping("/save")
    public String save(@RequestBody BorrowRecord borrowRecord){
        BorrowRecord record = borrowRecordService.save(borrowRecord);
        if(record != null){
            return "success";
        } else{
            return "fail";
        }
    }
}
