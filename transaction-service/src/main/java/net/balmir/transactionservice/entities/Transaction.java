package net.balmir.transactionservice.entities;

import jakarta.persistence.*;
import net.balmir.transactionservice.enums.TransactionStatus;
import lombok.*;
import net.balmir.transactionservice.enums.TransactionType;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceRib;
    private String destinationRib;
    private Double amount;
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
}