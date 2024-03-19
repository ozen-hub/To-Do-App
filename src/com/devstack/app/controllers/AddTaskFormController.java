package com.devstack.app.controllers;

import com.devstack.app.dto.TaskDto;
import com.devstack.app.service.ServiceFactory;
import com.devstack.app.service.TaskService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.time.ZoneId;
import java.util.Date;

public class AddTaskFormController {

    private TaskService taskService = ServiceFactory.getService(ServiceFactory.ServiceType.TASK);

    public TextArea txtTask;
    public DatePicker dPick;

    public String email;

    public void saveTaskOnAction(ActionEvent actionEvent) {
        TaskDto dto = new TaskDto();
        dto.setTaskName(txtTask.getText());
        dto.setDate(Date.from(dPick.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        taskService.createTaskWithUser(dto, email);
        txtTask.clear();
        dPick.setValue(null);
        new Alert(Alert.AlertType.INFORMATION, "Task Added!").show();
    }
}
