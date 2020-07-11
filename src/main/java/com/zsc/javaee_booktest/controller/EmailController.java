package com.zsc.javaee_booktest.controller;

import com.zsc.javaee_booktest.entity.User;
import com.zsc.javaee_booktest.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    SendEmailService sendEmailService;

    @GetMapping("/sendCodeEmail")
    public String sendCodeEmail(@RequestBody User user) throws Exception {
        return sendEmailService.sendCodeEmail(user);
    }

    @GetMapping("/sendReminderEmail")
    public String sendReminderEmail() throws Exception {
        return sendEmailService.sendReminderEmail();
    }

}
