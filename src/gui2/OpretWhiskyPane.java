package gui2;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Whisky;

import javafx.scene.control.ListView;

import javax.swing.plaf.basic.BasicButtonUI;
import java.net.http.WebSocket;
import java.util.List;

public class OpretWhiskyPane extends GridPane {

    private ListView <Whisky> lstWhisky = new ListView<>();
    private Button btnOpretWhisky = new Button("Opret Whisky");
    private Controller controller;
    private TextArea txtWhisky = new TextArea();
    private Label lblWhisky = new Label("Whisky");
    private Label lblWhiskyInfo = new Label("Whisky Info");

    public OpretWhiskyPane() {
        controller = Controller.getController();
        this.setGridLinesVisible(false);
        this.setHgap(20);
        this.setVgap(10);

        HBox hBox = new HBox(lblWhisky);
        hBox.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(lblWhiskyInfo);
        hBox2.setAlignment(Pos.CENTER);

        this.add(hBox, 0, 0);
        this.add(lstWhisky, 0, 1);
        this.add(hBox2, 1, 0);
        this.add(txtWhisky, 1, 1);
        this.add(btnOpretWhisky, 4, 1);

        txtWhisky.setEditable(false);



        lstWhisky.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtWhisky.setText(newValue.whiskyLabel());
            }
        });

        lstWhisky.getItems().setAll(controller.getWhisky());
        btnOpretWhisky.setOnAction(event -> openCreateWhiskyDialog());
    }

    public void openCreateWhiskyDialog() {
        OpretWhiskyDialogPane createWhiskyDialog = new OpretWhiskyDialogPane(controller);
        createWhiskyDialog.showAndWait();
        lstWhisky.getItems().setAll(controller.getWhisky());


    }

}
