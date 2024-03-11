package com.vinimanfrin.safeway.dtos.transaction;

import com.vinimanfrin.safeway.dtos.company.CompanyDetailDTO;
import com.vinimanfrin.safeway.dtos.customer.CustomerDetailDTO;
import com.vinimanfrin.safeway.models.Transaction;
import com.vinimanfrin.safeway.models.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDetailDTO(
        String id,
        CompanyDetailDTO company,
        CustomerDetailDTO customer,
        TransactionType type,
        BigDecimal value,
        LocalDateTime dateTime
) {
    public TransactionDetailDTO(Transaction transaction) {
        this(transaction.getId(), new CompanyDetailDTO(transaction.getCompany()),new CustomerDetailDTO(transaction.getCustomer()), transaction.getType(), transaction.getValue(), transaction.getDateTime());
    }
}
