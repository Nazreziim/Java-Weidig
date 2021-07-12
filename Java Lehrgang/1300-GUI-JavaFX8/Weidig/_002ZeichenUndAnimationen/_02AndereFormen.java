package _002ZeichenUndAnimationen;

import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

public class _02AndereFormen extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Hauptanzeigefläche anzeigen
		Pane mainPane = new Pane();
		mainPane.setMinSize(500, 500);
		

		// Auswahl des zu zeichnenden Shapes
		System.out.print("Welchen Shape möchtest du zeichnen?:\n");
		System.err.println("Kreis");
		System.err.println("Ellipse");
		System.err.println("Polygon");
		System.err.println("Polyline");
		System.err.println("QuadCurve");
		System.err.println("CubicCurve");
		System.err.println("Arc");

		Scanner sc = new Scanner(System.in);
		String auswahl = sc.next();

		//Bei allen Shapes gibt es Methoden die für das weitere Aussehen zuständig sind
		switch (auswahl) {
		case "Kreis":
			this.kreis(mainPane);
			break;
		case "Ellipse":
			this.ellipse(mainPane);
			break;
		case "Polygon":
			this.polygon(mainPane);
			break;
		case "Polyline":
			this.polyline(mainPane);
			break;
		case "QuadCurve":
			this.quadCurve(mainPane);
			break;
		case "CubicCurve":
			this.cubicCurve(mainPane);
			break;
		case "Arc":
			this.arc(mainPane);
			break;
		}
		
		Scene mainScene = new Scene(mainPane);
		primaryStage.setScene(mainScene);
		primaryStage.show();
		sc.close();

	}

	

	private void kreis(Pane mainPane) {
		//gem. Konstruktor
		Circle kreis = new Circle(250, 250, 10, Color.RED);
		mainPane.getChildren().add(kreis);

	}

	private void ellipse(Pane mainPane) {
		//gem. Konstruktor
		Ellipse ellipse = new Ellipse(250, 250, 10, 20);
		mainPane.getChildren().add(ellipse);

	}

	private void polygon(Pane mainPane) {
		/* 4 Punkte:
		 * 1. 250 250 Startpunkt
		 * 2. 50 nach Rechts [300 250]
		 * 3. 50 nach Unten [300 300]
		 * 4. 50 nach Links [250 300]
		 * --> Verbindet die Punkte, sowie den letzten Punkt mit 
		 *     dem Startpunkt und füllt das innere aus
		 *         [Default Fill = schwarz]
		 */
		double[] xUndyKoordinaten = { 
				250.0, 250.0, 
				300.0, 250.0, 
				300.0, 300.0, 
				250.0, 300.0 };

		Polygon polygon = new Polygon(xUndyKoordinaten);
		
		//Ändert die PolygonFüllung
		polygon.setFill(Color.RED);
		
		mainPane.getChildren().add(polygon);
		

	}
	
	private void polyline(Pane mainPane) {
		/* 4 Punkte:
		 * 1. 250 250 Startpunkt
		 * 2. 50 nach Rechts [300 250]
		 * 3. 50 nach Unten [300 300]
		 * 4. 50 nach Links [250 300]
		 * --> Verbindet die Punkte sonst nichts
		 */
		double[] xUndyKoordinaten = { 
				250.0, 250.0, 
				300.0, 250.0, 
				300.0, 300.0, 
				250.0, 300.0 };
		
		Polyline polyline = new Polyline(xUndyKoordinaten);
		mainPane.getChildren().add(polyline);
		
	}

	private void quadCurve(Pane mainPane) {
		QuadCurve quadcurve = new QuadCurve(10.0f, 10.0f, 120.0f, 240.0f, 160.0f, 70.0f);
		//Setzt die Ausfüllfläche transparent
		quadcurve.setFill(Color.TRANSPARENT);
		
		//Erzeugt die Linie in Stärke 1
		quadcurve.setStrokeWidth(1);
		
		//Setzt die Linienfarbe auf schwarz
		quadcurve.setStroke(Color.BLACK);
		mainPane.getChildren().add(quadcurve);
	}

	private void cubicCurve(Pane mainPane) {
		CubicCurve cubiccurve = new CubicCurve(10.0f, 10.0f, 120.0f, 240.0f, 160.0f, 70.0f, 50, 50);
		// Setzt die Ausfüllfläche transparent
		cubiccurve.setFill(Color.TRANSPARENT);

		// Erzeugt die Linie in Stärke 1
		cubiccurve.setStrokeWidth(1);

		// Setzt die Linienfarbe auf schwarz
		cubiccurve.setStroke(Color.BLACK);
		mainPane.getChildren().add(cubiccurve);
	}

	private void arc(Pane mainPane) {
		Arc arc = new Arc(250, 250, 100, 100, 90, 100);
		arc.setType(ArcType.CHORD);
		arc.setType(ArcType.OPEN);
		arc.setType(ArcType.ROUND);

		mainPane.getChildren().add(arc);
	}

}
