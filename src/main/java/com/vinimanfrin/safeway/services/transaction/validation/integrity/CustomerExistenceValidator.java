package com.vinimanfrin.safeway.services.transaction.validation.integrity;

import com.vinimanfrin.safeway.dtos.transaction.TransactionInputDTO;
import com.vinimanfrin.safeway.infra.exceptions.TransactionValidationException;
import com.vinimanfrin.safeway.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerExistenceValidator implements IntegrityValidator{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void validate(TransactionInputDTO transactionInput) {
        if (!customerRepository.existsById(transactionInput.customer_id())){
            throw new TransactionValidationException("o customer com o id informado não existe");
        }
    }
}
