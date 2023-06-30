package src.main.java;
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

        initRootLayout();

        showPersonOverview();
    }
    private ObservableList<Customer> personData = FXCollections.observableArrayList();

    public MainCustomer() {
        // В качестве образца добавляем некоторые данные
        personData.add(new Customer("Hans", "Muster"));
        personData.add(new Customer("Ruth", "Mueller"));
        personData.add(new Customer("Heinz", "Kurz"));
        personData.add(new Customer("Cornelia", "Meier"));
        personData.add(new Customer("Werner", "Meyer"));
        personData.add(new Customer("Lydia", "Kunz"));
        personData.add(new Customer("Anna", "Best"));
        personData.add(new Customer("Stefan", "Meier"));
        personData.add(new Customer("Martin", "Mueller"));
    }

    public ObservableList<Customer> getPersonData() {
        return personData;
    }
    public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainCustomer.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonOverview() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainCustomer.class.getResource("CustomerTable.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(personOverview);
            // Даём контроллеру доступ к главному приложению.
            CustomerController controller = loader.getController();
            controller.setMainApp(this);

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