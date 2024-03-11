package com.vinimanfrin.safeway.models;

import com.vinimanfrin.safeway.dtos.transaction.TransactionInputDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
public class Transaction {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private BigDecimal value;
    private LocalDateTime dateTime;

    public Transaction(TransactionInputDTO transactionInput, Company company, Customer customer) {
        this.company = company;
        this.customer = customer;
        this.type = transactionInput.transactionType();
        this.value = transactionInput.value();
        this.dateTime = LocalDateTime.now();
    }

    public String getTransactionInfo() {
        return " Valor: " + this.value +
                ", Data: " + this.dateTime +
                ", Empresa: " + this.company.getFirstName() + this.company.getLastName() +
                ", Tipo: " + this.type;

    }
}
