package com.example.tyre;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class AddCustomerController {
    @FXML
    private Button cancel;
    public void initialize(){
        cancel.setOnMouseClicked(event -> {
            cancel.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("hello-view.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Шиномонтажка");
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}