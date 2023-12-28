package com.sw.orders_and_notifications_management.controllers;


import com.sw.orders_and_notifications_management.models.Customer;
import org.springframework.web.bind.annotation.*;
import com.sw.orders_and_notifications_management.service.CustomerService;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/customer")
    public boolean addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/customer")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") long customerId){
        return customerService.getCustomer(customerId);
    }

    @PutMapping("/customer/{customerId}")
    public String updateCustomer(@RequestBody Customer customer, @PathVariable("customerId") long customerId){
        if(customerService.updateCustomer(customerId, customer)){
            return "Customer Updated successfully";
        }
        return "Failed to update customer";
    }

    @DeleteMapping("/customer/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") long customerId){
        if (customerService.deleteCustomer(customerId)){
            return "Customer Deleted successfully";
        }else{
            return "Unable to delete the customer";
        }
    }
    
}
