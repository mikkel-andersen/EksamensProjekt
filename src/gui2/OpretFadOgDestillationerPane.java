package gui2;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Destillation;
import model.Fad;
import javafx.scene.layout.HBox;
import model.Lager;

public class OpretFadOgDestillationerPane extends GridPane{
    private OpretPåfyldningDialogPane opretPåfyldningDialogPane;
    private OpretOgVisLagerPane opretOgVisLagerPane;
    private SharedListView<Fad> lstFad = new SharedListView<>();
    private ListView<Destillation> lstDestillation = new ListView<>();
    private Controller controller;
    private Button btnOpretFad = new Button("Opret Fad");
    private Button btnOpretDestillation = new Button("Opret Destillation");
    private Button btnOpretPåfyldning = new Button("Opret Påfyldning");
    private Label lblFad = new Label("Fade");
    private Label lblDestillation = new Label("Destillationer");

    public void updateControls() {
        lstFad.getSelectionModel().clearSelection();
        lstDestillation.getSelectionModel().clearSelection();
    }

    public OpretFadOgDestillationerPane(OpretOgVisLagerPane opretOgVisLagerPane) {
        this.opretOgVisLagerPane = opretOgVisLagerPane;
        controller = Controller.getController();

        this.setGridLinesVisible(false);
        this.setHgap(20);
        this.setVgap(10);

        HBox hBox = new HBox(lblFad);
        hBox.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(lblDestillation);
        hBox2.setAlignment(Pos.CENTER);

        this.add(hBox, 0, 0);
        this.add(lstFad, 0, 1);
        this.add(btnOpretFad, 2, 1);
        this.add(hBox2, 1, 0);
        this.add(lstDestillation, 1, 1);
        this.add(btnOpretDestillation, 3, 1);
        this.add(btnOpretPåfyldning, 4, 1);



        lstFad.setItemsAndBind(controller.getFadListe());
        lstDestillation.getItems().setAll(controller.getDestillationer());

        btnOpretFad.setOnAction(event -> openCreateFadDialog());
        btnOpretDestillation.setOnAction(event -> openCreateDestillationDialog());

        btnOpretPåfyldning.setOnAction(event -> openCreatePåfyldningDialog());
        

    }

    private void openCreateFadDialog() {
        OpretFadDialogPane createFadDialog = new OpretFadDialogPane(controller);

        createFadDialog.showAndWait().ifPresent(createdFad -> {
            // Handle the created Fad (e.g., add it to the list)
            if (createdFad != null) {
                controller.getStorage().addFad(createdFad);

                opretOgVisLagerPane.updateFadList();
                // Update the ListView or any other UI components
                lstFad.setItemsAndBind(controller.getFadListe());
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

    private void openCreatePåfyldningDialog() {
        OpretPåfyldningDialogPane createPåfyldningDialog = new OpretPåfyldningDialogPane(controller);
        createPåfyldningDialog.showAndWait().ifPresent(createdPåfyldning -> {
            // Obtain the relevant Fad object from the dialog
            Fad selectedFad = createPåfyldningDialog.selectedFad();
            Lager selectedLager = createPåfyldningDialog.selectedLager();

            // Add påfyldning to the relevant Fad
            if (createdPåfyldning != null && selectedFad != null) {
                controller.opretPåfyldning(createdPåfyldning.getPaafyldningsDato(), selectedFad, selectedLager, createdPåfyldning.getMængder());
            }
        });
    }
}