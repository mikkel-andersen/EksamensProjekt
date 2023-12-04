package gui2;

import controller.Controller;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Fad;

import java.util.ArrayList;

public class OpretFadDialogPane extends Dialog<Fad> {

    private TextField oprindelsesLandField = new TextField();
    private TextField destillationerField = new TextField();
    private TextField fadTypeField = new TextField();
    private TextField kapacitetField = new TextField();

    private Controller controller;

    public OpretFadDialogPane(Controller controller) {
        this.setTitle("Create Fad");
        this.setHeaderText("Enter Fad Information");

        // Set the button types (OK and Cancel)
        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        // Create a GridPane for the layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Add labels and input fields to the GridPane
        grid.add(new Label("OprindelsesLand:"), 0, 0);
        grid.add(new Label("Destillationer:"), 0, 1);
        grid.add(new Label("FadType:"), 0, 2);
        grid.add(new Label("Kapacitet:"), 0, 3);
        grid.add(oprindelsesLandField, 1, 0);
        grid.add(destillationerField, 1, 1);
        grid.add(fadTypeField, 1, 2);
        grid.add(kapacitetField, 1, 3);

        // Add more labels and fields as needed

        // Set the GridPane as the content of the dialog
        this.getDialogPane().setContent(grid);

        // Convert the result to a Fad when the OK button is clicked
        this.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                // Validate input and create a new Fad
                String fadType = fadTypeField.getText();
                int kapacitet = Integer.parseInt(kapacitetField.getText());

                // Validate input and create a new Fad
                Fad createdFad = controller.opretFad(oprindelsesLandField.getText(), new ArrayList<>(), fadType, kapacitet);

                return createdFad;
            }
            return null;
        });
    }
}
