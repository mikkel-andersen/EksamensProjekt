package gui2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;

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
        stage.setHeight(600);
        stage.setWidth(600);
        stage.show();
    }

    private void initLoginContent() {

        Image image = new Image("gui2/SallLogo.png");

        ImageView imageView = new ImageView(image);

        imageView.fitWidthProperty();
        imageView.fitHeightProperty();

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(imageView, createStartButton());

        loginPane.setCenter(vBox);
    }
    private Button createStartButton(){
        Button startButton = new Button("Start");
        startButton.setMinSize(100, 70);
        startButton.setOnAction(event -> startMainApplication());

        return startButton;
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
