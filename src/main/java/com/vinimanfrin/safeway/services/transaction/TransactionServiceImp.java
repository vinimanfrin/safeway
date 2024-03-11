package com.vinimanfrin.safeway.services.transaction;

import com.vinimanfrin.safeway.dtos.transaction.TransactionDetailDTO;
import com.vinimanfrin.safeway.dtos.transaction.TransactionInputDTO;
import com.vinimanfrin.safeway.models.Transaction;
import com.vinimanfrin.safeway.repositories.TransactionRepository;
import com.vinimanfrin.safeway.services.callback.CallBackDTO;
import com.vinimanfrin.safeway.services.callback.CallBackService;
import com.vinimanfrin.safeway.services.company.CompanyServiceImp;
import com.vinimanfrin.safeway.services.customer.CustomerServiceImp;
import com.vinimanfrin.safeway.services.transaction.validation.business.BusinessRulesValidator;
import com.vinimanfrin.safeway.services.transaction.validation.integrity.IntegrityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerServiceImp customerService;

    @Autowired
    private CompanyServiceImp companyService;

    @Autowired
    private List<IntegrityValidator> integrityValidators;

    @Autowired
    private List<BusinessRulesValidator> businessRulesValidators;

    @Autowired
    private CallBackService callBackService;

    @Override
    public Transaction saveTransaction(TransactionInputDTO transactionInput) {
        integrityValidators.forEach(v -> v.validate(transactionInput));

        var customer = customerService.getCustomer(transactionInput.customer_id());
        var company = companyService.getCompany(transactionInput.company_id());
        var transaction = new Transaction(transactionInput, company, customer);

        businessRulesValidators.forEach(v -> v.validate(transaction));

        company.updateBalance(transaction);

        transactionRepository.save(transaction);

        callBackService.sendCallBack(new CallBackDTO("transação efetuada com sucesso", new TransactionDetailDTO(transaction)));

        return transaction;
    }

    @Override
    public Transaction getTransaction(String id) {
        return transactionRepository.getReferenceById(id);
    }
}
