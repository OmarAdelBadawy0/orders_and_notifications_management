package com.sw.orders_and_notifications_management.controllers;

import com.sw.orders_and_notifications_management.models.*;
import com.sw.orders_and_notifications_management.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{categorySerialNumber}")
    public Category getCategory(@PathVariable("categorySerialNumber") long categorySerialNumber) {
        return categoryService.getCategory(categorySerialNumber);
    }

    @PutMapping("/{categorySerialNumber}")
    public String updateCategory(@RequestBody Category category,@PathVariable("categorySerialNumber") long categorySerialNumber) {
        if (categoryService.updateCategory(categorySerialNumber, category)) {
            return "Category updated successfully";
        }
        return "Failed to update category";
    }

    @DeleteMapping("/{categorySerialNumber}")
    public String deleteCategory(@PathVariable("categorySerialNumber") long categorySerialNumber) {
        if (categoryService.deleteCategory(categorySerialNumber)) {
            return "Category deleted successfully";
        } else {
            return "Unable to delete the category";
        }
    }
    @PostMapping("/addProduct/{categorySerialNumber}")
    public String addProductToCategory(@PathVariable("categorySerialNumber") long categorySerialNumber,@RequestBody Product product) {
        if (categoryService.addProductToCategory(categorySerialNumber, product)) {
            return "Product added to category successfully";
        } else {
            return "Failed to add product to category";
        }
    }

    @DeleteMapping("/{categorySerialNumber}/deleteProduct/{productSerialNumber}")
    public String deleteProductFromCategory(@PathVariable("categorySerialNumber") long categorySerialNumber,
                                            @PathVariable("productSerialNumber") long productSerialNumber) {
        if (categoryService.deleteProductFromCategory(categorySerialNumber, productSerialNumber)) {
            return "Product deleted from category successfully";
        } else {
            return "Unable to delete the product from the category";
        }
    }

    @GetMapping("/{categorySerialNumber}/searchProduct/{productSerialNumber}")
    public Product searchProductInCategory(@PathVariable("categorySerialNumber") long categorySerialNumber,
                                           @PathVariable("productSerialNumber") long productSerialNumber) {
        return categoryService.searchProductInCategory(categorySerialNumber, productSerialNumber);
    }

}
