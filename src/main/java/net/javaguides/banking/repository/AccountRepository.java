package net.javaguides.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.banking.entity.Account;
// performs CRUD operations on the entity(account)
public interface AccountRepository extends JpaRepository<Account, Long> {

}
