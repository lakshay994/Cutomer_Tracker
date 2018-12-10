package com.lakshaysharma.springdemo.service;

import com.lakshaysharma.springdemo.dao.CustomerDAO;
import com.lakshaysharma.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    // inject the Customer DAO because the service depends on the CustomerDAO
    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCutomer(Customer customer) {

        customerDAO.saveCustomer(customer);

    }

    @Override
    @Transactional
    public Customer getCustomer(int customerId) {

        return customerDAO.getCustomer(customerId);

    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {

        customerDAO.deleteCustomer(customerId);

    }
}
