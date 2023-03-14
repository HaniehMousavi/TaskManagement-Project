package com.example.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.io.UnsupportedEncodingException;

//@SpringBootApplication
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PersistenceApplication {

    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(PersistenceApplication.class, args);
    }
}
