module dk.via {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens dk.via.exercise6_1 to javafx.fxml;
    opens dk.via.exercise6_1.view to javafx.fxml;
    opens dk.via.exercise6_2 to javafx.fxml;
    opens dk.via.exercise6_2.view to javafx.fxml;

    exports dk.via.exercise6_1;
    exports dk.via.exercise6_2;
}