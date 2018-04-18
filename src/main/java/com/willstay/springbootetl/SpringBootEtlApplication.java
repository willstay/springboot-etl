package com.willstay.springbootetl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootEtlApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootEtlApplication.class, args);
    }
}
