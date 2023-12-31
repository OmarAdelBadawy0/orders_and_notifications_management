package com.sw.orders_and_notifications_management.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Product {

    private long serialNumber;
    private String name;
    private String vendor;
    private String category;
    private double price;

    public Product(long serialNumber, String name, String vendor, String category, double price) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.vendor = vendor;
        this.category = category;
        this.price = price;
    }

    public long getProductSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setProductSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    
}
