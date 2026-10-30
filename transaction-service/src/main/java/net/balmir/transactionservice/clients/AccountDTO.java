package net.balmir.transactionservice.clients;

import lombok.Data;

@Data
public class AccountDTO {
    private Long id;
    private String rib;
    private Double balance;
    private String currency;
    private String status;
}