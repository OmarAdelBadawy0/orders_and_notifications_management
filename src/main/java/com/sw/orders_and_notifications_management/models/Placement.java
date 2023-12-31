package com.sw.orders_and_notifications_management.models;

import java.util.List;

public class Placement extends NotificationTemplate {
    public Placement(int TempID) {
        this.TemplateID = TempID;
        this.language = "English";
        this.subject = "Placement Notification";
        this.content = "Dear my {x} , your booking of the {y} is placed. Thanks for using our store :)";
    }

    public void replaceContent(Customer cust, Order ord) {
        this.content = this.content.replace("{x}", cust.getName());

        String productList = productsToStringList(ord.getProducts());
        this.content = this.content.replace("{y}", productList);
    }

    private String productsToStringList(List<Product> products) {
        StringBuilder productList = new StringBuilder();
        for (Product product : products) {
            if (productList.length() > 0) {
                productList.append(", ");
            }
            productList.append(product.getName());
        }
        return productList.toString();
    }
}
