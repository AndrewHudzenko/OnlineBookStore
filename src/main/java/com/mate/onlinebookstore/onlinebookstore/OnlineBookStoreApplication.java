package com.mate.onlinebookstore.onlinebookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class OnlineBookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookStoreApplication.class, args);
    }

}
