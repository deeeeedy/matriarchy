package com.example.tyre;
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("Шиномонтажка");
        primaryStage.setScene(new Scene(root, primaryStage.getWidth(), primaryStage.getHeight()));
        primaryStage.setResizable(false);
        primaryStage.show();
       addBase();
       //Customer c = new Customer();
      // System.out.println(c.getAddingDate());


    }

    public static void main(String[] args) {
        launch(args);
    }
    private void addBase(){
        CustomerController.addCustomer(new Customer("Анжелика", "Петрова", "533", "феррари", "89630875203", 1, "04-07-2023"));
        CustomerController.addCustomer(new Customer("Мария", "Пихтовникова", "333", "бмв", "89630873603", 2, "04-07-2023"));
        CustomerController.addCustomer(new Customer("Дарья", "Санатина", "777", "ауди", "89990875203", 3, "04-07-2023"));
        CustomerController.addCustomer(new Customer("Мария", "Будяк", "444", "ауди", "89967561403", 4, "04-07-2023"));
        CustomerController.addCustomer(new Customer("Наталья", "Офицерова", "634", "ниссан", "89865984522", 5, "04-07-2023"));
        CustomerController.addCustomer(new Customer("Александр", "Иванов", "533", "лада", "89996320134", 6, "04-07-2023"));


    }
}
