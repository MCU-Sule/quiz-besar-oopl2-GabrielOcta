package com.gabriel.kuis2_1972037_gabrieloctamahardika;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @Author 1972037 Gabriel Octa Mahardika
 **/
public class Application_1972037 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application_1972037.class.getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Kuis #2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}