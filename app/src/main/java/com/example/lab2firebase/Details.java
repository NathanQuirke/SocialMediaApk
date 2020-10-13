package com.example.lab2firebase;
import androidx.annotation.Keep;

@Keep
public class Details {
    private String title;
    private String description;
    private Object date;

    public Details() {
        //empty constructor
    }

    public Details(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
