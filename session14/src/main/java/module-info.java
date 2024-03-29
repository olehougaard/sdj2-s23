module dk.via {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;
    requires java.rmi;

    opens dk.via.calculator.view to javafx.fxml;
    opens dk.via.calculator to javafx.fxml;

    opens dk.via.calculator.model to com.google.gson;

    exports dk.via.calculator;
    exports dk.via.calculator.server;
    exports dk.via.calculator.shared;
}