package com.sw.orders_and_notifications_management.repos;
import com.sw.orders_and_notifications_management.models.Category;
import com.sw.orders_and_notifications_management.models.Product;

import java.util.ArrayList;
import java.util.List;



public class CategoryRepo {
    private List<Category> categories;

    public CategoryRepo() {
        this.categories = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Category getCategory(long serialNumber) {
        for (Category category : categories) {
            if (category.getCategorySerialNumber() == serialNumber) {
                return category;
            }
        }
        return null;
    }

    public boolean addCategory(Category category) {
        categories.add(category);
        return true;
    }

    public boolean updateCategory(long serialNumber, Category newCategory) {
        for (Category category : categories) {
            if (category.getCategorySerialNumber() == serialNumber) {
                category.setRemainingParts(newCategory.getRemainingParts());
                category.setProducts(newCategory.getProducts());
                // Update other attributes if needed

                return true;
            }
        }
        return false;
    }

    public boolean deleteCategory(long serialNumber) {
        for(Category category1: categories){
            if(category1.getCategorySerialNumber()==(serialNumber)){
                categories.remove(category1);
                return true;
            }
        }
        return false;
    }

    public boolean addProductToCategory(long categorySerialNumber, Product product) {
        Category category = getCategory(categorySerialNumber);
        if (category != null) {
            category.addProduct(product);
            return true;
        }
        return false;
    }

    public boolean deleteProductFromCategory(long categorySerialNumber, long productSerialNumber) {
        Category category = getCategory(categorySerialNumber);
        if (category != null) {
            return category.deleteProduct(productSerialNumber);
        }
        return false;
    }

    public Product searchProductInCategory(long categorySerialNumber, long productSerialNumber) {
        Category category = getCategory(categorySerialNumber);
        if (category != null) {
            return category.searchProduct(productSerialNumber);
        }
        return null;
    }
}
