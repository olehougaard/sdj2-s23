module dk.via {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens dk.via.session5.exercise5_2.view to javafx.fxml;
    opens dk.via.session5.exercise5_2 to javafx.fxml;
    opens dk.via.session5.exercise5_1.view to javafx.fxml;
    opens dk.via.session5.exercise5_1 to javafx.fxml;
    opens dk.via.session5.exercise5_3.view to javafx.fxml;
    opens dk.via.session5.exercise5_3 to javafx.fxml;

    exports dk.via.session5.exercise5_2;
    exports dk.via.session5.exercise5_1;
    exports dk.via.session5.exercise5_3;
}