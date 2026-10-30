package net.balmir.accountservice;

import net.balmir.accountservice.entities.Account;
import net.balmir.accountservice.enums.AccountStatus;
import net.balmir.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountRepository accountRepository) {
        return args -> {
            accountRepository.save(Account.builder()
                    .rib("123456789012345678901234")
                    .balance(5000.0)
                    .currency("MAD")
                    .status(AccountStatus.ACTIVE)
                    .createdAt(LocalDateTime.now())
                    .build());

            accountRepository.save(Account.builder()
                    .rib("987654321098765432109876")
                    .balance(12000.0)
                    .currency("MAD")
                    .status(AccountStatus.CREATED)
                    .createdAt(LocalDateTime.now())
                    .build());
        };
    }
}