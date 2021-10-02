package com.vti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@CrossOrigin("*")
@RestController("/")
public class AccountManagersApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountManagersApplication.class, args);
    }

    @GetMapping()
    public String existsByName() {
        return "hello API";
    }
}
