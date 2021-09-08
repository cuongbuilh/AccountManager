package service;

import entity.Account;
import form.AccountFormForCreating;
import form.AccountFromForUpdating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import repository.IAccountRepository;
import repository.IDepartmentRepository;
import repository.IPositionRepository;
import specification.AccountSpecification;


import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IDepartmentRepository departmentRepository;
    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public Page<Account> getAllAccount(Pageable pageable, String search) {
        Specification<Account> where = null;

        if (search != null) {
            AccountSpecification nameSpecification = new AccountSpecification("fullname", "LIKE", search);
            AccountSpecification emailSpecification = new AccountSpecification("email", "LIKE", search);
            AccountSpecification departmentSpecification = new AccountSpecification("department.name", "LIKE", search);
            where = Specification.where(nameSpecification).or(emailSpecification).or(departmentSpecification);
        }

        return accountRepository.findAll(where, pageable);
    }

    @Override
    public Account getAccountById(short id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void createAccount(AccountFormForCreating form) {
        Account newAccount = new Account();
        newAccount.setUsername(form.getUsername());
        newAccount.setFullname(form.getFullname());
        newAccount.setEmail( form.getEmail());
        newAccount.setDepartment(departmentRepository.findById(form.getDepartmentId()).get());
        newAccount.setPosition(positionRepository.findById(form.getPositionId()).get());
        accountRepository.save(newAccount);
    }

    @Override
    public void updateAccount(short id, AccountFromForUpdating form) {
        Account account = accountRepository.findById(id).get();
        account.setFullname(form.getFullname());
        account.setDepartment(departmentRepository.getById(form.getDepartmentId()));
        account.setPosition(positionRepository.getById(form.getPositionId()));
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(short id) {
        accountRepository.deleteById(id);
    }
}
