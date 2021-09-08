package controller;

import com.accountmanager.AccountManagerApplication;
import com.fasterxml.jackson.annotation.JsonFormat;
import dto.AccountDto;
import entity.Account;
import form.AccountFormForCreating;
import form.AccountFromForUpdating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHeadResponseDecorator;
import org.springframework.web.bind.annotation.*;
import service.IAccountService;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerResponseContext;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @CrossOrigin("*")
    @GetMapping()
    public ResponseEntity<?> getAllAccount(Pageable pageable, @RequestParam(required = false) String search) {
//        List<Account> entities = accountService.getAllAccount();
        Page<Account> entities = accountService.getAllAccount(pageable, search);
//        List<AccountDto> dtos = new ArrayList<>();
//
//        // convert entities --> dtos
//        for (Account account : entities) {
//            AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(),
//                    account.getFullname(), account.getDepartment().getName(),
//                    account.getPosition().getName().toString(), account.getCreateDate());
//            dtos.add(dto);
//        }
        Page<AccountDto> dtoPage = entities.map(new Function<Account, AccountDto>() {
            @Override
            public AccountDto apply(Account account) {
                AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(),
                        account.getFullname(), account.getDepartment().getName(),
                        account.getPosition().getName().toString(), account.getCreateDate());
                return dto;
            }
        });

        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAccountByID(@PathVariable(name = "id") short id) {
        Account account = accountService.getAccountById(id);
        if (account == null)
            return new ResponseEntity<>(new AccountDto(), HttpStatus.NO_CONTENT);

        AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(), account.getFullname(),
                account.getDepartment().getName(), account.getPosition().getName().toString(), account.getCreateDate());
        return new ResponseEntity<AccountDto>(dto, HttpStatus.OK);
    }


    @CrossOrigin("*")
    @PostMapping()
    public ResponseEntity<?> createDepartment(@RequestBody AccountFormForCreating form ) {
        System.out.println(form);
        accountService.createAccount(form);
        return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
    }


    @CrossOrigin("*")
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,
                                               @RequestBody AccountFromForUpdating form) {
        accountService.updateAccount(id, form);

        System.out.println("updateID: "+id);
        System.out.println(form);
        ResponseEntity<String> response = new ResponseEntity<>("success",HttpStatus.OK);
        return response;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }

}
