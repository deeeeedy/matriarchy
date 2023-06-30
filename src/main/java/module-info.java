module com.example.tyre {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tyre to javafx.fxml;
    exports com.example.tyre;
}