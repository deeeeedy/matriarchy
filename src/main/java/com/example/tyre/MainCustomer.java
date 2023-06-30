package com.example.tyre;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainCustomer extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Список клиентов");
        showPersonOverview();
    }
    private ObservableList<Customer> personData = FXCollections.observableArrayList();

    public MainCustomer() {
        // В качестве образца добавляем некоторые данные
        personData.add(new Customer("Александр", "Сушков"));
        personData.add(new Customer("Лариса", "Кузнецова"));
        personData.add(new Customer("Григорий", "Плечев"));
        personData.add(new Customer("Каролина", "Ежова"));
        personData.add(new Customer("Вячеслав", "Григорьев"));
        personData.add(new Customer("Лидия", "Иванова"));
        personData.add(new Customer("Анна", "Воронина"));
        personData.add(new Customer("Степан", "Петров"));
        personData.add(new Customer("Марк", "Гончаров"));
    }

    public ObservableList<Customer> getPersonData() {
        return personData;
    }
    public void showPersonOverview() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainCustomer.class.getResource("CustomerTable.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            CustomerController controller = loader.getController();
            controller.setMainApp(this);
            Scene scene = new Scene(personOverview);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}