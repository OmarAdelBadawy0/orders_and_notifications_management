package com.sw.orders_and_notifications_management.service;
import com.sw.orders_and_notifications_management.models.Product;
import com.sw.orders_and_notifications_management.repos.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;


public class ProductService {

    private ProductRepo productRepo;


    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product getProduct(long serialNumber){
        return productRepo.getProduct(serialNumber);
    }

    public List<Product> getProducts(){
        return productRepo.getProducts();
    }

    public boolean addProduct(Product product){
        return productRepo.addProduct(product);
    }

    public boolean updateProduct(long serialNumber, Product newProduct){
        return productRepo.updateProduct(serialNumber, newProduct);
    }

    public boolean deleteProduct(long serialNumber){
        return productRepo.deleteProduct(serialNumber);
    }



}
