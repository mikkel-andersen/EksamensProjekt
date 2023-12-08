package gui2;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Fad;
import model.Lager;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;


public class OpretOgVisLagerPane extends GridPane{
    private OpretFadOgDestillationerPane opretFadOgDestillationerPane;
    private ListView<Lager> lstLager = new ListView<>();
    private SharedListView<Fad> lstFad = new SharedListView<>();
    private Controller controller;
    private Button btnOpretLager = new Button("Opret Lager");
    private Label lblLager = new Label("Lager");
    private Label lblFad = new Label("Fade");
    private Label lblAntalÅr = new Label("Liggetid");
    private TextField txtAntalÅr = new TextField();


    public void updateControls() {
        lstLager.getSelectionModel().clearSelection();
    }

    public OpretOgVisLagerPane() {
        controller = Controller.getController();
        this.setGridLinesVisible(false);
        this.setHgap(20);
        this.setVgap(10);

        HBox hBox = new HBox(lblLager);
        hBox.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(lblFad);
        hBox2.setAlignment(Pos.CENTER);


        this.add(hBox, 0, 0);
        this.add(lstLager, 0, 1);
        this.add(hBox2, 1, 0);
        this.add(lstFad, 1, 1);
        this.add(btnOpretLager, 4, 1);
        this.add(lblAntalÅr, 2, 1);
        this.add(txtAntalÅr, 3, 1);


        lstLager.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                lstFad.setItemsAndBind(newValue.getFadliste());

            }
        });
        lstFad.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtAntalÅr.setText(String.valueOf(newValue.getAntalDage() + " Dage"));
            }
        });
//        lstLager.getItems().setAll(controller.getLager());
//        lstFad.setItemsAndBind(controller.getFadListe());

        btnOpretLager.setOnAction(event -> openCreateLagerDialog());

    }

    public void openCreateLagerDialog() {
        OpretLagerDialogPane createLagerDialog = new OpretLagerDialogPane(controller);
        createLagerDialog.showAndWait().ifPresent(createdLager -> {
            if (createdLager != null) {
                controller.getStorage().addLager(createdLager);
                lstLager.getItems().setAll(controller.getLager());
            }
        });
    }

    public void updateFadList() {
        lstFad.setItemsAndBind(controller.getFadListe());
    }
}