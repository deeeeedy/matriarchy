package com.example.tyre;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimetableController {
    @FXML
    private Button exit;
    @FXML
    private AnchorPane backgr;
    @FXML
    private Label dateLabel;
    private String date = new SimpleStringProperty(new SimpleDateFormat("dd-MM-yyyy").format(new Date())).getValue();
    @FXML
    void initialize() {
            backgr.setStyle(HelloController.getStyle());
            dateLabel.setText(date);

        exit.setOnMouseClicked(event -> {
            exit.getScene().getWindow().hide();
        });
    }


}
