package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import javax.swing.*;

public class Controller {
    @FXML
    private TextField tfNama;

    @FXML
    private Label lblSayHello;

    public void onButtonSayHelloClicked(ActionEvent actionEvent) {
       lblSayHello.setText("Hello, " + tfNama.getText());
    }
}
