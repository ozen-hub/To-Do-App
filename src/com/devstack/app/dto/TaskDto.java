package com.devstack.app.dto;

import java.util.Date;

public class TaskDto {
    private Long id;
    private String taskName;
    private Date date;
    private boolean status;

    public TaskDto() {
    }

    public TaskDto(Long id, String taskName, Date date, boolean status) {
        this.id = id;
        this.taskName = taskName;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
