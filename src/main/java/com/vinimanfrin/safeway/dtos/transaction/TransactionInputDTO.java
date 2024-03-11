package com.vinimanfrin.safeway.dtos.transaction;

import com.vinimanfrin.safeway.models.TransactionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;


public record TransactionInputDTO(

        @NotBlank String company_id,
        @NotBlank String customer_id,
        @NotNull @Min(1) BigDecimal value,
        @NotNull TransactionType transactionType
) {
}
