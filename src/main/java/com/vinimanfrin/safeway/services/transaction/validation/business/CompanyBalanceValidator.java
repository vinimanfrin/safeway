package com.vinimanfrin.safeway.services.transaction.validation.business;

import com.vinimanfrin.safeway.infra.exceptions.TransactionValidationException;
import com.vinimanfrin.safeway.models.Transaction;
import com.vinimanfrin.safeway.models.TransactionType;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;


@Component
public class CompanyBalanceValidator implements BusinessRulesValidator{

    @Override
    public void validate(Transaction transaction) {
        var feeValue = transaction.getCompany().getFee().multiply(transaction.getValue());
        var valueWithFee = feeValue.add(transaction.getValue());
        if (transaction.getType() == TransactionType.WITHDRAW &&
                transaction.getCompany().getBalance().compareTo(valueWithFee) < 0){
                throw new TransactionValidationException("saldo insuficiente para o saque com o valor de: " + transaction.getValue() + " + taxa: " + String.format("%.2f", feeValue));
            }
        }
}

