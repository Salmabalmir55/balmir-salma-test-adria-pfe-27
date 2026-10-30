package net.balmir.transactionservice.repositories;

import net.balmir.transactionservice.entities.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
    List<Beneficiary> findByAccountHolderRib(String accountHolderRib);
}