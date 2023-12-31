package com.sw.orders_and_notifications_management.models;

import java.util.List;

public class shipment extends NotificationTemplate {
    public shipment(int TempID) {
        this.TemplateID = TempID;
        this.language = "English";
        this.subject = "Shipment Notification";
        this.content = "Dear my {x} , your order with ID {y} has been shipped with price {z} . Thanks for using our store :)";
    }

    public void replaceContent(Customer cust, Order ord) {
        this.content = this.content.replace("{x}", cust.getName());
        this.content = this.content.replace("{y}", ord.getID());
        this.content = this.content.replace("{z}", ord.getPrice());
    }

}
