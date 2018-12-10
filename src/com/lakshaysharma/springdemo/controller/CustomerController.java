package com.lakshaysharma.springdemo.controller;

import com.lakshaysharma.springdemo.entity.Customer;
import com.lakshaysharma.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // inject the customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){

        // get the customers from service
        List<Customer> customers = customerService.getCustomers();

        // retrieve the customers and add it to the data model
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/addCustomer")
    public String addCustomer(Model model){

        Customer customer = new Customer();

        // add the customer binder to the model
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        customerService.saveCutomer(customer);

        return "redirect:/customer/list";
    }

    @RequestMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId") int customerId,
                               Model model){

        // get the customer from the service using the request param
        Customer customer = customerService.getCustomer(customerId);

        // add the customer details to the model
        model.addAttribute("customer", customer);

        return "customer-form";

    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int customerId,
                                 Model model){

        customerService.deleteCustomer(customerId);

        return "redirect:/customer/list";
    }
}



























