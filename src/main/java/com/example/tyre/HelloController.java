package com.example.tyre;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
public class HelloController {

    @FXML
    private Button button;

    @FXML
    public void initialize(){
        button.setOnMouseClicked(event -> {
        });
    }

}