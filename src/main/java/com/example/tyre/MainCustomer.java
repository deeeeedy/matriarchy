package com.example.tyre;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainCustomer extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Список клиентов");
        showPersonOverview();
    }
    private ObservableList<Customer> personData = FXCollections.observableArrayList();

    public MainCustomer() {
        // В качестве образца добавляем некоторые данные
        personData.add(new Customer("Александр", "Сушков", "311", "Nissan", "89995443106", 1));
        personData.add(new Customer("Лариса", "Кузнецова", "448", "Kia", "89630578961", 2));
        personData.add(new Customer("Григорий", "Плечев", "418", "lada", "8963542133333", 3));
        personData.add(new Customer("Каролина", "Ежова", "416", "Bmw", "896358995223", 4));
        personData.add(new Customer("Вячеслав", "Григорьев", "008", "lada", "8963542133333", 5));
        personData.add(new Customer("Лидия", "Иванова", "114", "Haval", "8963542133333", 6));
        personData.add(new Customer("Анна", "Воронина", "000", "Mercedes", "89003002211", 7));
        personData.add(new Customer("Степан", "Петров", "101", "Ford", "8963544433333", 8));
        personData.add(new Customer("Марк", "Гончаров", "106", "lexus", "8911542133333", 9));
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