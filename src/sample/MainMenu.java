package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button MainMenu;

    @FXML
    private Button FAQMenu;

    @FXML
    private Button AboutUsMenu;

    @FXML
    private Button ExitMenu;

    @FXML
    private Button SubjectMenu;

    @FXML
    private Button ContactMenu;

    @FXML
    private Button TakeTestMenu;

    @FXML
    private Button ResultsMenu;

    @FXML
    private ImageView serchimage;

    @FXML
    private ImageView aboutusimage;

    @FXML
    private ImageView MainImage;

    @FXML
    private ImageView supportimage;

    @FXML
    private ImageView exitimage;

    @FXML
    private ImageView CreaterMenu;

    @FXML
    private ImageView taketestimage;

    @FXML
    private ImageView ContactImage;

    @FXML
    private ImageView resultimage;

    @FXML
    private Button SupprotMenu;
    @FXML
    void initialize() {
        MainMenu.setOnAction(event -> {
            MainMenu.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/MainMenu.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ContactMenu.setOnAction(event -> {
            ContactMenu.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/ContactUs.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ExitMenu.setOnAction(event -> {
            ExitMenu.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        TakeTestMenu.setOnAction(event -> {
            TakeTestMenu.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Test.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        AboutUsMenu.setOnAction(event -> {
            AboutUsMenu.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/AboutUs.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        SubjectMenu.setOnAction(event -> {
            SubjectMenu.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/SubjectTest.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        FAQMenu.setOnAction(event -> {
            FAQMenu.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FAQ.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }


    }