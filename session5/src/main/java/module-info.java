module mvvm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens dk.via.mvvm.view to javafx.fxml;
    opens dk.via.mvvm to javafx.fxml;
    opens com.example.session5 to javafx.fxml;

    exports com.example.session5;
    exports dk.via.mvvm;
}