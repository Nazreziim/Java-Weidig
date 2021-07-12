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
		TreeItem<String> überpunkt = new TreeItem<>("Fortbewegungsmittel");

		// TreeItems die zu TreeItems als Children hinzugefügt werden sind Unterpunkte
		TreeItem<String> autos = new TreeItem<>("Autos");
		autos.getChildren().add(new TreeItem<String>("Mercedes"));
		autos.getChildren().add(new TreeItem<String>("Audi"));
		überpunkt.getChildren().add(autos);

		TreeItem<String> fahrräder = new TreeItem<>("Fahrräder");
		fahrräder.getChildren().add(new TreeItem<String>("Fahrrad"));
		fahrräder.getChildren().add(new TreeItem<String>("E-Bike"));
		überpunkt.getChildren().add(fahrräder);

		// Der TreeView das Wurzelitem geben das als Standard gesetzt werden soll
		treeView.setRoot(überpunkt);

		// Versteckt den Überpunkt / das Wurzelitem
		treeView.setShowRoot(false);

		// Standardmäßig ist nur ein Item auswählbar
		treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// Werte veränderbar machen
		treeView.setEditable(true);

		// Hiermit setze ich die Zellen meiner TreeView auf TextField Zellen welche
		// veränderbar sind wenn .setEditable auf true gesetzt ist
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
