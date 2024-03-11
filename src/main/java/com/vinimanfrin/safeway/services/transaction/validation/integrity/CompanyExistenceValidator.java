package com.vinimanfrin.safeway.services.transaction.validation.integrity;

import com.vinimanfrin.safeway.dtos.transaction.TransactionInputDTO;
import com.vinimanfrin.safeway.infra.exceptions.TransactionValidationException;
import com.vinimanfrin.safeway.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyExistenceValidator implements IntegrityValidator{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void validate(TransactionInputDTO transactionInput) {
        if (!companyRepository.existsById(transactionInput.company_id())){
            throw new TransactionValidationException("a company com o id informado não existe");
        }
    }
}
