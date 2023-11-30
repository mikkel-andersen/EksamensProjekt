package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Fad;
import model.Lager;

import java.util.ArrayList;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Whisky GUI");

        GUIComponent fadLeaf = new FadLeaf(new Fad("Scotland", new ArrayList<>(), 200, 1));
        GUIComponent lagerLeaf = new LagerLeaf(new Lager(1, 500, "Sall Lager"));

        CompositeComponent compositeComponent = new CompositeComponent();
        compositeComponent.addComponent(fadLeaf);
        compositeComponent.addComponent(lagerLeaf);

        compositeComponent.displayInfo();


        VBox root = new VBox(new Label("Whisky GUI"));
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
