package _006Controls.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _03TableViews extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//DESIGN
		VBox vbox = new VBox();

		TableView<Mensch> tv = new TableView<>();
		// Sorgt daf�r, dass sich die View automatisch an das daraufliegende Element hin
		// ver�ndert
		tv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		// Beispiel zur Ver�nderung eines Mensch Objects zur Anzeige der �nderung in der
		// View
		Button button = new Button("Etwas �ndern");

		vbox.getChildren().add(button);

		vbox.getChildren().add(tv);
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
		//DESIGN
		
		
		
		

		// Spalten spezifizieren
		// Autosortierung anhand der Jeweiligen Zeileninhalte vorhanden
		TableColumn<Mensch, String> spalte1 = new TableColumn<>("Name");

		// Dem Inhalt der Zelle eine �berwachte Factory geben (Alle Zellen werden somit
		// �berwacht)
		// �ber Reflection kann die PropertyValueFactory auf Getter und Setter zum
		// zugeh�rigen Attribut [hier: name] aufrufen und somit die Werte holen
//		spalte1.setCellValueFactory(new PropertyValueFactory<>("name"));

		// So nutze ich die �berwachbaren Werte
		 			spalte1.setCellValueFactory(zellWert -> zellWert.getValue().getName());

		TableColumn<Mensch, String> eigenschaften = new TableColumn<>("Eigenschaften");

		TableColumn<Mensch, Number> spalte2 = new TableColumn<>("Alter");

		// Reflection
//		spalte2.setCellValueFactory(new PropertyValueFactory<>("alter"));

		// So nutze ich die �berwachbaren Werte
					spalte2.setCellValueFactory(zellWert -> zellWert.getValue().getAlter());

		TableColumn<Mensch, String> spalte3 = new TableColumn<>("Geschlecht");
		// Reflection
//		spalte3.setCellValueFactory(new PropertyValueFactory<>("geschlecht"));

		// So nutze ich die �berwachbaren Werte
					spalte3.setCellValueFactory(zellWert -> zellWert.getValue().getGeschlecht());

		// Spalten zur View hinzuf�gen
		tv.getColumns().add(spalte1);

		// Setzt die beiden Spalten als Unterspalten zu sich selbst
		eigenschaften.getColumns().add(spalte2);
		eigenschaften.getColumns().add(spalte3);

		// F�gt die Spalte Eigenschaft mit der Untergliederung der beiden Spalten hinzu
		tv.getColumns().add(eigenschaften);

		// Zeilen hinzuf�gen
		Mensch adrian = new Mensch("Adrian", 26, "m�nnlich");
		Mensch dominik = new Mensch("Dominik", 26, "divers");

		tv.getItems().add(adrian);
		tv.getItems().add(dominik);
		// Ausgabe der Auswahl
		button.setOnAction(event -> {
			//Wenn man �ber Properties drauf zugreift
			adrian.getName().set("Bernd");
			adrian.getAlter().set(50);
			System.out.println(adrian.getName().get());
			System.out.println(adrian.getAlter().get());
			
			//Wenn man �ber die WErte direkt drauf zugreift
//			adrian.setName("Bernd");
//			adrian.setAlter(50);
//			System.out.println(adrian.getName());
//			System.out.println(adrian.getAlter());
		});

		

	}

	public static void main(String[] args) {
		launch(args);

	}

}
