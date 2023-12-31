package com.sw.orders_and_notifications_management.service;

import com.sw.orders_and_notifications_management.models.Customer;
import com.sw.orders_and_notifications_management.models.Notification;
import com.sw.orders_and_notifications_management.repos.NotificationRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notifyRepo;

    public boolean AddPlacementNotification(Notification notification) {
        return notifyRepo.AddPlacementNotification(notification);
    }

    public boolean AddShipmentNotification(Notification notification) {
        return notifyRepo.AddShipmentNotification(notification);
    }

    public boolean RemovePlacementNotification(int OrderID) {
        return notifyRepo.RemovePlacementNotification(OrderID);
    }

    public boolean RemoveShipmentNotification(int OrderID) {
        return notifyRepo.RemoveShipmentNotification(OrderID);
    }

    public boolean CheckInPlacement(int OrderID) {
        return notifyRepo.CheckInPlacement(OrderID);
    }

    public boolean CheckInShipment(int OrderID) {
        return notifyRepo.CheckInShipment(OrderID);
    }

    public List<Notification> CreatePlacementNotification(Order order, Customer customer) {
        return notifyRepo.CreatePlacementNotification(order, customer);
    }

    public List<Notification> CreateShipmentNotification(Order order, Customer customer) {
        return notifyRepo.CreateShipmentNotification(order, customer);
    }

    public List<Notification> ListPlacementNotifications() {
        return notifyRepo.ListPlacementNotifications();
    }

    public List<Notification> ListShipmentNotifications() {
        return notifyRepo.ListShipmentNotifications();
    }

    public String NotifyShipment() {
        String Message = "";
        List<Notification> Shipments = ListShipmentNotifications();
        for (Notification notification : Shipments) {
            Message += "Order ID: " + notification.GetOID() + "\n" + "Customer ID: " + notification.GetCID() + "\n"
                    + "Channel: " + notification.GetChannel() + "\n" + "Content: " + notification.GetContent() + "\n"
                    + "------------------" + "\n";
            RemovePlacementNotification(notification.GetOID());
        }
        return Message;
    }

    public String CancelOrder(Order order) {
        if (CheckInPlacement(order.getOrderID)) {
            RemovePlacementNotification(order.getOrderID);
            RemoveShipmentNotification(order.getOrderID);
            return "This Order has been cancelled";
        } else if (CheckInShipment(order.getOrderID)) {
            return "This Order already shipped";
        } else {
            return "This Order not found";
        }
    }

    public String PlaceOrder(Order order, Customer cust) {
        List<Notification> placed = CreatePlacementNotification(order, cust);
        List<Notification> shiped = CreateShipmentNotification(order, cust);
        String Message = "";
        for (Notification notification : placed) {
            if (AddPlacementNotification(notification)) {
                Message += notification.GetContent() + "\n" + "------------------" + "\n";
            }
        }
        for (Notification notification : shiped) {
            AddShipmentNotification(notification);
        }
        return Message;
    }
}
