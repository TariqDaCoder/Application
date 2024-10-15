module Application {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.desktop;
    requires java.sql;

    opens edu.metrostate.main to javafx.fxml;
    exports edu.metrostate.main;
    exports edu.metrostate.ApplicationController;
}
