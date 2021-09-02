package com.accountmanager;

import controller.AccountController;
import entity.Department;
import entity.Position;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "service")
@RestController
@ComponentScan(basePackageClasses = AccountController.class)
@ComponentScan(basePackageClasses = Department.class)
@ComponentScan(basePackageClasses = Position.class)
@EntityScan("entity")
@EnableJpaRepositories("repository")
@Controller
public class AccountManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagerApplication.class, args);
    }

    @RequestMapping("/")
    String home(){
        return "hello api";
    }
}
