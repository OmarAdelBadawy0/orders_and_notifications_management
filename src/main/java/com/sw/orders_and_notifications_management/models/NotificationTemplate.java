package com.sw.orders_and_notifications_management.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class NotificationTemplate {
    protected int TemplateID;
    protected String subject;
    protected String content;
    protected String language;

    public int getID() {
        return this.TemplateID;
    }

    public String getContent() {
        return this.content;
    }

    public String getSubject(){
        return this.subject;
    }

    public String getLanguage(){
        return this.language;
    }

    public void AddToContent(String word){
        this.content += word;
    }
}
