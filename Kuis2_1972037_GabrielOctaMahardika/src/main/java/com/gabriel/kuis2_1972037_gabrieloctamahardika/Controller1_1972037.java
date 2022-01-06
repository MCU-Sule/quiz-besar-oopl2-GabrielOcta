package com.gabriel.kuis2_1972037_gabrieloctamahardika;

import com.gabriel.kuis2_1972037_gabrieloctamahardika.dao.AnggotaDao;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.dao.BukuDao;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.dao.PeminjamanDao;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.entity.Anggota;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.entity.Buku;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.entity.Peminjaman;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * @Author 1972037 Gabriel Octa Mahardika
 **/
public class Controller1_1972037 implements Initializable {
    public ComboBox<Anggota> comboAnggota;
    public TextField txtId;
    public ComboBox comboLangauge;
    public ComboBox<Buku> comboBook;
    public DatePicker txtPeminjaman;
    public DatePicker txtPengembalian;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnDelete;
    public Button btnReset;
    public TableView<Peminjaman> tableView;
    public TableColumn<Peminjaman, String> col1;
    public TableColumn<Peminjaman, String> col2;
    public TableColumn<Peminjaman, String> col3;
    public TableColumn<Peminjaman, String> col4;
    public TableColumn<Peminjaman, String> col5;
    public Menu file;
    public Menu edit;
    public MenuItem member;
    public MenuItem book;

    private ObservableList<Buku> bukus;
    private ObservableList<Anggota> anggotas;
    private ObservableList<Peminjaman> peminjamanList;
    private Peminjaman selectedItem;

    public ObservableList<Buku> getBukus() {
        return bukus;
    }

    public ObservableList<Anggota> getAnggotas() {
        return anggotas;
    }

    public void saveAction(ActionEvent actionEvent) {
        if(txtId.getText().trim().isEmpty() || comboAnggota.getItems().isEmpty() || comboBook.getItems().isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Tolong isi semua field");
            alert.showAndWait();
        }
        else {
            Peminjaman peminjaman = new Peminjaman();
            peminjaman.setId(Integer.parseInt(txtId.getText()));
            peminjaman.setTanggalPinjam(Date.valueOf(txtPeminjaman.getValue()));
            peminjaman.setTanggalPengembalian(Date.valueOf(txtPengembalian.getValue()));
            peminjaman.setAnggotaByAnggotaId(comboAnggota.getValue());
            peminjaman.setBukuByBukuId(comboBook.getValue());
            PeminjamanDao peminjamanDao = new PeminjamanDao();
            peminjamanDao.addData(peminjaman);
            peminjamanList.clear();
            peminjamanList.addAll(peminjamanDao.showData());
            tableView.refresh();
        }
    }

    public void updateAction(ActionEvent actionEvent) {
        if(txtId.getText().trim().isEmpty() || comboAnggota.getItems().isEmpty() || comboBook.getItems().isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Tolong isi semua field");
            alert.showAndWait();
        }
        else {
            selectedItem = tableView.getSelectionModel().getSelectedItem();
            System.out.println(selectedItem);

            selectedItem.setId(Integer.parseInt(txtId.getText()));
            selectedItem.setTanggalPinjam(Date.valueOf(txtPeminjaman.getValue()));
            selectedItem.setTanggalPengembalian(Date.valueOf(txtPengembalian.getValue()));
            selectedItem.setAnggotaByAnggotaId(comboAnggota.getValue());
            selectedItem.setBukuByBukuId(comboBook.getValue());

            PeminjamanDao peminjamanDao = new PeminjamanDao();
            int result = peminjamanDao.updateData(selectedItem);
            if (result != 0) {
                System.out.println("Update Berhasil");
            }
            peminjamanList.clear();
            peminjamanList.addAll(peminjamanDao.showData());
            txtId.setDisable(false);
            btnSave.setDisable(false);
            btnUpdate.setDisable(true);
            btnDelete.setDisable(true);
        }
    }

    public void deleteAction(ActionEvent actionEvent) {
        if(txtId.getText().trim().isEmpty() || comboAnggota.getItems().isEmpty() || comboBook.getItems().isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Tolong isi semua field");
            alert.showAndWait();
        }
        else {
            selectedItem = tableView.getSelectionModel().getSelectedItem();
            System.out.println(selectedItem);

            PeminjamanDao peminjamanDao = new PeminjamanDao();
            int result = peminjamanDao.delData(selectedItem);
            if (result != 0) {
                System.out.println("Update Berhasil");
            }
            peminjamanList.clear();
            peminjamanList.addAll(peminjamanDao.showData());
            txtId.setDisable(false);
            btnSave.setDisable(false);
            btnUpdate.setDisable(true);
            btnDelete.setDisable(true);
        }
    }

    public void clickedAction(MouseEvent mouseEvent) {
        selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            txtId.setText(String.valueOf(selectedItem.getId()));
            txtPeminjaman.setValue(LocalDate.parse(String.valueOf(selectedItem.getTanggalPinjam())));
            txtPeminjaman.setValue(LocalDate.parse(String.valueOf(selectedItem.getTanggalPinjam())));
            comboAnggota.setValue(selectedItem.getAnggotaByAnggotaId());
            comboBook.setValue(selectedItem.getBukuByBukuId());
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
            btnSave.setDisable(true);
            txtId.setDisable(true);
        }
    }

    public void resetAction(ActionEvent actionEvent) {
        txtId.clear();
        txtPeminjaman.setValue(null);
        txtPengembalian.setValue(null);
        comboBook.setValue(null);
        comboAnggota.setValue(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BukuDao bukuDao = new BukuDao();
        AnggotaDao anggotaDao = new AnggotaDao();
        PeminjamanDao peminjamanDao = new PeminjamanDao();
//        bukus = bukuDao.showData();
//        comboBook.setItems(bukus);
//        anggotas = anggotaDao.showData();
//        comboAnggota.setItems(anggotas);
//        peminjamanList = peminjamanDao.showData();
//        tableView.setItems(peminjamanList);
        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getAnggotaByAnggotaId())));
        col3.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getBukuByBukuId())));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTanggalPinjam())));
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTanggalPengembalian())));
    }

    public void memberClick(ActionEvent actionEvent) throws IOException {
        Stage new_stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bookManagement.fxml"));
        Parent root = loader.load();
        Controller3_1972037 controller3 = loader.getController();
        controller3.setController1_1972037(this);
        Scene new_scene = new Scene(root);
        new_stage.setScene(new_scene);
        new_stage.initModality(Modality.WINDOW_MODAL);
        new_stage.setTitle("Anggota Management");
        new_stage.show();
    }

    public void bookClick(ActionEvent actionEvent) throws IOException {
        Stage new_stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MemberManagement.fxml"));
        Parent root = loader.load();
        Controller2_1972037 controller2 = loader.getController();
        controller2.setController1_1972037(this);
        Scene new_scene = new Scene(root);
        new_stage.setScene(new_scene);
        new_stage.initModality(Modality.WINDOW_MODAL);
        new_stage.setTitle("Member Management");
        new_stage.show();
    }
}