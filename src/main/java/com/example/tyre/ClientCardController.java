package com.example.tyre;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientCardController {
    @FXML
    private Label firstNameLabel = new Label();
    @FXML
    private Label lastNameLabel = new Label();
    @FXML
    private Label carNumberLabel = new Label();
    @FXML
    private Label carModelLabel = new Label();
    @FXML
    private Label phoneNumberLabel = new Label();
    @FXML
    private Label clientIdLabel = new Label();
    @FXML
    private Button exit;
    @FXML
    private AnchorPane backgr;
    private static Customer customer = new Customer();

    public static void setCustomer(Customer customer) {
        ClientCardController.customer = customer;
    }

    @FXML
    private void initialize() {
        backgr.setStyle(HelloController.getStyle());
        exit.setOnMouseClicked(event -> {
            exit.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CustomerTable.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Информация о клиенте");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        });
        showPersonDetails(customer);

    }
    public void showPersonDetails(Customer person) {
        if (person != null) {
            // Заполняем метки информацией из объекта person.
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            carNumberLabel.setText(person.getCarNumber());
            carModelLabel.setText(person.getCarModel());
            phoneNumberLabel.setText(person.getPhoneNumber());
            clientIdLabel.setText(Integer.toString(person.getClientId()));

        } else {
            // Если Person = null, то убираем весь текст.
            firstNameLabel.setText("Клиент не выбран");
            lastNameLabel.setText("Клиент не выбран");
            carNumberLabel.setText("");
            carModelLabel.setText("");
            phoneNumberLabel.setText("");
            clientIdLabel.setText("");
        }
    }
}

