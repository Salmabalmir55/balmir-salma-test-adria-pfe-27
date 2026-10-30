package net.balmir.transactionservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String rib;

    private String bankName;
    private String accountHolderRib; // RIB du propriétaire du compte qui enregistre ce bénéficiaire
}