package com.sw.orders_and_notifications_management.models;

import java.util.List;

public class NotificationQueue {
    private List<Notification> queue;

    public void AddNotification(Notification notification) {
        queue.add(notification);
    }

    public void RemoveNotification(Notification notification) {
        queue.remove(notification);
    }

    public void ListNotifications() {
        for (Notification notification : queue) {
            System.out.println("Notification ID : " + notification.GetNID());
            System.out.println("Customer ID : " + notification.GetCID());
            System.out.println("Notification Content : " + notification.GetContent());
            System.out.println("------------------------------");
        }
    }
}
