package _002ZeichenUndAnimationen;

import java.util.Scanner;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class _03EinfacheAnimationen extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Hauptoberfläche
		Pane mainPane = new Pane();
		
		//Zusätzliche Größenparameter für die Scene
		Scene mainScene = new Scene(mainPane, 500, 500);
		
		//Unser Objekt, welches wir animieren wollen und Hinzufügen dessen zum Pane
		Circle kreis = new Circle(25, Color.RED);
		mainPane.getChildren().add(kreis);
		
		//Positionieren des Kreises
		kreis.setCenterX(10);
		kreis.setCenterY(50);
		
		primaryStage.setScene(mainScene);
		primaryStage.show();

		/* -------------------------------- */
		/* ------ Timeline Animation ------ */
		/* -------------------------------- */
		Timeline timeline = new Timeline();
		
		//Wie oft soll der komplette Animationszyklus durchgeführt werden?
		//Änderung bewirkt wie oft der Zyklus passiert
		timeline.setCycleCount(2);
		//Sagt ob die Animation nach Beendigung rückwärts ausgeführt werden soll.
		timeline.setAutoReverse(true);
		
		//Welcher Wert soll verändert werden [Hier: Die x-Aches des Kreismittelpunktes]?
		//Wo soll der Wert aufhören? [Hier: Wenn die x-Koordinate des Kreismittelpunktes 300 erreicht hat]
		KeyValue kv = new KeyValue(kreis.centerXProperty(), 300);
		
		//Wie lange soll er für die Animation brauchen? [Hier: 500ms] << Ändern zum Geschwindigkeitswechsel
		//Welcher Werte sollen geändert werden [Aufruf der KeyValue-Angaben]
		//Es sind mehrere KeyValues für ein KeyFrame möglich
		KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
		
		//Hinzufügen des KeyFrames zur Timeline
		//Mit .addAll auch mehrere KeyFrames möglich
		timeline.getKeyFrames().add(kf);
		
		/* -------------------------------- */
		/* ------ Fading Transition  ------ */
		/* -------------------------------- */
		FadeTransition ft = new FadeTransition(Duration.millis(500), kreis);
		//Value = Transparenz
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount( 2 );
	    ft.setAutoReverse( true );
	    
	    /* -------------------------------- */
		/* ------ Path Transition    ------ */
		/* -------------------------------- */
	    
	    //Wir erzeugen einen Pfad
	    Path path = new Path();
	    //ACHTUNG: MoveTo = Ausgangspunkt [Muss immer einmal festgelegt werden]
	    path.getElements().add(new MoveTo(50, 50));
	    
	    //Legt den Pfad anhand verschiedener ...To Methoden fest
	    //Die implizit eine Linie entlang der genannten Punkte zeichnet
	    path.getElements().add( new CubicCurveTo( 400, 0, 400, 100, 200, 100 ) );
	    path.getElements().add( new CubicCurveTo( 0, 100, 0, 200, 400, 200 ) );
	    	    
	    /* - Wie lange soll die Animation dauern?
	     * - Welchen Weg soll die Animation nehmen?
	     * - Zu wem gehört diese Animation
	     */
	    PathTransition pt = new PathTransition();
	    pt.setDuration(Duration.millis(5000));
	    pt.setPath(path);
	    pt.setNode(kreis);
	    pt.setCycleCount(2);
	    pt.setAutoReverse(true);
	    
	    /* -------------------------------- */
		/* --- Sequential Transition ------ */
		/* -------------------------------- */
	    
		// DAMIT ALLE ANGEZEIGT WERDEN DARF NICHT BEI JEDEM DER CYCLECOUNT UNENDLICH
		// SEIN!!!

		SequentialTransition st = new SequentialTransition();
	    //Reihenfolge = zugewiesene Reihenfolge
		// ACHTUNG: Diese Animationen dürfen nicht gestartet werden, wenn im Code diese
		// einer anderen Animation zugeordnet sind.
		// Zum ausprobieren einfach die getChildren().addAll auskommentieren
		st.getChildren().addAll(timeline, ft, pt);
	    st.setCycleCount(Timeline.INDEFINITE);
	    st.setAutoReverse(true);
	    
	    System.out.println("Welche Animation ausführen?");
	    System.err.println("(1) Timeline Transition");
	    System.err.println("(2) Fading Transition");
	    System.err.println("(3) Path Transition");
	    System.err.println("(4) Sequential Transition");
	    Scanner sc = new Scanner(System.in);
	    int auswahl = sc.nextInt();
	    
		switch (auswahl) {
		case 1:
			this.timelinePlay(timeline);
			break;
		case 2:
			this.fadingtransitionPlay(ft);
			break;
		case 3:
			// Zeigen, dass so der Path angezeigt werden kann auf dem sich bewegt wird
			mainPane.getChildren().add(path);
			this.pathtransitionPlay(pt);
			break;
		case 4:
			// Zeigen, dass so der Path angezeigt werden kann auf dem sich bewegt wird
			mainPane.getChildren().add(path);
			this.sequentialtransitionPlay(st);
			break;

		}
		
		sc.close();
	}

	// Muss Methoden
	private void sequentialtransitionPlay(SequentialTransition st) {
		st.play();
	}

	private void pathtransitionPlay(PathTransition pt) {
		pt.play();
	}

	private void fadingtransitionPlay(FadeTransition ft) {
		ft.play();

	}

	private void timelinePlay(Timeline timeline) {
		timeline.play();
	}

	public static void main(String[] args) {
		launch(args);

	}
	
}
