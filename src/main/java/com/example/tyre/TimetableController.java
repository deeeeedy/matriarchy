package com.example.tyre;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TimetableController {
    @FXML
    private Button exit;
    @FXML
    private AnchorPane backgr;
    private String style = HelloController.getStyle();
    @FXML
    void initialize() {
            backgr.setStyle(HelloController.getStyle());

        exit.setOnMouseClicked(event -> {
            exit.getScene().getWindow().hide();
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
            stage.setResizable(false);
            stage.show();
        });
    }


}
