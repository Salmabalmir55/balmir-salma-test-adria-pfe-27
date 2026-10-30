package net.balmir.transactionservice.dto;

import net.balmir.transactionservice.enums.TransactionType;
import lombok.Data;

@Data
public class TransactionRequestDTO {
    private String sourceRib;
    private String destinationRib;
    private Double amount;
    private TransactionType type;
}