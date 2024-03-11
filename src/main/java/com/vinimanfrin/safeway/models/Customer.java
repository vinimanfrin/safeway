package com.vinimanfrin.safeway.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer extends User{

    @Column(unique = true)
    private String cpf;

}
