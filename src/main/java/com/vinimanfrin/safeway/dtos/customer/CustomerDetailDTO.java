package com.vinimanfrin.safeway.dtos.customer;

import com.vinimanfrin.safeway.models.Customer;

import java.math.BigDecimal;


public record CustomerDetailDTO(
        String id,
        String email,
        String firstName,
        String lastName,
        BigDecimal balance,
        String cpf
) {
    public CustomerDetailDTO(Customer customer) {
        this(customer.getId(), customer.getEmail(), customer.getFirstName(), customer.getLastName(), customer.getBalance(), customer.getCpf());
    }
}
