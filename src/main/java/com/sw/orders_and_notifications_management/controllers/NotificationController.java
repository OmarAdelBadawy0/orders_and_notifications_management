package com.sw.orders_and_notifications_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sw.orders_and_notifications_management.models.Notification;
import com.sw.orders_and_notifications_management.models.Customer;
import com.sw.orders_and_notifications_management.service.NotificationService;

@RestController
public class NotificationController {
    @Autowired
    NotificationService notifyService;

    @PostMapping("/placement")
    public boolean CreatePlacement(@RequestBody Order order, Customer customer) {
        List<Notification> notifys = notifyService.CreatePlacementNotification(order, customer);
        for (Notification notification : notifys) {
            notifyService.AddPlacementNotification(notification);
        }
        return true;
    }

    @PostMapping("/shipment")
    public boolean CreateShipment(@RequestBody Order order, Customer customer) {
        List<Notification> notifys = notifyService.CreateShipmentNotification(order, customer);
        for (Notification notification : notifys) {
            notifyService.AddShipmentNotification(notification);
        }
        return true;
    }

    @GetMapping("/placements")
    public String getPlacement() {
        String Message = "";
        List<Notification> notifys = notifyService.ListPlacementNotifications();
        for (Notification notification : notifys) {
            Message += "Order ID: " + notification.GetOID() + "\n" + "Customer ID: " + notification.GetCID() + "\n"
                    + "Channel: " + notification.GetChannel() + "\n" + "Content: " + notification.GetContent() + "\n"
                    + "------------------" + "\n";
        }
        return Message;
    }

    @GetMapping("/shipments")
    public String getShipment() {
        String Message = "";
        List<Notification> notifys = notifyService.ListShipmentNotifications();
        for (Notification notification : notifys) {
            Message += "Order ID: " + notification.GetOID() + "\n" + "Customer ID: " + notification.GetCID() + "\n"
                    + "Channel: " + notification.GetChannel() + "\n" + "Content: " + notification.GetContent() + "\n"
                    + "------------------" + "\n";
        }
        return Message;
    }

    @DeleteMapping("/placement/{OrderId}")
    public String deletePlacement(@PathVariable("OrderId") int OrderId) {
        if (notifyService.RemovePlacementNotification(OrderId) && notifyService.CheckInPlacement(OrderId)) {
            return "Notification Deleted successfully";
        } else {
            return "Unable to delete the Notification";
        }
    }

    @DeleteMapping("/shipment/{OrderId}")
    public String deleteShipment(@PathVariable("OrderId") int OrderId) {
        if (notifyService.RemoveShipmentNotification(OrderId) && notifyService.CheckInShipment(OrderId)
                && !notifyService.CheckInPlacement(OrderId)) {
            return "Notification Deleted successfully";
        } else {
            return "Unable to delete the Notification";
        }
    }

}
