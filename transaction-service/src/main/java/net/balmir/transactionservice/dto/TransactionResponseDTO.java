package net.balmir.transactionservice.dto;

import net.balmir.transactionservice.enums.TransactionStatus;
import net.balmir.transactionservice.enums.TransactionType;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionResponseDTO {
    private Long id;
    private String sourceRib;
    private String destinationRib;
    private Double amount;
    private LocalDateTime timestamp;
    private TransactionType type;
    private TransactionStatus status;
}