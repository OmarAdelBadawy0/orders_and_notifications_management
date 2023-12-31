package com.sw.orders_and_notifications_management.repos;
import com.sw.orders_and_notifications_management.models.Customer;

import java.util.List;
public class CustomerRepo {
    private List<Customer>  customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer getCustomer(long id){
        for(Customer customer: customers){
            if(customer.getID() == id){
                return customer;
            }
        }
        return null;
    }

    public boolean addCustomer(Customer customer){
        customers.add(customer);
        return true;
    }

    public boolean updateCustomer(long id, Customer customer){
        for(Customer customer1: customers){
            if(customer1.getID() == id){
                customer1.setName(customer.getName());
                customer1.setSendMethod(customer.getSendMethod());
                return true;
            }
        }
        return false;
    }

    public boolean deleteCustomer(long id){
        for(Customer customer: customers){
            if(customer.getID() == id){
                customers.remove(customer);
                return true;
            }
        }
        return false;
    }

    


}
