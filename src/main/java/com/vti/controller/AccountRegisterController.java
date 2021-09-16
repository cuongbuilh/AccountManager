package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForCreatingRegister;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accountsRegister")
@CrossOrigin("*")
public class AccountRegisterController {

    @Autowired
    private IAccountService accountService;

    @PostMapping()
    public ResponseEntity<?> createDepartment(@RequestBody AccountFormForCreatingRegister form) {
        accountService.createAccountRegister(form);
        return new ResponseEntity<String>("We have sent 1 email. Please check email to active account!", HttpStatus.CREATED);
    }

    @GetMapping("/userRegistrationConfirmRequest")
    // validate: email exists, email not active
    public ResponseEntity<?> sendConfirmRegistrationViaEmail(@RequestParam String email) {
        if( email == null)
            return new ResponseEntity<>("Email has been not null", HttpStatus.BAD_REQUEST);

        if( !accountService.existsByEmail(email) )
            return new ResponseEntity<>("Email does not have", HttpStatus.BAD_REQUEST);


        accountService.sendConfirmUserRegistrationViaEmail(email);

        return new ResponseEntity<>("We have sent 1 email. Please check email to active account!", HttpStatus.OK);
    }



    @GetMapping("/activeUser")
    public ResponseEntity<?> activeUserViaEmail(@RequestParam String token) {

        // active user
        accountService.activeUser(token);

        return new ResponseEntity<>("Active success!", HttpStatus.OK);
    }
}

