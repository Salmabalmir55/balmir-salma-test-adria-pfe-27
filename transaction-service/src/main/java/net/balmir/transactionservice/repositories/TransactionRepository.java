package net.balmir.transactionservice.repositories;

import net.balmir.transactionservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySourceRibOrDestinationRib(String sourceRib, String destinationRib);
}