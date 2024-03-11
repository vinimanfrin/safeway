package com.vinimanfrin.safeway.models;

import com.vinimanfrin.safeway.dtos.company.CompanyInputDTO;
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
    private BigDecimal balance;
    private BigDecimal fee;

    public Company(CompanyInputDTO companyInput){
        super(companyInput.email(),companyInput.firstName(),companyInput.lastName(),companyInput.password());
        this.cnpj = companyInput.cnpj();
        this.balance = BigDecimal.ZERO;
        this.fee = companyInput.fee();
    }
    public void updateBalance(Transaction transaction) {
        var transactionValue = transaction.getValue();
        var transactionFeeValue = transactionValue.multiply(this.fee);

        this.balance = transaction.getType() == TransactionType.WITHDRAW ? this.balance.subtract(transactionValue.add(transactionFeeValue))  :
                this.balance.add(transactionValue.subtract(transactionFeeValue));
    }
}
