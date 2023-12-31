package com.sw.orders_and_notifications_management.models;
import java.util.List;

public class Category {
    private long serialNumber;
    private int remainingParts;
    private List<Product> products;


    public Category(long serialNumber, List<Product> products) {
        this.serialNumber = serialNumber;
        this.remainingParts = products.size();
        this.products = products;
    }
    public Category(long serialNumber) {
        this.serialNumber = serialNumber;
        this.remainingParts = 0;
    }

    public long getCategorySerialNumber() {
        return serialNumber;
    }

    public void setCategorySerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getRemainingParts() {
        return remainingParts;
    }

    public void setRemainingParts(int remainingParts) {
        this.remainingParts = remainingParts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public void addProduct(Product product) {
        products.add(product);
        remainingParts++;
    }


    public boolean deleteProduct(long productSerialNumber) {
        for (Product product : products) {
            if (product.getProductSerialNumber() == productSerialNumber) {
                products.remove(product);
                remainingParts--;
                return true;
            }
        }
        return false;
    }

    public Product searchProduct(long productSerialNumber) {
        for (Product product : products) {
            if (product.getProductSerialNumber() == productSerialNumber) {
                return product;
            }
        }
        return null;
    }

}
