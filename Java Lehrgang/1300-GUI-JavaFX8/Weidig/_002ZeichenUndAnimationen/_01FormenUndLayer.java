package _002ZeichenUndAnimationen;

import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class _01FormenUndLayer extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// StackPane da wie gezeigt sich dort die Panes definitiv überlagern zum Zeigen von Layern / Ebenen
		Pane layer1 = new Pane();
		// Mit .setUserData kann ich an mein Node ein Object (auch String) anhängen
		layer1.setUserData("Layer1");
		Pane layer2 = new Pane();
		layer2.setUserData("Layer2");

		// ------ Linie erzeugt ------
		System.out.println("------ Linie erzeugt ------");
		// Erzeugt eine Linie gem. Bild
		Line l = new Line(250, 250, 100, 100);

		// Färbt die Linie ein. Bei anderen Formen den Linienrand
		l.setStroke(Color.RED);

		// Fügt dem Pane die Nodes hinzu
		layer1.getChildren().add(l);

		// ------ Andere Formen ------
		System.out.println("------ Rechteck ------");

		// Erzeugt Rechteck gem. Bild
		Rectangle rec = new Rectangle(180, 180, 100, 50);

		// Füllung des Rechtecks
		rec.setFill(Color.BLUE);

		// Randfarbe
		rec.setStroke(Color.GREEN);

		// Randdicke
		rec.setStrokeWidth(10);

		// Fügt dem Pane die Nodes hinzu
		layer2.getChildren().add(rec);

		// Möglichkeit Nodes zu einer Group zusammenzufassen
		// Legt als unterste Ebene layer1(Strich) fest und darüber layer2(Viereck)
		Group group = new Group(layer1, layer2);

		// Möglichkeit die komplette Group hinzuzufügen oder die Nodes einzeln
		StackPane stackPane = new StackPane(group);

		/*
		 * JETZT WIRDS ABGEFAHREN: 
		 * 1. Wir holen uns das Child des StackPane über .getChildren.get(0) 
		 * --> Dieses ist eine Group [Wissen wir] 
		 * 2. Dann casten wir dieses zu Group (Funktioniert, da wir wissen, dass es ein Group Object ist)
		 * 3. Holen uns von der Group auch wieder die Children mit .getChildren 
		 * 4. Holen uns die Panes an Stelle .get(0) und .get(1) 
		 * 5. Holen uns die UserData der Panes
		 */
		System.out.println(
				"Layerreihenfolge: " + ((Group) stackPane.getChildren().get(0)).getChildren().get(0).getUserData() + "/"
						+ ((Group) stackPane.getChildren().get(0)).getChildren().get(1).getUserData());
		Scene scene = new Scene(stackPane);

		primaryStage.setScene(scene);
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.show();

		// Programm 2 Mal starten und einmal 1 auswählen und danach mit 2 und
		// abgleichen, dass wie die Layer übereinander liegen
		System.out.println("Welcher Layer soll oben sein? (1) / (2)");
		Scanner sc = new Scanner(System.in);

		int eingabe = sc.nextInt();

		if (eingabe == 1) {
			layer1.toFront();
			System.out.println(
					"Layerreihenfolge: " + ((Group) stackPane.getChildren().get(0)).getChildren().get(0).getUserData()
							+ "/" + ((Group) stackPane.getChildren().get(0)).getChildren().get(1).getUserData());
		} else if (eingabe == 2) {
			layer2.toFront();
			System.out.println(
					"Layerreihenfolge: " + ((Group) stackPane.getChildren().get(0)).getChildren().get(0).getUserData()
							+ "/" + ((Group) stackPane.getChildren().get(0)).getChildren().get(1).getUserData());
		}

		sc.close();

	}

}
