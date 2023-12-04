package gui2;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Destillation;
import model.Fad;

    public class OpretFadOgDestillationerPane extends GridPane {

    private ListView<Fad> lstFad = new ListView<>();
    private ListView<Destillation> lstDestillation = new ListView<>();
    private Controller controller;
    private Button btnOpretFad = new Button("Opret Fad");
    private Button btnOpretDestillation = new Button("Opret Destillation");

    public void updateControls() {
        lstFad.getSelectionModel().clearSelection();
        lstDestillation.getSelectionModel().clearSelection();

    }

    public OpretFadOgDestillationerPane() {
        controller = Controller.getController();
        this.setGridLinesVisible(false);
        this.setHgap(20);
        this.setVgap(10);
        this.add(lstFad, 0, 0);
        this.add(lstDestillation, 1, 0);
        this.add(btnOpretFad, 4, 0);
        this.add(btnOpretDestillation, 5, 0);
        lstFad.getItems().setAll(controller.getFadListe());
        lstDestillation.getItems().setAll(controller.getDestillationer());

        btnOpretFad.setOnAction(event -> openCreateFadDialog());
        btnOpretDestillation.setOnAction(event -> openCreateDestillationDialog());

    }


        private void openCreateFadDialog() {
            OpretFadDialogPane createFadDialog = new OpretFadDialogPane(controller);
            createFadDialog.showAndWait().ifPresent(createdFad -> {
                // Handle the created Fad (e.g., add it to the list)
                if (createdFad != null) {
                    controller.getStorage().addFad(createdFad);
                    // Update the ListView or any other UI components
                    lstFad.getItems().setAll(controller.getFadListe());
                }
            });
        }

        private void openCreateDestillationDialog() {
            OpretDestillationDialogPane createDestillationDialog = new OpretDestillationDialogPane(controller);
            createDestillationDialog.showAndWait().ifPresent(createdDestillation -> {
                // Handle the created Fad (e.g., add it to the list)
                if (createdDestillation != null) {
                    controller.getStorage().addDestillation(createdDestillation);
                    // Update the ListView or any other UI components
                    lstDestillation.getItems().setAll(controller.getDestillationer());
                }
            });
        }



}