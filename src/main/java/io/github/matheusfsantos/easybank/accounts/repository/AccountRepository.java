package io.github.matheusfsantos.easybank.accounts.repository;

import io.github.matheusfsantos.easybank.accounts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}