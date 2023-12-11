package gui2;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.Whisky;

import javafx.scene.control.ListView;

import javax.swing.plaf.basic.BasicButtonUI;
import java.net.http.WebSocket;
import java.util.List;

public class OpretWhiskyPane extends GridPane {

    private ListView <Whisky> lstWhisky = new ListView<>();
    private Button btnOpretWhisky = new Button("Opret Whisky");
    private Controller controller;

    public OpretWhiskyPane() {
        controller = Controller.getController();
        this.setGridLinesVisible(false);
        this.setHgap(20);
        this.setVgap(10);

        this.add(lstWhisky, 0, 0);
        this.add(btnOpretWhisky, 1, 0);

        btnOpretWhisky.setOnAction(event -> openCreateWhiskyDialog());
    }

    public void openCreateWhiskyDialog() {
        OpretWhiskyDialogPane createWhiskyDialog = new OpretWhiskyDialogPane(controller);
        createWhiskyDialog.showAndWait();
        lstWhisky.getItems().setAll(controller.getWhisky());
    }

}
