package com.vinimanfrin.safeway.services.transaction;

import com.vinimanfrin.safeway.dtos.transaction.TransactionInputDTO;
import com.vinimanfrin.safeway.models.Transaction;

public interface TransactionService {
    Transaction saveTransaction(TransactionInputDTO transactionInput);
    Transaction getTransaction(String id);
}
