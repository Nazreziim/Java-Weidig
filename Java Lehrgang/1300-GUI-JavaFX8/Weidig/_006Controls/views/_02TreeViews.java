package _006Controls.views;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _02TreeViews extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// DESIGN
		VBox vbox = new VBox();

		// Mit TreeView arbeiten
		Button button = new Button("Liste auslesen");

		// TreeView erzeugen
		TreeView<String> treeView = new TreeView<>();

		vbox.getChildren().addAll(button, treeView);
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
		// DESIGN

		// Ein Punkt in der TreeView = TreeItem
		TreeItem<String> �berpunkt = new TreeItem<>("Fortbewegungsmittel");

		// TreeItems die zu TreeItems als Children hinzugef�gt werden sind Unterpunkte
		TreeItem<String> autos = new TreeItem<>("Autos");
		autos.getChildren().add(new TreeItem<String>("Mercedes"));
		autos.getChildren().add(new TreeItem<String>("Audi"));
		�berpunkt.getChildren().add(autos);

		TreeItem<String> fahrr�der = new TreeItem<>("Fahrr�der");
		fahrr�der.getChildren().add(new TreeItem<String>("Fahrrad"));
		fahrr�der.getChildren().add(new TreeItem<String>("E-Bike"));
		�berpunkt.getChildren().add(fahrr�der);

		// Der TreeView das Wurzelitem geben das als Standard gesetzt werden soll
		treeView.setRoot(�berpunkt);

		// Versteckt den �berpunkt / das Wurzelitem
		treeView.setShowRoot(false);

		// Standardm��ig ist nur ein Item ausw�hlbar
		treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// Werte ver�nderbar machen
		treeView.setEditable(true);

		// Hiermit setze ich die Zellen meiner TreeView auf TextField Zellen welche
		// ver�nderbar sind wenn .setEditable auf true gesetzt ist
		treeView.setCellFactory(TextFieldTreeCell.forTreeView());

		// Ausgabe der Auswahl
		button.setOnAction(event -> {
			ObservableList<TreeItem<String>> treeItems = treeView.getSelectionModel().getSelectedItems();

			for (TreeItem<String> item : treeItems) {
				System.out.println(item.getValue());
			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}

}
