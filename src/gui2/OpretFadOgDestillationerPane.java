package gui2;

import controller.Controller;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Fad;

public class OpretFadOgDestillationerPane extends GridPane {

    private ListView<Fad> lstFad = new ListView<>();
    private ListView<Fad> lstDestillation = new ListView<>();
    private Controller controller;

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
        lstFad.getItems().setAll(controller.getFadListe());
        lstDestillation.getItems().setAll(controller.getFadListe());
    }





}