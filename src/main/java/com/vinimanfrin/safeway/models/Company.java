package com.vinimanfrin.safeway.models;

import com.vinimanfrin.safeway.dtos.CompanyInputDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
public class Company extends User {

    @Column(unique = true)
    private String cnpj;
    private BigDecimal fee;

    public Company(CompanyInputDTO companyInput){
        super(companyInput.email(),companyInput.firstName(),companyInput.lastName(),companyInput.password());
        this.cnpj = companyInput.cnpj();
        this.fee = companyInput.fee();
    }
}
