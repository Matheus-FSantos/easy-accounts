package io.github.matheusfsantos.easybank.accounts.service;

import io.github.matheusfsantos.easybank.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     * Creates a new account based on the information provided in the `CustomerDto` object.
     *
     * @param customerDto - `CustomerDto` object containing the customer's information.
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Retrieves the account details of the customer based on the provided mobile number.
     *
     * @param mobileNumber The customer's mobile phone number.
     * @return A CustomerDto object containing the customer's account details.
     */
    CustomerDto fetchAccountDetails(String mobileNumber);
}
