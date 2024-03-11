package com.vinimanfrin.safeway.dtos.company;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CNPJ;

import java.math.BigDecimal;

public record CompanyInputDTO(
        @Email
        String email,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        String password,
        @CNPJ
        String cnpj,
        @NotNull
        BigDecimal fee
) {
}
