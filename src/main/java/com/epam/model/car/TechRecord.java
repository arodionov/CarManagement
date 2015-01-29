package com.epam.model.car;

import java.util.Date;
import javax.persistence.Embeddable;

@Embeddable
public class TechRecord {
    private String text;
    private Date date;
    private String author;

    public TechRecord() {
    }

    public TechRecord(String text, Date date, String author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    
    
}
