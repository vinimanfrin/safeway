package com.vinimanfrin.safeway.services.callback;

import com.vinimanfrin.safeway.dtos.transaction.TransactionDetailDTO;

public record CallBackDTO(String mensagem, TransactionDetailDTO transaction) {
}
