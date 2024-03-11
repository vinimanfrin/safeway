package com.vinimanfrin.safeway.services.company;

import com.vinimanfrin.safeway.models.Company;

public interface CompanyService {

    Company saveCompany(Company company);
    Company getCompany(String id);
}
