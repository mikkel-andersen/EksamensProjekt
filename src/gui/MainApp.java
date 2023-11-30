package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Fad;
import model.Lager;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.geometry.Insets;


import java.awt.*;
import java.awt.TextField;
import java.util.ArrayList;

public class MainApp extends Application {

    private ListView<GUIComponent> fadListView;
    private Controller controller;
    @Override
    public void start(Stage primaryStage) {
        controller = Controller.getController();

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600, 400);

        // Create ListView to display Fads
        fadListView = new ListView<>();
        updateFadListView();

        // Create button to create a new Fad
        Button createFadButton = new Button("Create Fad");
        createFadButton.setOnAction(e -> showCreateFadDialog());

        VBox buttonContainer = new VBox(10);
        buttonContainer.getChildren().addAll(createFadButton);
        buttonContainer.setPadding(new Insets(10, 20, 10, 20));


        root.setLeft(fadListView);
        root.setRight(buttonContainer);

        primaryStage.setTitle("Fad Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showCreateFadDialog() {
        Dialog<Fad> dialog = new Dialog<>();
        dialog.setTitle("Create Fad");
        dialog.setHeaderText("Enter Fad Information");

        // Set the button types
        ButtonType createButtonType = new ButtonType("Create", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);

        // Create fields for Fad information
        javafx.scene.control.TextField oprindelsesLandField = new javafx.scene.control.TextField();
        javafx.scene.control.TextField kapacitetField = new javafx.scene.control.TextField();
        // Add more fields as needed

        GridPane grid = new GridPane();
        grid.add(new Label("Oprindelsesland:"), 0, 0);
        grid.add(oprindelsesLandField, 1, 0);
        grid.add(new Label("Kapacitet:"), 0, 1);
        grid.add(kapacitetField, 1, 1);
        // Add more fields to the grid

        dialog.getDialogPane().setContent(grid);

        // Request focus on the oprindelsesLandField by default
        Platform.runLater(oprindelsesLandField::requestFocus);

        // Convert the result to a Fad when the create button is clicked
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButtonType) {
                try {
                    String oprindelsesLand = oprindelsesLandField.getText();
                    int kapacitet = Integer.parseInt(kapacitetField.getText());
                    // Get other field values as needed

                    // Create the Fad and add it to the controller
                    Fad fad = controller.opretFad(oprindelsesLand, new ArrayList<>(), kapacitet, 1);

                    // Update the ListView
                    updateFadListView();

                    return fad;
                } catch (NumberFormatException e) {
                    // Handle invalid input
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid input. Please enter numeric values for capacity.");

                    alert.showAndWait();
                }
            }
            return null;
        });

        dialog.show();
    }

    private void updateFadListView() {
        // Clear existing items
        fadListView.getItems().clear();

        // Get Fads from the controller
        for (Fad fad : controller.getFadListe()) {
            FadLeaf fadLeaf = new FadLeaf(fad);
            fadListView.getItems().add(fadLeaf);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
