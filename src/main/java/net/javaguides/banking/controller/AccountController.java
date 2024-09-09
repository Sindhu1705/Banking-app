package net.javaguides.banking.controller;
import net.javaguides.banking.service.AccountService;
import net.javaguides.banking.dto.Accountdto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }
    //Add account Rest API
    
    @PostMapping
    public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountdto){
        return new ResponseEntity<>(accountService.createAccount(accountdto), HttpStatus.CREATED);

    }
    // Get Account API
    @GetMapping("/{id}")
    public ResponseEntity<Accountdto> getAccountById(@PathVariable Long id){
        Accountdto accountdto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountdto);
    }
    // Desposit API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<Accountdto> deposit(@PathVariable Long id,
                                      @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");                               
        Accountdto accountdto = accountService.deposit(id,amount);
        return ResponseEntity.ok(accountdto);
    }

    // Withdraw API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Accountdto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request){
        Double amount=request.get("amount");
        Accountdto accountdto = accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountdto);

    }
    //Get All accounts Api
    @GetMapping
    public ResponseEntity<List<Accountdto>> getAllAccounts(){
        List<Accountdto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //Delete Account Api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted");
    }
}
