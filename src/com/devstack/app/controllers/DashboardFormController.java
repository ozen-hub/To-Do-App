package com.devstack.app.controllers;

import com.devstack.app.dto.TaskDto;
import com.devstack.app.service.ServiceFactory;
import com.devstack.app.service.TaskService;
import com.devstack.app.views.tm.TaskTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class DashboardFormController {


    private final TaskService taskService = ServiceFactory.getService(ServiceFactory.ServiceType.TASK);

    public Label lblUsername;
    private String username;
    public TableView<TaskTm> tblList;
    public TableColumn colId;
    public TableColumn colTask;
    public TableColumn colStatus;
    public TableColumn colOptions;
    public TableColumn collDate;

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTask.setCellValueFactory(new PropertyValueFactory<>("name"));
        collDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colOptions.setCellValueFactory(new PropertyValueFactory<>("bar"));
    }

    private void loadAll() {
        ObservableList<TaskTm> obList =
                FXCollections.observableArrayList();
        for (TaskDto d : taskService.loadAllTasks(username)) {
            Button deleteButton = new Button("Delete");
            Button manageButton = new Button("Manage");

            ButtonBar buttonBar = new ButtonBar();
            buttonBar.getButtons().addAll(deleteButton, manageButton);

            TaskTm tm = new TaskTm(
                    d.getId(),
                    d.getTaskName(),
                    new SimpleDateFormat("yyyy-MM-dd").format(d.getDate()),
                    d.isStatus() ? "Completed" : "Pending",
                    buttonBar
            );

            deleteButton.setOnAction(e->{
                Alert alert = new Alert(
                        Alert.AlertType.CONFIRMATION,
                        "Are you sure?",
                        ButtonType.YES,ButtonType.NO
                );
                Optional<ButtonType> buttonType = alert.showAndWait();

                if(buttonType.get()==ButtonType.YES){
                    taskService.deleteTaskById(d.getId());
                    loadAll();
                }

            });

            manageButton.setOnAction(e->{
                    taskService.updateTaskStatus(d.getId());
                    loadAll();
            });

            obList.add(tm);
        }
        tblList.setItems(obList);
    }

    public void setUsername(String username) {
        this.username=username;
        lblUsername.setText(username);
    }


    public void btnPastTaskListOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/PastTaskListForm.fxml"));
        Parent parent = fxmlLoader.load();
        PastTaskListFormController formController = fxmlLoader.getController();
        formController.loadData(lblUsername.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    public void btnAddnewTaskOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/AddTaskForm.fxml"));
        Parent parent = fxmlLoader.load();
        AddTaskFormController formController = fxmlLoader.getController();
        formController.email = lblUsername.getText();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    private void setUi(String location, String... args) throws IOException {

    }

    public void btnRefreshOnAction(ActionEvent actionEvent) {
        loadAll();
    }
}
