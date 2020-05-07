package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SignUpLogin;

    @FXML
    private PasswordField SignUpPassword;

    @FXML
    private Button SignUpEnterButton;

    @FXML
    private TextField SignUpName;

    @FXML
    private TextField SignUpSurname;

    @FXML
    private TextField SignUpEmail;

    @FXML
    private CheckBox SignUpChekWomen;

    @FXML
    private CheckBox SingUpChekMan;

    @FXML
    private Button BackSignUpButton;

    @FXML
    void initialize() {
        SignUpEnterButton.setOnAction(event ->{
            signUpNewUser();
        });
        BackSignUpButton.setOnAction(event -> {
            BackSignUpButton.getScene().getWindow().hide();

            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root=loader.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void signUpNewUser() {

        SignUpEnterButton.setOnAction(event -> {
            String firstNameText = SignUpName.getText().trim();
            String lastNameText = SignUpSurname.getText().trim();
            String emailText = SignUpEmail.getText().trim();
            String maleBox = SingUpChekMan.getText().trim();
            String femaleBox = SignUpChekWomen.getText().trim();
            String loginText = SignUpLogin.getText().trim();
            String Password = SignUpPassword.getText().trim();
            if (!loginText.equals("") && !Password.equals("") && !firstNameText.equals("") && !lastNameText.equals("") && !emailText.equals("") && (!maleBox.equals("") || !femaleBox.equals(""))){

                SignUpEnterButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/signIn.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
            else
                System.out.println("Error");
        });

        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = SignUpName.getText();
        String lastName = SignUpSurname.getText();
        String userName = SignUpLogin.getText();
        String password = SignUpPassword.getText();
        String email = SignUpEmail.getText();
        String gender = "";
        if(SignUpChekWomen.isSelected())
            gender = "Women";
        else
            gender = "Man";

        User user = new User(firstName, lastName, userName, password, email, gender);

        dbHandler.signUpUser(user);
    }

}

