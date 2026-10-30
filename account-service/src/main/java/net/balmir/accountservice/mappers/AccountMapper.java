package net.balmir.accountservice.mappers;

import net.balmir.accountservice.dto.AccountRequestDTO;
import net.balmir.accountservice.dto.AccountResponseDTO;
import net.balmir.accountservice.entities.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public Account toEntity(AccountRequestDTO dto) {
        Account account = new Account();
        BeanUtils.copyProperties(dto, account);
        return account;
    }

    public AccountResponseDTO toDTO(Account account) {
        AccountResponseDTO dto = new AccountResponseDTO();
        BeanUtils.copyProperties(account, dto);
        return dto;
    }
}