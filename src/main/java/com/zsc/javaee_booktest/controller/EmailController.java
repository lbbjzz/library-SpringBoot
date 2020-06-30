package com.zsc.javaee_booktest.controller;

import com.zsc.javaee_booktest.entity.Book;
import com.zsc.javaee_booktest.entity.BorrowRecord;
import com.zsc.javaee_booktest.entity.User;
import com.zsc.javaee_booktest.repository.BookRepository;
import com.zsc.javaee_booktest.repository.BorrowRecordRepository;
import com.zsc.javaee_booktest.repository.UserRepository;
import com.zsc.javaee_booktest.service.BorrowRecordService;
import com.zsc.javaee_booktest.service.SendEmailService;
import com.zsc.javaee_booktest.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public String sendCodeEmail() {
        try {
            SendEmailService.ignoreSsl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        User findUser = userService.getUser();
        String receiver = findUser.getEmail();
        String subject = "图书借阅系统注册账号验证码";
        Context context = new Context();
        context.setVariable("username", findUser.getUserName());
        context.setVariable("sex", findUser.getSex());
        String code = RandomString.make(5);
        context.setVariable("code", code);
        String emailContent = templateEngine.process("email/codeEmail", context);
        emailService.sendEmail(receiver, subject, emailContent);
        return "邮件发送成功，校验码为：" + code;
    }

    //计算相隔时间
    public static int caculateTotalTime(String startTime,String endTime) {
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd");
        Date date1=null;
        Date date = null;
        Long l = 0L;
        try {
            date = sdf.parse(startTime);
            long ts = date.getTime();
            date1 =  sdf.parse(endTime);
            long ts1 = date1.getTime();
            l = (ts - ts1) / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return l.intValue();
    }

    //定时发送邮件
    @Scheduled(cron = "0 0 8 * * ?")
    @GetMapping("/sendReminderEmail")
    public String sendReminderEmail() throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd");
        Date date = new Date();
        String str=sdf.format(date);
        List<String> borrowRecords = borrowRecordService.getReturnDate();
        System.out.println(borrowRecords);
        for (int i = 0; i < borrowRecords.size(); i++) {
            int j = caculateTotalTime(borrowRecords.get(i).split("\\s+")[0], str);
            System.out.println("borrowRecords.size()=" + borrowRecords.size());
            System.out.println(borrowRecords.get(i).split("\\s+")[0]);
            System.out.println("j = " + j);
            if (j == 7) {
                List<Integer> userId = borrowRecordRepository.getUserId(borrowRecords.get(i));
                List<Integer> recordId = borrowRecordRepository.getId(borrowRecords.get(i));
                System.out.println(userId);
                for (int k = 0; k < recordId.size(); k++) {
                    try {
                        SendEmailService.ignoreSsl();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    for (int n = 0; n < userId.size(); n++) {
                        BorrowRecord findBorrowRecord = borrowRecordRepository.getRecord(recordId.get(k));
                        Book findBook = bookRepository.getByBookId(findBorrowRecord.getBookId());
                        User findUser = userRepository.getByUserId(findBorrowRecord.getUserId());
                        System.out.println(findUser);
                        System.out.println(findBook);
                        String receiver = findUser.getEmail();
                        String subject = "图书借阅系统提醒邮件";
                        Context context = new Context();
                        context.setVariable("username", findUser.getUserName());
                        context.setVariable("sex", findUser.getSex());
                        context.setVariable("bookname", findBook.getBookName());
                        String emailContent = templateEngine.process("email/reminderEmail", context);
                        emailService.sendEmail(receiver, subject, emailContent);
//                    }
                }
            }
        }
        return "邮件已发送";
    }

}
