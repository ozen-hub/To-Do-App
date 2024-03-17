package com.devstack.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane context;
    public TextField txtUsername;
    public PasswordField txtPassword;
    public Button btnSignin;

    public void btnloginOnAction(ActionEvent actionEvent) {

    }

    public void btnCreatenewAccountOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("../views/RegisterForm.fxml"));
        stage.setScene(new Scene(parent));
    }
}
