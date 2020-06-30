package com.zsc.javaee_booktest.controller;

import com.zsc.javaee_booktest.repository.BookRepository;
import com.zsc.javaee_booktest.repository.BorrowRecordRepository;
import com.zsc.javaee_booktest.repository.UserRepository;
import com.zsc.javaee_booktest.service.BorrowRecordService;
import com.zsc.javaee_booktest.service.SendEmailService;
import com.zsc.javaee_booktest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;

@RestController
public class EmailController {
    @Autowired
    SendEmailService emailService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BorrowRecordService borrowRecordService;

    @Autowired
    BorrowRecordRepository borrowRecordRepository;

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/sendCodeEmail")
    public String sendCodeEmail() throws Exception {
        return emailService.sendCodeEmail();
    }

    @GetMapping("/sendReminderEmail")
    public String sendReminderEmail() throws Exception {
        return emailService.sendReminderEmail();
    }

}
