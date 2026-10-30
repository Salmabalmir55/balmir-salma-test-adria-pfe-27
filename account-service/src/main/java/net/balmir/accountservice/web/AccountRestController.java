package net.balmir.accountservice.web;


import lombok.RequiredArgsConstructor;
import net.balmir.accountservice.dto.AccountRequestDTO;
import net.balmir.accountservice.dto.AccountResponseDTO;
import net.balmir.accountservice.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO requestDTO) {
        return new ResponseEntity<>(accountService.createAccount(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping("/rib/{rib}")
    public ResponseEntity<AccountResponseDTO> getAccountByRib(@PathVariable String rib) {
        return ResponseEntity.ok(accountService.getAccountByRib(rib));
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
}