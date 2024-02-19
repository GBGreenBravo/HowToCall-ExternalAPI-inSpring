package com.kernel360_seminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.kernel360_seminar")
//@EnableFeignClients(basePackages = "com.kernel360_seminar")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}