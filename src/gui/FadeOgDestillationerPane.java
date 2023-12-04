package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import model.Destillation;
import model.Fad;
import model.Lager;

public class FadeOgDestillationerPane extends GridPane {

	private ListView<Fad> lstFad = new ListView<>();
	private ListView<Destillation> lstDestillation = new ListView<>();
	private ListView<Lager> lstLager = new ListView<>();
	private  Button btnOpretLager = new Button("Opret Lager");
	private Button btnOpretFad = new Button("Opret Fad");
	private Button btnOpretDestillation = new Button("Opret destillation");
	private Label lblError;

	private Controller controller;

	public FadeOgDestillationerPane() {

		controller = Controller.getController();

		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		lblError = new Label();
		lblError.setTextFill(Color.RED);


		this.add(new Label("Vælg fad"), 0, 0);
		this.add(lstFad, 0, 1, 1, 2);
		lstFad.getItems().setAll(controller.getFadListe());

		this.add(new Label("Vælg destillation"), 1, 0);
		this.add(lstDestillation, 1, 1, 1, 2);
		lstDestillation.getItems().setAll(controller.getDestillationer());
		lstLager.getItems().setAll(controller.getLager());

		this.add(new Label("Vælg lager"), 2, 0);
		GridPane innerPane = new GridPane();
		innerPane.setVgap(10);
		innerPane.add(lstLager, 0, 0);

		this.add(innerPane, 2, 1);

		this.add(lblError, 0, 3, 1, 2);
		this.add(btnOpretLager, 2, 1);
		this.add(btnOpretDestillation,2,3);
		this.add(btnOpretFad, 2, 2);
		btnOpretFad.setOnAction(event -> actionOpret());

		RowConstraints row1 = new RowConstraints();
		RowConstraints row2 = new RowConstraints();
		RowConstraints row3 = new RowConstraints();
		row3.setValignment(VPos.BOTTOM);
		getRowConstraints().addAll(row1, row2, row3);
	}

	public void actionOpret() {
		lblError.setText("");
		if (lstFad.getSelectionModel().getSelectedItem() == null) {
			lblError.setText("Du skal vælge en patient.");
		} else if (lstDestillation.getSelectionModel().getSelectedItem() == null) {
			lblError.setText("Du skal vælge et lægemiddel.");
		} else if (toggleGroup.getSelectedToggle() == null) {
			lblError.setText("Du skal vælge en ordinationstype.");
		} else {
			OpretFadDialog dia = new OpretFadDialog(lstFad
					.getSelectionModel().getSelectedItem(), lstDestillation
					.getSelectionModel().getSelectedItem(),
					(TypeOrdination) toggleGroup.getSelectedToggle()
					.getUserData());
			dia.showAndWait();
		}
	}
	
	public void updateControls() {
		lstFad.getSelectionModel().clearSelection();
		lstDestillation.getSelectionModel().clearSelection();
		//toggleGroup.selectToggle(null);
	}
}
