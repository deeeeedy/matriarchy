package com.example.tyre;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class TimetableController {

    @FXML
    private TableView<Master> Table;
    @FXML
    private TableColumn<Master, String> Master;
    @FXML
    private TableColumn<Master, String> Monday;
    @FXML
    private TableColumn<Master, String> Tuesday;
    @FXML
    private TableColumn<Master, String> Wednesday;
    @FXML
    private TableColumn<Master, String> Thursday;
    @FXML
    private TableColumn<Master, String> Friday;
    @FXML
    private TableColumn<Master, String> Saturday;
    @FXML
    private TableColumn<Master, String> Sunday;

    ObservableList<Master> master = FXCollections.observableArrayList(
            new Master("Андрей", "9:00-20:00","9:00-20:00", " - ", " - ", "9:00-20:00", "9:00-20:00", " - "),
            new Master("Олег", " - "," - ", "9:00-20:00", "9:00-20:00", " - "," - ", "9:00-20:00")
    );
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
        Master.setCellValueFactory(new PropertyValueFactory<Master,String> ("Master"));
        Monday.setCellValueFactory(new PropertyValueFactory<Master,String> ("Monday"));
        Tuesday.setCellValueFactory(new PropertyValueFactory<Master,String> ("Tuesday"));
        Wednesday.setCellValueFactory(new PropertyValueFactory<Master,String> ("Wednesday"));
        Thursday.setCellValueFactory(new PropertyValueFactory<Master,String> ("Thursday"));
        Friday.setCellValueFactory(new PropertyValueFactory<Master,String> ("Friday"));
        Saturday.setCellValueFactory(new PropertyValueFactory<Master,String> ("Saturday"));
        Sunday.setCellValueFactory(new PropertyValueFactory<Master,String> ("Sunday"));

        Table.setItems(master);
    }


}
