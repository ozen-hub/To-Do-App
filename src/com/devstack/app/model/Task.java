package com.devstack.app.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task", nullable = false)
    private String taskName;

    @Column(name = "date", nullable = false, columnDefinition = "DATE")
    private Date date;
    @Column(name = "status", nullable = false, columnDefinition = "TINYINT")
    private boolean status;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {
    }

    public Task(Long id, String taskName, Date date, boolean status, User user) {
        this.id = id;
        this.taskName = taskName;
        this.date = date;
        this.status = status;
        this.user = user;
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
