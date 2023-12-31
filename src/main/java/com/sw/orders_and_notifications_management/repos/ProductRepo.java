package com.sw.orders_and_notifications_management.repos;

import com.sw.orders_and_notifications_management.models.Product;

import java.util.List;

public class ProductRepo {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct(long SerialNumber){
        for(Product product: products){
            if(product.getProductSerialNumber() == SerialNumber ){
                return product;
            }
        }
        return null;
    }
    public boolean addProduct(Product product){
        products.add(product);
        return true;
    }

    public boolean updateProduct(long serialNumber, Product newproduct){
        for(Product product: products){
            if(product.getProductSerialNumber() == serialNumber){
                product.setName(newproduct.getName());
                product.setPrice(newproduct.getPrice());
                product.setCategory(newproduct.getCategory());
                product.setVendor(newproduct.getVendor());

                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(long serialNumber){
        for(Product product: products){
            if(product.getProductSerialNumber()==(serialNumber)){
                products.remove(product);
                return true;
            }
        }
        return false;
    }
}
