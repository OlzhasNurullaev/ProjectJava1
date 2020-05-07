package sample;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Result {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button OkButton;

    @FXML
    private TextArea ClientAns;

    @FXML
    private TextArea MyAns;

    @FXML
    void initialize() {




    }

    DatabaseHandler dbHandler=new DatabaseHandler();
    UserAns user=new UserAns();
    ResultSet result=dbHandler.getAnswer(user);

    public void Chert(){
        ClientAns.setText(String.valueOf(result)+"\n");
    }
}
