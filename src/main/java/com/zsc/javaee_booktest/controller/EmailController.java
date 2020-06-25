package com.zsc.javaee_booktest.controller;

import com.zsc.javaee_booktest.entity.User;
import com.zsc.javaee_booktest.service.SendEmailService;
import com.zsc.javaee_booktest.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
public class EmailController {
    @Autowired
    SendEmailService emailService;

    @Autowired
    private UserService userService;

    @Autowired
    TemplateEngine templateEngine;

    @GetMapping("/sendEmail")
    public String sendEmail() {
        User findUser = userService.getUser();
        String receiver = findUser.getEmail();
        String subject = "图书借阅系统注册账号验证码";
        Context context = new Context();
        context.setVariable("username", findUser.getUserName());
        context.setVariable("sex", findUser.getSex());
        String code = RandomString.make(5);
        context.setVariable("code", code);
        String emailContent = templateEngine.process("emailTemplate", context);
        emailService.sendEmail(receiver, subject, emailContent);
        return "邮件发送成功，校验码为：" + code;
    }
}
