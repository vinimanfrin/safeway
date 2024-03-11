package com.vinimanfrin.safeway.dtos;

import com.vinimanfrin.safeway.models.Company;

import java.math.BigDecimal;

public record CompanyDetailDTO(
        String id,
        String email,
        String firstName,
        String lastName,
        BigDecimal balance,
        String cnpj,
        BigDecimal fee

) {
    public CompanyDetailDTO(Company company) {
        this(company.getId(), company.getEmail(), company.getFirstName(), company.getLastName(), company.getBalance(), company.getCnpj(), company.getFee());
    }
}
