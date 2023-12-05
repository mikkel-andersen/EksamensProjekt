package gui2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class LoginWindow extends Application {

    private Stage stage;
    private BorderPane loginPane;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Login - Fade og Destillationer");

        loginPane = new BorderPane();
        initLoginContent();

        Scene loginScene = new Scene(loginPane);
        stage.setScene(loginScene);
        stage.setHeight(500);
        stage.setWidth(500);
        stage.show();
    }

    private void initLoginContent() {

        Image image = new Image() {}


        Button startButton = new Button("Start");
        startButton.setMinSize(100, 70);
        startButton.setOnAction(event -> startMainApplication());

        loginPane.setCenter(startButton);
    }

    private void startMainApplication() {
        StartVindue startVindue = new StartVindue();
        startVindue.init();
        startVindue.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
