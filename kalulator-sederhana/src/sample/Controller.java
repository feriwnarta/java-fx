package sample;

import com.sun.javafx.binding.StringFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tfHasil;
    @FXML
    private Button btnTambah;
    @FXML
    private Button btnKali;
    @FXML
    private Button btnKurang;
    @FXML
    private Button btnBagi;

    @FXML
    public void onButtonClicked(ActionEvent actionEvent) {
        BilanganModel model = new BilanganModel();

        // menjadikan input dari textfield menjadi double dan dimasukan kedalam atribut bilangan di objek model
        try {
            model.setBilanganPertama(Double.parseDouble(tf1.getText()));
            model.setBilanganKedua(Double.parseDouble(tf2.getText()));
        } catch (NumberFormatException ex) {
            System.err.println("Input harus Angka");
        }

        // proses data +*-/
        if(actionEvent.getTarget().equals(btnTambah)) {
            model.setHasil(model.getBilanganPertama() + model.getBilanganKedua());
            tfHasil.setText(String.valueOf(model.getHasil()));
        } else if(actionEvent.getTarget().equals(btnKurang)) {
            model.setHasil(model.getBilanganPertama() - model.getBilanganKedua());
            tfHasil.setText(String.valueOf(model.getHasil()));
        } else if(actionEvent.getTarget().equals(btnKali)) {
            model.setHasil(model.getBilanganPertama() * model.getBilanganKedua());
            tfHasil.setText(String.valueOf(model.getHasil()));
        } else if(actionEvent.getTarget().equals(btnBagi)) {
            model.setHasil(model.getBilanganPertama() / model.getBilanganKedua());
            tfHasil.setText(String.valueOf(model.getHasil()));
        } else {
            tfHasil.setText("Ada yang salah di method on button");
        }

    }
}
