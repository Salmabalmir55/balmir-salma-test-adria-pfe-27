package net.balmir.transactionservice.services;

import net.balmir.transactionservice.clients.AccountDTO;
import net.balmir.transactionservice.clients.AccountRestClient;
import net.balmir.transactionservice.dto.TransactionRequestDTO;
import net.balmir.transactionservice.dto.TransactionResponseDTO;
import net.balmir.transactionservice.entities.Transaction;
import net.balmir.transactionservice.enums.TransactionStatus;
import net.balmir.transactionservice.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRestClient accountRestClient;

    @Override
    public TransactionResponseDTO executeTransaction(TransactionRequestDTO requestDTO) {
        // Vérification du compte source via le client Feign
        AccountDTO sourceAccount = accountRestClient.getAccountByRib(requestDTO.getSourceRib());
        if (sourceAccount == null) {
            throw new RuntimeException("Compte source inexistant");
        }

        Transaction transaction = Transaction.builder()
                .sourceRib(requestDTO.getSourceRib())
                .destinationRib(requestDTO.getDestinationRib())
                .amount(requestDTO.getAmount())
                .type(requestDTO.getType())
                .timestamp(LocalDateTime.now())
                .status(TransactionStatus.COMPLETED)
                .build();

        Transaction savedTransaction = transactionRepository.save(transaction);

        TransactionResponseDTO responseDTO = new TransactionResponseDTO();
        BeanUtils.copyProperties(savedTransaction, responseDTO);
        return responseDTO;
    }

    @Override
    public List<TransactionResponseDTO> getTransactionsByRib(String rib) {
        return transactionRepository.findBySourceRibOrDestinationRib(rib, rib).stream()
                .map(t -> {
                    TransactionResponseDTO dto = new TransactionResponseDTO();
                    BeanUtils.copyProperties(t, dto);
                    return dto;
                })
                .toList();
    }
}