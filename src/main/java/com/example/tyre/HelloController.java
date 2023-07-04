package com.example.tyre;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button timeTable;
    @FXML
    private Button openCustomerTable;
    @FXML
    private Button addCustomer;


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
            stage.setResizable(false);
            stage.showAndWait();
        });
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
            stage.setResizable(false);
            stage.showAndWait();
        });
        addCustomer.setOnMouseClicked(event -> {
            addCustomer.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("addCustomer.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Добавить клиента");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait();
        });
    }

}