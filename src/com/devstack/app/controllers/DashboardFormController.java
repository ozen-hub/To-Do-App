package com.devstack.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {

    public Label lblUsername;

    public void setUsername(String username) {
        lblUsername.setText(username);
    }


    public void btnPastTaskListOnAction(ActionEvent actionEvent) {
    }

    public void btnAddnewTaskOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/AddTaskForm.fxml"));
        Parent parent = fxmlLoader.load();
        AddTaskFormController formController = fxmlLoader.getController();
        formController.email = lblUsername.getText();
        Stage stage= new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    private void setUi(String location, String... args) throws IOException {

    }

}
