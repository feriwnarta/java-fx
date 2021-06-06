package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class Controller {
    @FXML
    Label succesLogin;
    @FXML
    TextField tfUsername;
    @FXML
    TextField tfPassword;
    @FXML
    Button btnLogin;
    @FXML
    Button btnRegister;

    public void OnButtoClickedLogin(ActionEvent actionEvent) {
        if(tfUsername.getText().equals("admin") && tfPassword.getText().equals("admin")) {
            succesLogin.setText("Username dan password benar anda akan login");
            succesLogin.setTextFill(Paint.valueOf("blue"));
        } else {
            succesLogin.setText("username atau passord salah");
            succesLogin.setTextFill(Paint.valueOf("red"));
        }
    }

    public void OnButtoClickedRegister(ActionEvent actionEvent) {
        succesLogin.setText("Males dibikin");
    }
}
