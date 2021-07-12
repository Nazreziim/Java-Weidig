package _006Controls.views;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _01ListViews extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// DESIGN
		VBox vbox = new VBox();

		// ListView erzeugen
		ListView<String> listView = new ListView<>();

		Button button = new Button("Liste auslesen");
		Button button2 = new Button("Hinzuf�gen");
		vbox.getChildren().addAll(listView, button, button2);

		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();

		// DESIGN
		
		
		
		
		

		// Hinzuf�gen einer �berwachbaren Liste welche bearbeitet werden kann und bei
		// �nderung dies mit in die ListView �bernommen wird
		ArrayList<String> arrLi = new ArrayList<>();
		ObservableList<String> obLi = FXCollections.observableArrayList(arrLi);
		
		//Listener als M�glichkeit hinzuf�gen
		obLi.addListener(new ListChangeListener<String>() {

			@Override
			public void onChanged(Change<? extends String> c) {
				System.out.println("Ein Element wurde in der Liste ge�ndert");
				
				//Aktualisiert die komplette ListView
				listView.setItems(obLi);

			}
		});

		listView.setItems(obLi);

		// Einzelnes Hinzuf�gen
		// Ruft die onChanged in Zeile 46 auf
		listView.getItems().add("a");
		listView.getItems().add("b");
		listView.getItems().add("c");
		listView.getItems().add("d");
		listView.getItems().add("e");

		// Standardm��ig ist nur ein Item ausw�hlbar
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// Werte ver�nderbar machen
		listView.setEditable(true);

		// Hiermit setze ich die Zellen meiner ListView auf TextField Zellen welche
		// ver�nderbar sind wenn .setEditable auf true gesetzt ist
		listView.setCellFactory(TextFieldListCell.forListView());
		
		// Zellen erhalten anhand einer Liste zus�tzliche Auswahlmen�s
//		listView.setCellFactory(ComboBoxListCell.forListView(obLi));
//		listView.setCellFactory(ChoiceBoxListCell.forListView(obLi));

		button.setOnAction(event -> {
			ObservableList<String> ausgew�hlteInhalte = listView.getSelectionModel().getSelectedItems();

			for (String wert : ausgew�hlteInhalte) {
				System.out.println("Wert = " + wert);
			}
		});

		button2.setOnAction(event -> {
			
			// Dadurch, dass die ListView an die ObservableList gekettet ist wird diese
			// �nderung in der ListView auch direkt angezeigt
			System.out.println("Bernd wird hinzugef�gt.");
			obLi.add("Bernd");
		});

	}

	public static void main(String[] args) {
		launch(args);

	}

}
