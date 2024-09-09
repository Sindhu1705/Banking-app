package net.javaguides.banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "accounts")
@Entity
public class Account {
    @Id // id is made as a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment the id value
    private Long id;
    @Column(name="account_holder_name")
    private String accountHolderName;
    private double balance;
}
