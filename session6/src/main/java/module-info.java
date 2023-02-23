module mvvm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens dk.via.mvvm.view to javafx.fxml;
    opens dk.via.mvvm to javafx.fxml;

    exports dk.via.mvvm;
}
