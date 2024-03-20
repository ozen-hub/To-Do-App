package com.devstack.app.controllers;

import com.devstack.app.dto.TaskDto;
import com.devstack.app.service.ServiceFactory;
import com.devstack.app.service.TaskService;
import com.devstack.app.views.tm.TaskTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.SimpleDateFormat;
import java.util.Optional;

public class PastTaskListFormController {

    private final TaskService taskService = ServiceFactory.getService(ServiceFactory.ServiceType.TASK);

    public TableColumn colId;
    public TableColumn colTask;
    public TableColumn colStatus;
    public TableColumn collDate;
    public TableView<TaskTm> tblList;

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTask.setCellValueFactory(new PropertyValueFactory<>("name"));
        collDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    public void loadData(String email){
        ObservableList<TaskTm> obList =
                FXCollections.observableArrayList();
        for (TaskDto d : taskService.loadAllPastTasks(email)) {
            TaskTm tm = new TaskTm(
                    d.getId(),
                    d.getTaskName(),
                    new SimpleDateFormat("yyyy-MM-dd").format(d.getDate()),
                    d.isStatus() ? "Completed" : "Pending",
                    null
            );

            obList.add(tm);
        }
        tblList.setItems(obList);
    }

}
