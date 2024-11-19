package io.github.matheusfsantos.easybank.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {
    @Id
    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "account_type", length = 100, nullable = false)
    private String accountType;

    @Column(name = "branch_address", length = 200, nullable = false)
    private String branchAddress;

    public Account(Long accountNumber, String accountType, String branchAddress) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.branchAddress = branchAddress;
    }
}
