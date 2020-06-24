package com.zsc.javaee_booktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class JavaeeBooktestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaeeBooktestApplication.class, args);
    }

}
