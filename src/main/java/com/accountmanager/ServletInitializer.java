package com.accountmanager;

import controller.AccountController;
import controller.DepartmentController;
import controller.PositionController;
import dto.PositionDto;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.sources(AccountController.class);
        application.sources(DepartmentController.class);
        application.sources(PositionController.class);
        return application.sources(AccountManagerApplication.class);
    }

}
