package com.lakshaysharma.springdemo.service;

import com.lakshaysharma.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    void saveCutomer(Customer customer);

    public Customer getCustomer(int customerId);

    public void deleteCustomer(int customerId);

}
