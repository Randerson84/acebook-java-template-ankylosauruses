package com.makersacademy.acebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages ={""})
@SpringBootApplication
@ComponentScan(basePackages ={""})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
