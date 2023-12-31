package com.sw.orders_and_notifications_management.controllers;
import com.sw.orders_and_notifications_management.models.Product;
import com.sw.orders_and_notifications_management.service.ProductService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

public class ProductController {
    private ProductService productService;

    @PostMapping("/product")
    public boolean addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/product")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/product/{productSerialNumber}")
    public Product getProduct(@PathVariable("productSerialNumber") long productserialNumber){
        return productService.getProduct(productserialNumber);
    }

    @PutMapping("/product/{productSerialNumber}")
    public String updateProduct(@RequestBody Product product, @PathVariable("productSerialNumber") long productSerialNumber){
        if(productService.updateProduct(productSerialNumber, product)){
            return "Product Updated successfully";
        }
        return "Failed to update Product";
    }

    @DeleteMapping("/product/{productSerialNumber}")
    public String deleteProduct(@PathVariable("productSerialNumber") long productSerialNumber){
        if (productService.deleteProduct(productSerialNumber)){
            return "product Deleted successfully";
        }else{
            return "Unable to delete the product";
        }
    }
}
