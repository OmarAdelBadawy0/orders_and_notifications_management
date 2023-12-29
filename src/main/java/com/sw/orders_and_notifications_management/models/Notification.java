package com.sw.orders_and_notifications_management.models;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Notification {
    private int NotificationID;
    private int CustomerID;
    private String content;
    private String channel;
    private Map<String, String> Placeholders = new HashMap<>();

    public Notification(int NID, int CID, String Content, String Channel) {
        this.NotificationID = NID;
        this.CustomerID = CID;
        this.content = Content;
        this.channel = Channel;
    }

    public int GetNID() {
        return this.NotificationID;
    }

    public int GetCID() {
        return this.CustomerID;
    }

    public String GetContent() {
        return this.content;
    }
}
