package com.example.tyre;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private Stage dialogStage;
    @FXML
    void initialize() {
        backgr.setStyle(HelloController.getStyle());

        exit.setOnMouseClicked(event -> {
            exit.getScene().getWindow().hide();
        });
        ObservableList<String> typeList = FXCollections.observableArrayList("Легковой", "Внедорожник");
        type.setItems(typeList);
        type.setValue("Легковой");
        ObservableList<String> diameterList = FXCollections.observableArrayList("R13", "R14","R15","R16","R17",
                "R18", "R19","R20","R21","R22");
        diameter.setItems(diameterList);
        diameter.setValue("R14");
        ObservableList<String> numberList = FXCollections.observableArrayList("1", "2", "3", "4");
        number.setItems(numberList);
        number.setValue("4");

    }
    @FXML
    private void getPrice(){
        int result = 0;
        if(type.getValue() == "Легковой"){
            switch (diameter.getValue().toString()){
                case ("R13"):
                case ("R14"):
                case ("R15"):
                    result = 375;
                    break;
                case ("R16"):
                    result = 450;
                    break;
                case ("R17"):
                    result = 525;
                    break;
                case ("R18"):
                    result = 600;
                    break;
                case ("R19"):
                    result = 750;
                    break;
                case ("R20"):
                    result = 900;
                    break;
                case ("R21"):
                    result = 1050;
                    break;
                case ("R22"):
                    result = 1200;
                    break;
            }
        }
        else {
            switch (diameter.getValue().toString()){
                case ("R13"):
                case ("R14"):
                case ("R15"):
                    result = 525;
                    break;
                case ("R16"):
                    result = 600;
                    break;
                case ("R17"):
                    result = 675;
                    break;
                case ("R18"):
                    result = 750;
                    break;
                case ("R19"):
                    result = 900;
                    break;
                case ("R20"):
                    result = 1050;
                    break;
                case ("R21"):
                    result = 1200;
                    break;
                case ("R22"):
                    result = 1350;
                    break;
            }
        }
        int newResult = result * Integer.parseInt(number.getValue().toString());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(dialogStage);
        alert.setTitle("Стоимость");
        alert.setHeaderText("Стоимость услуг составит: " + newResult + " руб.");
        alert.showAndWait();

    }

}
