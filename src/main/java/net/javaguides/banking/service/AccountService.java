package net.javaguides.banking.service;

import java.util.List;

import net.javaguides.banking.dto.Accountdto;


public interface AccountService {
    Accountdto createAccount(Accountdto accountdto);
    
    Accountdto getAccountById(Long id);

    Accountdto deposit(Long id,double amount);

    Accountdto withdraw(Long id,double amount);

    List<Accountdto> getAllAccounts();

    void deleteAccount(Long id);
}
