package net.balmir.accountservice.dto;


import lombok.Data;
import net.balmir.accountservice.enums.AccountStatus;

import java.time.LocalDateTime;

@Data
public class AccountResponseDTO {
    private Long id;
    private String rib;
    private Double balance;
    private String currency;
    private AccountStatus status;
    private LocalDateTime createdAt;
}