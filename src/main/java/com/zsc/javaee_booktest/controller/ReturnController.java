package com.zsc.javaee_booktest.controller;

import com.zsc.javaee_booktest.entity.ReturnRecord;
import com.zsc.javaee_booktest.service.ReturnRecordService;
import com.zsc.javaee_booktest.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/return")
public class ReturnController {
    @Autowired
    private ReturnRecordService returnRecordService;

    @GetMapping("/findByUserId/{userId}/{page}/{size}")
    public Map<String, Object> findByUserId(@PathVariable int userId, @PathVariable int page, @PathVariable int size){
        List<ReturnRecord> records = returnRecordService.getByUserId(userId);
        PageUtils pageUtils = new PageUtils();
        Map<String, Object> pageInfo = pageUtils.startPage(records, page, size);
        return pageInfo;
    }

    @GetMapping("/findByBookId/{userId}/{page}/{size}")
    public Map<String, Object> findByBookId(@PathVariable int bookId, @PathVariable int page, @PathVariable int size){
        List<ReturnRecord> records = returnRecordService.getByBookId(bookId);
        PageUtils pageUtils = new PageUtils();
        Map<String, Object> pageInfo = pageUtils.startPage(records, page, size);
        return pageInfo;
    }

    @GetMapping("/findByUserId/{bookId}/{userId}")
    public ReturnRecord findByUserId(@PathVariable int bookId, @PathVariable int userId){
        return returnRecordService.getByBookIdAndUserId(bookId, userId);
    }
}
