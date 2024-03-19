package com.devstack.app.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class DashboardFormController {

    public Label lblUsername;

    public void setUsername(String username){
        lblUsername.setText(username);
    }


    public void btnPastTaskListOnAction(ActionEvent actionEvent) {
    }

    public void btnAddnewTaskOnAction(ActionEvent actionEvent) {
    }
}
