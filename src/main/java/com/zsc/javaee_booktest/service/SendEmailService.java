package com.zsc.javaee_booktest.service;

import com.zsc.javaee_booktest.entity.User;

public interface SendEmailService {
    public void sendEmail(String receiver, String subject, String content);
    public String sendCodeEmail(User user) throws Exception;
    public String sendReminderEmail() throws Exception;
}
