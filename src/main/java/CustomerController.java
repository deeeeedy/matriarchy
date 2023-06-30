package src.main.java;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CustomerController {
    @FXML
    private TableView<Customer> personTable;
    @FXML
    private TableColumn<Customer, String> firstNameColumn;
    @FXML
    private TableColumn<Customer, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label carNumberLabel;
    @FXML
    private Label carModelLabel;
    @FXML
    private Label phoneNumberLabel;
    @FXML
    private Label clientIdLabel;

    // Ссылка на главное приложение.
    private MainCustomer mainApp;

    public CustomerController() {
    }

    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        // Очистка дополнительной информации об адресате.
        showPersonDetails(null);

        // Слушаем изменения выбора, и при изменении отображаем
        // дополнительную информацию об адресате.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }
    private void showPersonDetails(Customer person) {
        if (person != null) {
            // Заполняем метки информацией из объекта person.
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            carNumberLabel.setText(Integer.toString(person.getCarNumber()));
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
    }
    public void setMainApp(MainCustomer mainApp) {
        this.mainApp = mainApp;

        // Добавление в таблицу данных из наблюдаемого списка
        personTable.setItems(mainApp.getPersonData());
    }
}