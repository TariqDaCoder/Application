module Application {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.desktop;
    requires java.sql;
    requires com.google.gson;

    opens edu.metrostate.main to javafx.fxml;
    exports edu.metrostate.main;
    opens edu.metrostate.ApplicationController to javafx.fxml;
    exports edu.metrostate.ApplicationController;
}
