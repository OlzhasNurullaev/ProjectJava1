package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Node;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button EnterButton;

    @FXML
    private Button loginRegisterButton;

    @FXML
    void initialize() {
        EnterButton.setOnAction(event -> {
            String loginText=LoginField.getText().trim();
            String loginPassword=PasswordField.getText().trim();

            if(!LoginField.equals("")&&!loginPassword.equals(""))
                loginUser(loginText,loginPassword);
            else
                loginRegisterButton.getScene().getWindow().hide();

            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/MainMenu.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root=loader.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        });

        loginRegisterButton.setOnAction(event -> {
            loginRegisterButton.getScene().getWindow().hide();

            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/SignUp.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root=loader.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler=new DatabaseHandler();
        User user=new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result=dbHandler.getUser(user);
        int counter=0;
        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if(counter>=1) {
            loginRegisterButton.getScene().getWindow().hide();

            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/MainMenu.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root=loader.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show ();



        }
        else{
                EnterButton.getScene().getWindow().hide();

                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource("/animations/Empty.fxml"));

                try {
                    loader.load();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Parent root=loader.getRoot();
                Stage stage=new Stage();
                stage.setScene(new Scene(root));
                stage.show();

        }


        }


    }
