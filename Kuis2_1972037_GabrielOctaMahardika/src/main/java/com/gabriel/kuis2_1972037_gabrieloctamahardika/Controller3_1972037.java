package com.gabriel.kuis2_1972037_gabrieloctamahardika;

import com.gabriel.kuis2_1972037_gabrieloctamahardika.dao.AnggotaDao;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.dao.BukuDao;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.entity.Anggota;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.entity.Buku;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

/**
 * @Author 1972037 Gabriel Octa Mahardika
 **/
public class Controller3_1972037 implements Initializable {

    public TextField txtName;
    public TextField txtId;
    public Button btnSave;
    public TextField txtPhone;
    public DatePicker txtLahir;
    public DatePicker txtMasuk;
    public TableView<Anggota> tableView;
    public TableColumn<Anggota, String> col1;
    public TableColumn<Anggota, String> col2;
    public TableColumn<Anggota, String> col3;
    public TableColumn<Anggota, String> col4;
    public TableColumn<Anggota, String> col5;
    private Controller1_1972037 controller1_1972037;

    private ObservableList<Anggota> anggotas;

    public void setController1_1972037(Controller1_1972037 controller1_1972037) {
        this.controller1_1972037 = controller1_1972037;
    }

    public void saveAction(ActionEvent actionEvent) {
        if(txtId.getText().trim().isEmpty() || txtPhone.getText().trim().isEmpty() || txtName.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Tolong isi semua field");
            alert.showAndWait();
        }
        else {
            Anggota anggota = new Anggota();
            anggota.setId(Integer.parseInt(txtId.getText()));
            anggota.setNama(txtName.getText());
            anggota.setNotelpon(txtPhone.getText());
            anggota.setTglLahir(Date.valueOf(txtLahir.getValue()));
            anggota.setTglMasuk(Date.valueOf(txtMasuk.getValue()));
            AnggotaDao anggotaDao = new AnggotaDao();
            anggotaDao.addData(anggota);
            anggotas.clear();
            anggotas.addAll(anggotaDao.showData());
            tableView.refresh();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AnggotaDao anggotaDao = new AnggotaDao();
        anggotas = anggotaDao.showData();
        tableView.setItems(anggotas);
        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getNama())));
        col3.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getNotelpon())));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTglLahir())));
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTglMasuk())));
    }
}
