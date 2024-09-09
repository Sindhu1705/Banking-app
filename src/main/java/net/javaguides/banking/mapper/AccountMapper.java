package net.javaguides.banking.mapper;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.dto.Accountdto;


public class AccountMapper {
    // covert dto to entity
    public static Account mapToAccount(Accountdto accountdto){
        Account account = new Account(
            accountdto.getId(),
            accountdto.getAccountHolderName(),
            accountdto.getBalance()
        );
        return account;
    
    
    }
    //convert entity to dto
    public static Accountdto mapToAccountdto(Account account){
        Accountdto accountdto = new Accountdto(
            account.getId(),
            account.getAccountHolderName(),
            account.getBalance()

    
        );
        return accountdto;
    }
    
    
}
