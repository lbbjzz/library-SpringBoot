package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.Book;
import com.zsc.javaee_booktest.utils.PageUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class BookReposityTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());
    }

    @Test
    void findById(){
        Book book = bookRepository.findById(1).get();
        System.out.println(book);
    }

    @Test
    void save(){
        Book book = new Book();
        book.setBookName("qqqs");
        book.setAuthor("dddd");
        book.setPubHouse("yyyy");
        book.setPubDate("2001");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void update(){
        Book book = new Book();
        book.setId(3);
        book.setBookName("测试");
        book.setAuthor("测试");
        book.setPubHouse("测试");
        book.setPubDate("测试");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void delete(){
        bookRepository.deleteById(3);
    }

    @Test
    void testDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(sdf.format(calendar.getTime()));
        calendar.add(Calendar.DATE, 30);
        System.out.println(sdf.format(calendar.getTime()));
        try {
            Date d = sdf.parse(sdf.format(calendar.getTime()));
            System.out.println(d);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    void testPage()throws Exception{
        String a = "%E7%99%BD";
        String b = URLDecoder.decode(a, "UTF-8");
        System.out.println(bookRepository.findByBookNameLike("%行%"));
        System.out.println(bookRepository.getByBookName("%夜%"));
        System.out.println(bookRepository.getByBookName(b));
    }
}