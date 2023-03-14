package com.example.authentication;

import com.example.authentication.base.util.Print;
import com.example.authentication.config.DecodedToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;

@SpringBootApplication
public class AuthenticationApplication {

    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(AuthenticationApplication.class, args);
        DecodedToken token = DecodedToken.getDecoded("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb3VzYXZpOTYiLCJjcmVhdGVkIjoxNjc4NzIwMTMxODkxLCJ1c2VySWQiOjI4LCJpYXQiOjE2Nzg3MjAxMzEsImV4cCI6MTY3ODcyMTU3MX0.r918GIzhsK1cTyqwn-YrZHz1kj039-U5rsGe_aTxHdk");
        if (token.userId != null) {
            Print.print("userId", token.userId);
            System.out.println("Welcome sir " + "token.userId=" + token.userId);
        } else {
            System.out.println("Get out!!!");
        }
    }

}
