package com.pramati.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@ComponentScan("com.pramati.test")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class App {
    public static void main(String args[]){
        SpringApplication.run(App.class, args);
    }

}
