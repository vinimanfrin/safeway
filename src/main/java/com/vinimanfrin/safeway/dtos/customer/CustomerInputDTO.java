package com.vinimanfrin.safeway.dtos.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record CustomerInputDTO(
        @Email
        String email,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        String password,
        @CPF
        String cpf
) {
}
