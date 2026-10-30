package net.balmir.transactionservice.services;

import net.balmir.transactionservice.dto.TransactionRequestDTO;
import net.balmir.transactionservice.dto.TransactionResponseDTO;

import java.util.List;

public interface TransactionService {
    TransactionResponseDTO executeTransaction(TransactionRequestDTO requestDTO);
    List<TransactionResponseDTO> getTransactionsByRib(String rib);
}