package com.sw.orders_and_notifications_management.models;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Notification {
    private int OrderID;
    private long CustomerID;
    private String channel;
    private NotificationTemplate temp;

    public Notification(int OID, long CID, String Channel, NotificationTemplate Temp) {
        this.OrderID = OID;
        this.CustomerID = CID;
        this.channel = Channel;
        this.temp = Temp;
    }

    public int GetOID() {
        return this.OrderID;
    }

    public long GetCID() {
        return this.CustomerID;
    }

    public String GetContent() {
        return this.temp.getContent();
    }

    public String GetChannel() {
        return this.channel;
    }

    public List<Notification> CreatePlacementNotification(Order order, Customer customer) {
        List<Notification> PlacementNotifications;
        NotificationTemplate temp1 = new Placement(order.getID());
        temp1.replaceContent(customer, order);
        NotificationTemplate temp2 = temp1;
        temp2.AddToContent("Via Email");
        Notification notify = new Notification(order.getID(), customer.getID(), "Email", temp2);
        PlacementNotifications.add(notify);
        if (!customer.getSendMethod().isEmpty()) {
            for (String channel : customer.getSendMethod()) {
                temp2 = temp1;
                temp2.AddToContent("Via" + channel);
                notify = new Notification(order.getID(), customer.getID(), channel, temp2);
                PlacementNotifications.add(notify);
            }
        }
        return PlacementNotifications;
    }

    public List<Notification> CreateShipmentNotification(Order order, Customer customer) {
        List<Notification> ShipmentNotifications;
        NotificationTemplate temp1 = new shipment(order.getID());
        temp1.replaceContent(customer, order);
        NotificationTemplate temp2 = temp1;
        temp2.AddToContent("Via Email");
        Notification notify = new Notification(order.getID(), customer.getID(), "Email", temp2);
        ShipmentNotifications.add(notify);
        if (!customer.getSendMethod().isEmpty()) {
            for (String channel : customer.getSendMethod()) {
                temp2 = temp1;
                temp2.AddToContent("Via" + channel);
                notify = new Notification(order.getID(), customer.getID(), channel, temp2);
                ShipmentNotifications.add(notify);
            }
        }
        return ShipmentNotifications;
    }

}
