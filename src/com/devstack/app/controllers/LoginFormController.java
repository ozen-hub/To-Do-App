package com.devstack.app.controllers;

import com.devstack.app.PasswordUtil;
import com.devstack.app.db.HibernateUtil;
import com.devstack.app.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class LoginFormController {
    public AnchorPane context;
    public TextField txtUsername;
    public PasswordField txtPassword;
    public Button btnSignin;

    public void btnloginOnAction(ActionEvent actionEvent) throws IOException {
        if (checkUser()){
            setUi("DashboardForm",txtUsername.getText().trim());
        }else{
            new Alert(Alert.AlertType.WARNING,"check your username or email").show();
        }
    }

    private boolean checkUser(){

        String email = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        try(Session session= HibernateUtil.openSession()){
            Query<User> query = session.createQuery("FROM User WHERE username=:username", User.class);
            query.setParameter("username",email);
            User user = query.uniqueResult();

            if (user!=null){
                if (PasswordUtil.checkPassword(
                        user.getPassword(),password
                )){
                    return true;
                }else{
                    return false;
                }
            }
            return false;
        }
    }

    public void btnCreatenewAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("RegisterForm");
    }

    private void setUi(String location,String...args) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/"+location+".fxml"));
        Parent parent = fxmlLoader.load();
        if (args.length>0){
            DashboardFormController formController = fxmlLoader.getController();
            formController.setUsername(args[0]);
        }
        stage.setScene(new Scene(parent));
    }
}
