package service;

import entity.Account;
import form.AccountFormForCreating;
import form.AccountFromForUpdating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IAccountRepository;
import repository.IDepartmentRepository;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IDepartmentRepository departmentRepository;
    @Autowired
    private IPositionService possitionRepository;

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(short id) {
        return null;
    }

    @Override
    public void createAccount(AccountFormForCreating form) {

    }

    @Override
    public void updateAccount(short id, AccountFromForUpdating form) {

    }

    @Override
    public void deleteAccount(short id) {

    }
}
