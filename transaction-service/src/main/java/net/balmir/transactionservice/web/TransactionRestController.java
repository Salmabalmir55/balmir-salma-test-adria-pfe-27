package net.balmir.transactionservice.web;

import net.balmir.transactionservice.dto.TransactionRequestDTO;
import net.balmir.transactionservice.dto.TransactionResponseDTO;
import net.balmir.transactionservice.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionRestController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody TransactionRequestDTO requestDTO) {
        return new ResponseEntity<>(transactionService.executeTransaction(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/account/{rib}")
    public ResponseEntity<List<TransactionResponseDTO>> getTransactionsByRib(@PathVariable String rib) {
        return ResponseEntity.ok(transactionService.getTransactionsByRib(rib));
    }
}