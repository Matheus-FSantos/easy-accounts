package io.github.matheusfsantos.easybank.accounts.repository;

import io.github.matheusfsantos.easybank.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
