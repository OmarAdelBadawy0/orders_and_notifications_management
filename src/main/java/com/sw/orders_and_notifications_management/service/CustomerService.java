package com.sw.orders_and_notifications_management.service;
import com.sw.orders_and_notifications_management.models.Customer;
import com.sw.orders_and_notifications_management.repos.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;


public class CustomerService {

    private CustomerRepo customerRepo;


    public CustomerService(CustomerRepo customerRepo) {  
        this.customerRepo = customerRepo;
    }

    public Customer getCustomer(long id){
        return customerRepo.getCustomer(id);
    }

    public List<Customer> getCustomers(){
        return customerRepo.getCustomers();
    }

    public boolean addCustomer(Customer customer){
        return customerRepo.addCustomer(customer);
    }

    public boolean updateCustomer(long id, Customer customer){
        return customerRepo.updateCustomer(id, customer);
    }

    public boolean deleteCustomer(long id){
        return customerRepo.deleteCustomer(id);
    }



}
