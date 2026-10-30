package net.balmir.transactionservice.clients;

import net.balmir.transactionservice.clients.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountRestClient {
    @GetMapping("/api/accounts/rib/{rib}")
    AccountDTO getAccountByRib(@PathVariable("rib") String rib);
}