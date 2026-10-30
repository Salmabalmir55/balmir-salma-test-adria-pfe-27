package net.balmir.accountservice.dto;


import lombok.Data;
import net.balmir.accountservice.enums.AccountStatus;

@Data
public class AccountRequestDTO {
    private String rib;
    private Double balance;
    private String currency;
    private AccountStatus status;
}