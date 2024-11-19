package io.github.matheusfsantos.easybank.accounts.service.impl;

import io.github.matheusfsantos.easybank.accounts.constants.AccountsConstants;
import io.github.matheusfsantos.easybank.accounts.dto.CustomerDto;
import io.github.matheusfsantos.easybank.accounts.entity.Account;
import io.github.matheusfsantos.easybank.accounts.entity.Customer;
import io.github.matheusfsantos.easybank.accounts.exception.CustomerAlreadyExistsException;
import io.github.matheusfsantos.easybank.accounts.mapper.CustomerMapper;
import io.github.matheusfsantos.easybank.accounts.repository.AccountsRepository;
import io.github.matheusfsantos.easybank.accounts.repository.CustomersRepository;
import io.github.matheusfsantos.easybank.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {
    private final AccountsRepository accountsRepository;
    private final CustomersRepository customersRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        if(customersRepository.findByMobileNumber(customerDto.getMobileNumber()).isPresent())
            throw new CustomerAlreadyExistsException("Customer already registered with given mobile number: " + customerDto.getMobileNumber());

        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = this.customersRepository.save(customer);
        this.accountsRepository.save(this.createNewAccount(savedCustomer));
    }

    /**
     * Creates a new bank account for the specified customer.<br/><br/>
     * The created account is of type "Savings" and is associated with the (GENERIC) customer's address.
     * The account number is generated randomly, with a value between 1,000,000,000 and 1,999,999,999.
     *
     * @param customer Customer for whom the account will be created.
     * @return Newly created bank account.
     */
    private Account createNewAccount(Customer customer) {
        long randomAccountNumber = 1000000000L + new Random().nextInt(900000000);
        Account newAccount = new Account(randomAccountNumber, customer.getId(), AccountsConstants.SAVINGS, AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }
}
