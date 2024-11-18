package io.github.matheusfsantos.easybank.accounts.dto;

public record AccountDto(
    Long accountNumber,
    String accountType,
    String branchAddress
) {}
