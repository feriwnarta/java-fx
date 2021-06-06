package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.*;

public class Controller {
    @FXML
    private TextField tfNim;
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfAlamat;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnLoad;
    @FXML
    private TableView tvDataMhs;


    public void onButtonSubmitClicked(ActionEvent actionEvent) {
        ObservableList<MahasiswaModel> data = tvDataMhs.getItems();
        data.add(new MahasiswaModel(
                tfNama.getText(),
                tfNim.getText(),
                tfAlamat.getText()
        ));
    }

    public void onBtnSaveClicked(ActionEvent actionEvent) {
        // menyimpan hasil inputan melalu tableview kedalam file.txt (menulis file dgn bufferedwriter)
        ObservableList<MahasiswaModel> data = tvDataMhs.getItems();
        BufferedWriter writer;

        try {
            // simpan file
            writer = new BufferedWriter(new FileWriter("datamahasiswa.txt"));
            for(MahasiswaModel result : data){
                writer.write(result.getNama() + ", " + result.getNim() + ", " + result.getAlamat());
                writer.newLine();
            }
            writer.flush();
            writer.close();

            // alert jika berhasil menyimpan file
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Berhasil");
            alert.setContentText("Berhasil menyimpan data");
            alert.showAndWait();
        } catch (IOException exception){
            // alert jika gagal menyimpan file
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Eror menyimpan file");
            alert.showAndWait();
        }
    }

    public void onBtnLoadClicked(ActionEvent actionEvent) {
        ObservableList<MahasiswaModel> data = tvDataMhs.getItems();
        data.clear();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("datamahasiswa.txt"));
            String read = reader.readLine();
            while(read != null) {
                // memotong isi file, menjadi array string dengan delimiter ','
                String[] temp = read.split(",");
                // bikin 1 objek dan mengisi seluruh field dengan array yg dipecah tadi
                MahasiswaModel mhs = new MahasiswaModel(temp[0], temp[1], temp[2]);
                // memasukan / menambah objek mahasiswa kedalam table view, agar ditampilkan di ui
                // control tableview
                data.add(mhs);
            }
            reader.close();

            // alert jika berhasil load file
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Berhasil");
            alert.setContentText("Berhasil meload data");
            alert.showAndWait();
        } catch (IOException exception) {
            // alert jika gagal meload file
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Eror meload data");
            alert.showAndWait();
        }

    }
}

