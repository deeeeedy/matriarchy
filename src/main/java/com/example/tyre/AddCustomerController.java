package com.example.tyre;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddCustomerController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField carNumberField;
    @FXML
    private TextField carModelField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField clientIdField;
    @FXML
    private Button ok;
    @FXML
    private Button cancel;
    private Customer person = new Customer();
    private Stage dialogStage;
    private boolean okClicked = false;
    @FXML
    private void initialize() {
        ok.setOnMouseClicked(event -> {
            if (isInputValid()) {
                person.setFirstName(firstNameField.getText());
                person.setLastName(lastNameField.getText());
                person.setCarModel(carModelField.getText());
                person.setCarNumber(carNumberField.getText());
                person.setPhoneNumber(phoneNumberField.getText());
                person.setClientId(Integer.parseInt(clientIdField.getText()));
                CustomerController.addCustomer(person);
                okClicked = true;
                ok.getScene().getWindow().hide();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.initOwner(dialogStage);
                alert.setTitle("Добавить клиента");
                alert.setHeaderText("Клиент успешно добавлен.");
                alert.showAndWait();
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
            }
        });
        cancel.setOnMouseClicked(event -> {
            cancel.getScene().getWindow().hide();
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
    public boolean isOkClicked() {
        return okClicked;
    }

    //Проверяет пользовательский ввод в текстовых полях.
    // return true, если пользовательский ввод корректен
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "Неверное имя!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "Неверная фамилия!\n";
        }
        if (carModelField.getText() == null || carModelField.getText().length() == 0) {
            errorMessage += "Неверная марка автомобиля!\n";
        }

        if (carNumberField.getText() == null || carNumberField.getText().length() == 0) {
            errorMessage += "Неверный номер автомобиля!\n";
        }

        if (phoneNumberField.getText() == null || phoneNumberField.getText().length() == 0) {
            errorMessage += "Неверный номер телефона!\n";
        }
        if (clientIdField.getText() == null || clientIdField.getText().length() == 0) {
            errorMessage += "Неверный номер клиента!\n";
        } else {
            // пытаемся преобразовать номер клиента в int.
            try {
                Integer.parseInt(clientIdField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Неверный номер клиента (должен быть числом)!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Поля заполнены неверно");
            alert.setHeaderText("Пожалуйста, введите верные данные!");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}

