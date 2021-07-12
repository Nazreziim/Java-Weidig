package _006Controls.views;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;

public class _04TreeTableView extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//DESIGN
		VBox vbox = new VBox();
		TreeTableView<Mensch> ttV = new TreeTableView<>();
		// Sorgt dafür, dass sich die View automatisch an das daraufliegende Element hin
		// verändert
		ttV.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);

		// Mehfachauswahl und Werte veränderbar machen
		ttV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ttV.setEditable(true);
		
		// INTERAKTIONSMÖGLICHKEIT
		Button button = new Button("Etwas ändern");
		Button button2 = new Button("Auswahl ausgeben");

		vbox.getChildren().addAll(ttV, button, button2);
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
		//DESIGN
		
		
		
		

		// Menschen erzeugen
		Mensch adrian = new Mensch("Adrian", 26, "männlich");
		Mensch dominik = new Mensch("Dominik", 26, "divers");

		// Spalten festlegen
		TreeTableColumn<Mensch, String> spalte1 = new TreeTableColumn<>("Name");
		spalte1.setPrefWidth(100);
		// spalte1.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
		spalte1.setCellValueFactory(zellItem -> zellItem.getValue().getValue().getName());
		spalte1.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());

		TreeTableColumn<Mensch, Number> spalte2 = new TreeTableColumn<>("Alter");
		spalte2.setPrefWidth(100);
		// spalte2.setCellValueFactory(new TreeItemPropertyValueFactory<>("alter"));
		spalte2.setCellValueFactory(zellItem -> zellItem.getValue().getValue().getAlter());

		// ACHTUNG ACHTUNG: Um andere Werte außer Strings editierbar zu machen muss man
		// den XXXStringConverter zusätzlich mit hinzufügen
		spalte2.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn(new NumberStringConverter()));

		TreeTableColumn<Mensch, String> spalte3 = new TreeTableColumn<>("Geschlecht");
		spalte3.setPrefWidth(100);
		// spalte3.setCellValueFactory(new
		// TreeItemPropertyValueFactory<>("geschlecht"));
		spalte3.setCellValueFactory(zellItem -> zellItem.getValue().getValue().getGeschlecht());
		spalte3.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());

		ttV.getColumns().addAll(spalte1, spalte2, spalte3);

		TreeItem<Mensch> zeile1 = new TreeItem<>(adrian);
		TreeItem<Mensch> zeile2 = new TreeItem<>(dominik);
		
		
		//Überelement
		TreeItem<Mensch> ueberschrift1 = new TreeItem<>(new Mensch("Menschen"));
		ueberschrift1.getChildren().add(zeile1);
		ueberschrift1.getChildren().add(zeile2);

		//Wurzelelement der TreeTableView festlegen
		ttV.setRoot(ueberschrift1);

		
		
		// Ausgabe der Auswahl
		button.setOnAction(event -> {
			// Wenn man über Properties drauf zugreift
			adrian.getName().set("Bernd");
			adrian.getAlter().set(50);
			System.out.println(adrian.getName().get());
			System.out.println(adrian.getAlter().get());
			System.out.println(adrian.getGeschlecht().get());

			// Wenn man über die WErte direkt drauf zugreift
//			adrian.setName("Bernd");
//			adrian.setAlter(50);
//			System.out.println(adrian.getName());
//			System.out.println(adrian.getAlter());
		});
		
		button2.setOnAction(event -> {
			ObservableList<TreeItem<Mensch>> zeile = ttV.getSelectionModel().getSelectedItems();

			for (TreeItem<Mensch> einMensch : zeile) {
				if (einMensch.getValue().getName() != null)
					System.out.println(einMensch.getValue().getName().get());

				if (einMensch.getValue().getAlter() != null)
					System.out.println(einMensch.getValue().getAlter().get());

				if (einMensch.getValue().getGeschlecht() != null)
					System.out.println(einMensch.getValue().getGeschlecht().get());

			}
		});

		
	}

}
