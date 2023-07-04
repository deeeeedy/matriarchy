package com.example.tyre;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class TimetableController {
    @FXML
    private Button exit;
    @FXML
    private AnchorPane backgr;
    @FXML
    void initialize() {
            backgr.setStyle(HelloController.getStyle());

        exit.setOnMouseClicked(event -> {
            exit.getScene().getWindow().hide();
        });
    }


}
