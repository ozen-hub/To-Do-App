package com.devstack.app.controllers;

import com.devstack.app.db.HibernateUtil;
import com.devstack.app.model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegisterFormController {
    public AnchorPane context;
    public TextField txtFullName;
    public TextField txtUsername;
    public PasswordField txtPassword;

    public void btnRegisterOnAction(ActionEvent actionEvent) {

       /*User user = User.builder()
               .fullName(txtFullName.getText())
               .username(txtUsername.getText())
               .password(txtPassword.getText())
               .build();*/

        User user = new User();
                user.setFullName(txtFullName.getText());
                user.setUsername(txtUsername.getText());
                user.setPassword(txtPassword.getText());

       try(Session session = HibernateUtil.openSession()){
           Transaction transaction = session.beginTransaction();
           session.save(user);
           transaction.commit();
       }

       new Alert(Alert.AlertType.INFORMATION, "User was Saved!", ButtonType.CLOSE).show();

    }

    public void btnAlreadyHaveAnAccount(ActionEvent actionEvent) {
    }
}
