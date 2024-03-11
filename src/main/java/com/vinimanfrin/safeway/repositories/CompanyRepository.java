package com.vinimanfrin.safeway.repositories;

import com.vinimanfrin.safeway.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,String> {
}
