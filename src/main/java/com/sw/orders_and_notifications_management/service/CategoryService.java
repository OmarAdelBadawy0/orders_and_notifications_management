package com.sw.orders_and_notifications_management.service;

import com.sw.orders_and_notifications_management.models.*;
import com.sw.orders_and_notifications_management.repos.CategoryRepo;

import java.util.List;

public class CategoryService {

    private CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category getCategory(long serialNumber) {
        return categoryRepo.getCategory(serialNumber);
    }

    public List<Category> getCategories() {
        return categoryRepo.getCategories();
    }

    public boolean addCategory(Category category) {
        return categoryRepo.addCategory(category);
    }

    public boolean updateCategory(long serialNumber, Category newCategory) {
        return categoryRepo.updateCategory(serialNumber, newCategory);
    }

    public boolean deleteCategory(long serialNumber) {
        return categoryRepo.deleteCategory(serialNumber);
    }

    public boolean addProductToCategory(long categorySerialNumber, Product product) {
        return categoryRepo.addProductToCategory(categorySerialNumber, product);
    }

    public boolean deleteProductFromCategory(long categorySerialNumber, long productSerialNumber) {
        return categoryRepo.deleteProductFromCategory(categorySerialNumber, productSerialNumber);
    }

    public Product searchProductInCategory(long categorySerialNumber, long productSerialNumber) {
        return categoryRepo.searchProductInCategory(categorySerialNumber, productSerialNumber);
    }
}
