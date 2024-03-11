package com.vinimanfrin.safeway.services.company;

import com.vinimanfrin.safeway.models.Company;
import com.vinimanfrin.safeway.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImp implements CompanyService{

    @Autowired
    private CompanyRepository repository;


    @Override
    public Company saveCompany(Company company) {
        return repository.save(company);
    }

    @Override
    public Company getCompany(String id) {
        return repository.getReferenceById(id);
    }
}
