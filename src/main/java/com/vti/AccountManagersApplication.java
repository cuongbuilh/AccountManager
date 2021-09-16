package com.vti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*")
public class AccountManagersApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagersApplication.class, args);
    }

}
