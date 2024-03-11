package com.vinimanfrin.safeway.controllers;

import com.vinimanfrin.safeway.dtos.transaction.TransactionDetailDTO;
import com.vinimanfrin.safeway.dtos.transaction.TransactionInputDTO;
import com.vinimanfrin.safeway.models.Transaction;
import com.vinimanfrin.safeway.services.transaction.TransactionServiceImp;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionServiceImp transactionService;

    @PostMapping
    @Transactional
    public ResponseEntity createTransaction(@RequestBody @Valid TransactionInputDTO transactionInput){
        var transaction = transactionService.saveTransaction(transactionInput);
        var uri = buildUrl(transaction);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDetailDTO> getTransaction(@PathVariable("id") String id){
        var transaction = transactionService.getTransaction(id);
        return ResponseEntity.ok(new TransactionDetailDTO(transaction));
    }

    private URI buildUrl(Transaction transaction){
        String transactionPath = "/"+transaction.getId();
        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path(transactionPath)
                .build()
                .toUri();
    }
}
