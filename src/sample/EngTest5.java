package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EngTest5 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton A;

    @FXML
    private ToggleGroup Answer;

    @FXML
    private RadioButton B;

    @FXML
    private RadioButton C;

    @FXML
    private RadioButton d;

    @FXML
    private Button NextButton1;

    @FXML
    private Button EnterButton;

    @FXML
    private Text True;

    @FXML
    private Text text1;

    @FXML
    private Text text2;

    @FXML
    private Text text3;

    @FXML
    void initialize(MouseEvent event) {
        if (A.isSelected()) {
            True.setFill(Color.GREEN);
        }
        if (B.isSelected()) {
            True.setFill(Color.RED);
        }
        if (C.isSelected()) {
            True.setFill(Color.RED);
        }
        if (d.isSelected()) {
            True.setFill(Color.RED);
        }
    }
    @FXML
    void initialize () {
        NextButton1.setOnAction(event -> {
            NextButton1.getScene().getWindow().hide();

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


    }
}