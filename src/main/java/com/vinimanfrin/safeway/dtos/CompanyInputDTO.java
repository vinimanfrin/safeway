package com.vinimanfrin.safeway.dtos;

import java.math.BigDecimal;

public record CompanyInputDTO(
        String email,
        String firstName,
        String lastName,
        String password,
        String cnpj,
        BigDecimal fee
) {
}
