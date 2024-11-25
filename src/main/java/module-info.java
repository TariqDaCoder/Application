module Application {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.desktop;
    requires jsch;
    requires com.google.gson;
    requires java.sql;

    opens edu.metrostate.PageController to javafx.fxml;
    exports edu.metrostate.PageController;
    exports edu.metrostate.ApplicationController;
    opens edu.metrostate.ApplicationModel to com.google.gson;
}
