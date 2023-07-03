package com.example.tyre;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class CustomerController {
    @FXML
    private TableView<Customer> personTable = new TableView<>();
    @FXML
    private TableColumn<Customer, String> firstNameColumn;
    @FXML
    private TableColumn<Customer, String> lastNameColumn;
    @FXML
    private Button exit;
    @FXML
    private Button info;
    @FXML
    private Button delete;
    private Stage dialogStage;
    private ClientCardController clientCardController = new ClientCardController();
    private static ObservableList<Customer> personData = FXCollections.observableArrayList();
    public static void addCustomer(Customer customer){
        personData.add(customer);
    }

    public CustomerController() {
    }

    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        personTable.setItems(personData);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        info.setOnMouseClicked(event -> {
            info.getScene().getWindow().hide();
            ClientCardController.setCustomer(personTable.getSelectionModel().getSelectedItem());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ClientCard.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Информация о клиенте");
            stage.setScene(new Scene(root));
            stage.show();
        });
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
            stage.show();
        });
    }
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(dialogStage);
            alert.setTitle("Не выбрано");
            alert.setHeaderText("Не выбран пользователь");
            alert.setContentText("Пожалуйста, выберите пользователя в таблице.");
            alert.showAndWait();
        }
    }

}