package com.vinimanfrin.safeway.services.customer;

import com.vinimanfrin.safeway.models.Customer;
import com.vinimanfrin.safeway.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer getCustomer(String id) {
        return repository.getReferenceById(id);
    }
}
