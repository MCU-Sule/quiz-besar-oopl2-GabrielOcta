package com.gabriel.kuis2_1972037_gabrieloctamahardika;

import com.gabriel.kuis2_1972037_gabrieloctamahardika.dao.AnggotaDao;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.dao.BukuDao;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.dao.PeminjamanDao;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.entity.Buku;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.entity.Peminjaman;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
public class Controller2_1972037 implements Initializable {

    public TextField txtTitle;
    public TextField txtYear;
    public TextField txtId;
    public Button btnSave;
    public TextField txtPublish;
    public TextField txtAuthor;
    public TextField txtType;
    public TableView<Buku> tableView;
    public TableColumn<Buku, String> col1;
    public TableColumn<Buku, String> col2;
    public TableColumn<Buku, String> col3;
    public TableColumn<Buku, String> col4;
    public TableColumn<Buku, String> col5;
    public TableColumn<Buku, String> col6;
    private Controller1_1972037 controller1_1972037;

    private ObservableList<Buku> bukus;

    public void setController1_1972037(Controller1_1972037 controller1_1972037) {
        this.controller1_1972037 = controller1_1972037;
    }

    public void saveAction(ActionEvent actionEvent) {
        if(txtId.getText().trim().isEmpty() || txtAuthor.getText().trim().isEmpty() || txtType.getText().trim().isEmpty() ||
                txtPublish.getText().trim().isEmpty() || txtTitle.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Tolong isi semua field");
            alert.showAndWait();
        }
        else {
            Buku buku = new Buku();
            buku.setId(Integer.parseInt(txtId.getText()));
            buku.setJenisBuku(txtType.getText());
            buku.setJudul(txtTitle.getText());
            buku.setPenerbit(txtPublish.getText());
            buku.setPengarang(txtAuthor.getText());
            buku.setTahunTerbit(txtYear.getText());
            BukuDao bukuDao = new BukuDao();
            bukuDao.addData(buku);
            bukus.clear();
            bukus.addAll(bukuDao.showData());
            tableView.refresh();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BukuDao bukuDao = new BukuDao();
        bukus = bukuDao.showData();
        tableView.setItems(bukus);
        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getJudul())));
        col3.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getPenerbit())));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTahunTerbit())));
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getPengarang())));
        col6.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getJenisBuku())));
    }
}
