// View class
package edu.metrostate.ApplicationView;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class SportView {
    private Stage stage;
    private ListView<String> teamListView;

    public SportView(Stage stage) {
        this.stage = stage;
        this.teamListView = new ListView<>();
        VBox vbox = new VBox(teamListView);
        Scene scene = new Scene(vbox, 300, 250);
        stage.setScene(scene);
        stage.setTitle("Sports Teams");
    }

    public void show() {
        stage.show();
    }

    public void setTeamList(List<String> teams) {
        teamListView.getItems().clear();
        teamListView.getItems().addAll(teams);
    }
}
