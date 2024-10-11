package edu.metrostate.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Window");

        Button openButton = new Button("Open New Window");
        openButton.setOnAction(e -> openNewWindow());

        StackPane layout = new StackPane();
        layout.getChildren().add(openButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openNewWindow() {
        Stage newStage = new Stage();
        newStage.setTitle("New Window");

        Button closeButton = new Button("Close this window");
        closeButton.setOnAction(e -> newStage.close());

        StackPane newLayout = new StackPane();
        newLayout.getChildren().add(closeButton);

        Scene newScene = new Scene(newLayout, 200, 150);
        newStage.setScene(newScene);
        newStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
