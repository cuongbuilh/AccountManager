package service;

import entity.Account;
import form.AccountFormForCreating;
import form.AccountFromForUpdating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IAccountService  {
    public Page<Account> getAllAccount(Pageable pageable);

    public Account getAccountById(short id);
    //
//	public Account getAccountByName(String name);
//
    public void createAccount(AccountFormForCreating form);

    public void updateAccount(short id, AccountFromForUpdating form);

    public void deleteAccount(short id);
//
//	public boolean isAccountExistsByID(short id);
//
//	public boolean isAccountExistsByName(String name);

}
