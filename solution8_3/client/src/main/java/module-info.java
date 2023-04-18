module com.example.client {
    requires javafx.controls;
    requires javafx.fxml;


    opens view to javafx.fxml;
    exports app;
}