package net.javaguides.banking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.dto.Accountdto;
import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.AccountService;
import net.javaguides.banking.mapper.AccountMapper;
@Service // automatically create spring bean for the class
public class AccountServiceimpl implements AccountService  {
    
    private AccountRepository accountRepository;

    public AccountServiceimpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public Accountdto createAccount(Accountdto accountdto) {
        Account account = AccountMapper.mapToAccount(accountdto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountdto(savedAccount);
    }


    @Override
    public Accountdto getAccountById(Long id) {
      Account account = accountRepository
         .findById(id)
         .orElseThrow(() -> new RuntimeException("Account does not exist"));
      return AccountMapper.mapToAccountdto(account);
    }


    @Override
    public Accountdto deposit(Long id, double amount) {
        Account account = accountRepository
         .findById(id)
         .orElseThrow(() -> new RuntimeException("Account does not exist"));
        double total = account.getBalance() + amount; 
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountdto(savedAccount);
    }


    @Override
    public Accountdto withdraw(Long id, double amount) {
        Account account = accountRepository
         .findById(id)
         .orElseThrow(() -> new RuntimeException("Account does not exist"));
        if(account.getBalance() < amount){
            throw new RuntimeException("Insuffcicient balance");

        }
        double total = account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountdto(savedAccount);

    }


    @Override
    public List<Accountdto> getAllAccounts() {
       List<Account> accounts = accountRepository.findAll();
       return accounts.stream().map((account) -> AccountMapper.mapToAccountdto(account))
              .collect(Collectors.toList());    
    }


    @Override
    public void deleteAccount(Long id) {
        @SuppressWarnings("unused")
        Account account = accountRepository
         .findById(id)
         .orElseThrow(() -> new RuntimeException("Account does not exist"));
        accountRepository.deleteById(id);
    }
    

}
