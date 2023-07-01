package com.example.tyre;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button timeTable;
    @FXML
    private Button openCustomerTable;


    @FXML
    public void initialize(){
        timeTable.setOnMouseClicked(event -> {
            timeTable.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("timetable.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Время работы");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
        );
        openCustomerTable.setOnMouseClicked(event -> {
            openCustomerTable.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CustomerTable.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Список клиентов");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

}