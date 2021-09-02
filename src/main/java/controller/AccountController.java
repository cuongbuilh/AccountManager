package controller;

import com.accountmanager.AccountManagerApplication;
import dto.AccountDto;
import entity.Account;
import form.AccountFormForCreating;
import form.AccountFromForUpdating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IAccountService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping()
    public ResponseEntity<?> getAllAccount() {
        List<Account> entities = accountService.getAllAccount();

        List<AccountDto> dtos = new ArrayList<>();

        // convert entities --> dtos
        for (Account account : entities) {
            AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(),
                    account.getFullname(), account.getDepartment().getName(),
                    account.getPosition().getName().toString(), account.getCreateDate());
            dtos.add(dto);
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAccountByID(@PathVariable(name = "id") short id) {
        Account account = accountService.getAccountById(id);
        AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(), account.getFullname(),
                account.getDepartment().getName(), account.getPosition().getName().toString(), account.getCreateDate());
        return new ResponseEntity<AccountDto>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createDepartment(@RequestBody AccountFormForCreating form) {
        accountService.createAccount(form);
        return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,
                                              @RequestBody AccountFromForUpdating form) {
        accountService.updateAccount(id, form);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }

}
