package com.vinimanfrin.safeway.services.transaction.validation.business;


import com.vinimanfrin.safeway.models.Transaction;

public interface BusinessRulesValidator {

    void validate(Transaction transaction);
}
