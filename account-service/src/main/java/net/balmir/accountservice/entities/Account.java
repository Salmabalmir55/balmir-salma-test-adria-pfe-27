package net.balmir.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.balmir.accountservice.enums.AccountStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String rib;

    private Double balance;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    private LocalDateTime createdAt;
}
