package com.vinimanfrin.safeway.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "companies")
@Data
public class Company extends User {

    @Column(unique = true)
    private String cnpj;
    private BigDecimal fee;

}
