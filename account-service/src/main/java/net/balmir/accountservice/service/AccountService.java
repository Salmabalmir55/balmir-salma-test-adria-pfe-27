package net.balmir.accountservice.service;


import net.balmir.accountservice.dto.AccountRequestDTO;
import net.balmir.accountservice.dto.AccountResponseDTO;

import java.util.List;

public interface AccountService {
    AccountResponseDTO createAccount(AccountRequestDTO requestDTO);
    AccountResponseDTO getAccountById(Long id);
    AccountResponseDTO getAccountByRib(String rib);
    List<AccountResponseDTO> getAllAccounts();
}
