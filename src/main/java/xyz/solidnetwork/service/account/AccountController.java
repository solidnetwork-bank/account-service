package xyz.solidnetwork.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xyz.solidnetwork.service.transaction.Report;

@RestController
@Slf4j
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/transaction")
    public Report getTransaction() {
        log.info("transaction is requested");
        return accountService.getReport();
    }
}
