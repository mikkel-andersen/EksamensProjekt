package gui2;

import controller.Controller;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.Fad;

import java.util.ArrayList;
import java.util.List;

public class OpretFadDialogPane extends Dialog<Fad> {

    private TextField oprindelsesLandField = new TextField();
    private ComboBox fadTypeField = new ComboBox();
    private TextField kapacitetField = new TextField();
    private Controller controller;

    //Update lstFad listView in OpretOgVisLagerPane when a new Fad is created



    public void updateControls() {
        oprindelsesLandField.clear();
        fadTypeField.getSelectionModel().clearSelection();
        kapacitetField.clear();
    }



    public OpretFadDialogPane(Controller controller) {
        this.setTitle("Create Fad");
        this.setHeaderText("Enter Fad Information");

        // Set the button types (OK and Cancel)
        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        // Create a GridPane for the layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        //ComboBox
        fadTypeField.getItems().addAll(
                "Sherry",
                "Bourbon",
                "Rødvin"
        );


        // Add labels and input fields to the GridPane
        grid.add(new Label("OprindelsesLand:"), 0, 0);
        grid.add(new Label("FadType:"), 0, 1);
        grid.add(new Label("Kapacitet:"), 0, 2);
        grid.add(oprindelsesLandField, 1, 0);
        grid.add(fadTypeField, 1, 1);
        grid.add(kapacitetField, 1, 2);

        // Add more labels and fields as needed

        // Set the GridPane as the content of the dialog
        this.getDialogPane().setContent(grid);

        // Convert the result to a Fad when the OK button is clicked
        this.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                // Validate input and create a new Fad
                String fadType = fadTypeField.getValue().toString();
                int kapacitet = Integer.parseInt(kapacitetField.getText());

                // Validate input and create a new Fad
                Fad createdFad = controller.opretFad(oprindelsesLandField.getText(), fadType, kapacitet);
                return createdFad;
            }
            return null;
        });


    }
}