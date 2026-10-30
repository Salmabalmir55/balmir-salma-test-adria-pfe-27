package net.balmir.accountservice.service;


import lombok.RequiredArgsConstructor;
import net.balmir.accountservice.dto.AccountRequestDTO;
import net.balmir.accountservice.dto.AccountResponseDTO;
import net.balmir.accountservice.entities.Account;
import net.balmir.accountservice.mappers.AccountMapper;
import net.balmir.accountservice.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO requestDTO) {
        Account account = accountMapper.toEntity(requestDTO);
        account.setCreatedAt(LocalDateTime.now());
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toDTO(savedAccount);
    }

    @Override
    public AccountResponseDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé pour l'ID: " + id));
        return accountMapper.toDTO(account);
    }

    @Override
    public AccountResponseDTO getAccountByRib(String rib) {
        Account account = accountRepository.findByRib(rib)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé pour le RIB: " + rib));
        return accountMapper.toDTO(account);
    }

    @Override
    public List<AccountResponseDTO> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(accountMapper::toDTO)
                .toList();
    }
}