package com.vinimanfrin.safeway.services.transaction.validation.integrity;

import com.vinimanfrin.safeway.dtos.transaction.TransactionInputDTO;

public interface IntegrityValidator {

    void validate(TransactionInputDTO transactionInput);
}
