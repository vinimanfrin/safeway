package com.vinimanfrin.safeway.services.customer;

import com.vinimanfrin.safeway.models.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    Customer getCustomer(String id);

}
