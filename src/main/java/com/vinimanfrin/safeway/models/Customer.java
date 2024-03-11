package com.vinimanfrin.safeway.models;

import com.vinimanfrin.safeway.dtos.customer.CustomerInputDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
public class Customer extends User{

    @Column(unique = true)
    private String cpf;

    public Customer(CustomerInputDTO customerInput) {
        super(customerInput.email(), customerInput.firstName(), customerInput.lastName(), customerInput.password());
        this.cpf = customerInput.cpf();
    }
}
