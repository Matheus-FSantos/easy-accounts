package io.github.matheusfsantos.easybank.accounts.controller;

import io.github.matheusfsantos.easybank.accounts.constants.AccountsConstants;
import io.github.matheusfsantos.easybank.accounts.dto.CustomerDto;
import io.github.matheusfsantos.easybank.accounts.dto.ResponseDto;
import io.github.matheusfsantos.easybank.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
public class AccountsController {
    private final IAccountsService iAccountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        this.iAccountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }
}
