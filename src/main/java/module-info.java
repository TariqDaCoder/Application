module Application {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.desktop;
    requires jsch;
    requires com.google.gson;
    requires java.sql;

    opens edu.metrostate.main to javafx.fxml;
    exports edu.metrostate.main;
    exports edu.metrostate.ApplicationController;
    opens edu.metrostate.ApplicationModel to com.google.gson;
}
