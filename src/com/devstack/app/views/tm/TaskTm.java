package com.devstack.app.views.tm;

import javafx.scene.control.ButtonBar;

import java.util.Date;

public class TaskTm {
    private long id;
    private String name;
    private String date;
    private String status;
    private ButtonBar bar;

    public TaskTm() {
    }

    public TaskTm(long id, String name, String date, String status, ButtonBar bar) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.status = status;
        this.bar = bar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ButtonBar getBar() {
        return bar;
    }

    public void setBar(ButtonBar bar) {
        this.bar = bar;
    }
}
