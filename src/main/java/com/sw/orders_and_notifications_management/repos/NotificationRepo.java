package com.sw.orders_and_notifications_management.repos;

import com.sw.orders_and_notifications_management.models.Customer;
import com.sw.orders_and_notifications_management.models.Notification;
import com.sw.orders_and_notifications_management.models.NotificationTemplate;
import com.sw.orders_and_notifications_management.models.Placement;
import com.sw.orders_and_notifications_management.models.shipment;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationRepo {

    @Autowired
    private List<Notification> PlacementQueue;

    @Autowired
    private List<Notification> ShipmentQueue;

    @Autowired
    private Notification notifyy;

    public boolean AddPlacementNotification(Notification notification) {
        PlacementQueue.add(notification);
        return true;
    }

    public boolean AddShipmentNotification(Notification notification) {
        ShipmentQueue.add(notification);
        return true;
    }

    public boolean RemovePlacementNotification(int OrderID) {
        Iterator<Notification> iterator = PlacementQueue.iterator();
        if (CheckInPlacement(OrderID)) {
            while (iterator.hasNext()) {
                Notification notification = iterator.next();
                if (notification.GetOID() == OrderID) {
                    iterator.remove();
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean RemoveShipmentNotification(int OrderID) {
        Iterator<Notification> iterator = ShipmentQueue.iterator();
        if (CheckInShipment(OrderID)) {
            while (iterator.hasNext()) {
                Notification notification = iterator.next();
                if (notification.GetOID() == OrderID) {
                    iterator.remove();
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean CheckInPlacement(int OrderID) {
        Iterator<Notification> iterator = PlacementQueue.iterator();

        while (iterator.hasNext()) {
            Notification notification = iterator.next();
            if (notification.GetOID() == OrderID) {
                return true;
            }
        }
        return false;
    }

    public boolean CheckInShipment(int OrderID) {
        Iterator<Notification> iterator = ShipmentQueue.iterator();

        while (iterator.hasNext()) {
            Notification notification = iterator.next();
            if (notification.GetOID() == OrderID) {
                return true;
            }
        }
        return false;
    }

    public List<Notification> CreatePlacementNotification(Order order, Customer customer) {
        return notifyy.CreatePlacementNotification(order, customer);
    }

    public List<Notification> CreateShipmentNotification(Order order, Customer customer) {
        return notifyy.CreateShipmentNotification(order, customer);
    }

    public List<Notification> ListPlacementNotifications() {
        return PlacementQueue;
    }

    public List<Notification> ListShipmentNotifications() {
        return ShipmentQueue;
    }
}
