package com.vinimanfrin.safeway.controllers;

import com.vinimanfrin.safeway.dtos.customer.CustomerDetailDTO;
import com.vinimanfrin.safeway.dtos.customer.CustomerInputDTO;
import com.vinimanfrin.safeway.models.Customer;
import com.vinimanfrin.safeway.services.customer.CustomerServiceImp;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImp customerService;

    @PostMapping
    @Transactional
    public ResponseEntity<CustomerDetailDTO> saveCustomer(@RequestBody @Valid CustomerInputDTO customerInput){
        var customer = new Customer(customerInput);
        var customerSaved = customerService.saveCustomer(customer);
        var uri = buildImageURL(customerSaved);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetailDTO> getCustomer(@PathVariable("id") String id){
        var customer = customerService.getCustomer(id);
        return ResponseEntity.ok(new CustomerDetailDTO(customer));
    }

    private URI buildImageURL(Customer customer){
        String customerPath = "/"+customer.getId();
        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path(customerPath)
                .build()
                .toUri();
    }
}
