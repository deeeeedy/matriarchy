package com.example.tyre;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

public class PriceController {
    @FXML
    private Button exit;
    @FXML
    private AnchorPane backgr;
    @FXML
    private ChoiceBox type;
    @FXML
    private ChoiceBox diameter;
    @FXML
    private ChoiceBox number;
    @FXML
    void initialize() {
        backgr.setStyle(HelloController.getStyle());

        exit.setOnMouseClicked(event -> {
            exit.getScene().getWindow().hide();
        });

    }
    @FXML
    private void getPrice(){

    }

}
