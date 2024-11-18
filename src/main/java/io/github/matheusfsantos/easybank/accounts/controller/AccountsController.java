package io.github.matheusfsantos.easybank.accounts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @GetMapping
    public ResponseEntity<String> getAccounts() {
        return ResponseEntity.ok().body("Hello, World!");
    }

}