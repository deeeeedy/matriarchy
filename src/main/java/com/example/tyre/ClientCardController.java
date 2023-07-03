package com.example.tyre;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private static Customer customer = new Customer();

    public static void setCustomer(Customer customer) {
        ClientCardController.customer = customer;
    }

    @FXML
    private void initialize() {
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
            stage.show();
        });
        firstNameLabel.setText(customer.getFirstName());
        lastNameLabel.setText(customer.getLastName());
        carNumberLabel.setText(customer.getCarNumber());
        carModelLabel.setText(customer.getCarModel());
        phoneNumberLabel.setText(customer.getPhoneNumber());
        clientIdLabel.setText(Integer.toString(customer.getClientId()));

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
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            carNumberLabel.setText("");
            carModelLabel.setText("");
            phoneNumberLabel.setText("");
            clientIdLabel.setText("");
        }
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
    }
}

