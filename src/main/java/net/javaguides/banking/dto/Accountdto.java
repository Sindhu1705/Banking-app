package net.javaguides.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data   //to automatically generate constructors, getters and setters
@AllArgsConstructor
public class Accountdto {
    private Long id;
    private String accountHolderName;
    private double balance;

}
