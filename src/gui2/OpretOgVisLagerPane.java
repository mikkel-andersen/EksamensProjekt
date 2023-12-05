package gui2;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
import model.Fad;
import model.Lager;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class OpretOgVisLagerPane extends GridPane  {

    private ListView<Lager> lstLager = new ListView<>();
    private SharedListView<Fad> lstFad = new SharedListView<>();
    private Controller controller;
    private Button btnOpretLager = new Button("Opret Lager");


    public void updateControls() {
        lstLager.getSelectionModel().clearSelection();
        lstFad.getItems().setAll(controller.getFadListe());
    }

    public OpretOgVisLagerPane() {
        controller = Controller.getController();
        this.setGridLinesVisible(false);
        this.setHgap(20);
        this.setVgap(10);
        this.add(lstLager, 0, 0);
        this.add(lstFad, 1, 0);
        this.add(btnOpretLager, 4, 0);

        lstLager.getItems().setAll(controller.getLager());
        lstFad.setItemsAndBind((controller.getFadListe()));

        btnOpretLager.setOnAction(event -> openCreateLagerDialog());

    }

    public void openCreateLagerDialog() {
        OpretLagerDialogPane createLagerDialog = new OpretLagerDialogPane(controller);
        createLagerDialog.showAndWait().ifPresent(createdLager -> {
            if (createdLager != null) {
                controller.getStorage().addLager(createdLager);
                lstLager.getItems().setAll(controller.getLager());
                updateControls();
            }
        });
    }
}