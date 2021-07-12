package _002ZeichenUndAnimationen;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class _06BildanimationUndTransformation extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = new Pane();
		Scene mainScene = new Scene(mainPane);
		mainPane.setMinSize(1920, 1080);

		// Form mit Bild füllen

		Image bild = new Image("_003Medien/ressourcen/BeweglichTransparentesBild.gif");
		Rectangle rec = new Rectangle(50, 50, bild.getWidth(), bild.getHeight());
		

		
		
		/* -------------------------------- */
		/* ------- Transformations -------- */
		/* -------------------------------- */
		//Hier nur die wichtigsten, einfachsten Mal gezeigt
		
		
		// Rechteck mit Bild befüllen
		// ACHTUNG: Bevor eine Transformation stattfindet sollte die Form befüllt sein
		rec.setFill(new ImagePattern(bild));
		
		//Transformationen = Veränderungen der Form und des Inhalts
		
		//Scale = Größe --> 1. Wert = -x sorgt dafür, dass das Bild gespiegelt wird
		//ACHTUNG: Die zugehörigen Animationen werden dazugehörig ebenfalls gespiegelt
		rec.getTransforms().add(new Scale(-0.5,0.5));
		
		//Rotate = Rotation um x Grad
		rec.getTransforms().add(new Rotate(120));
		
		//Verschiebt das Bild auf eine neue Position
		rec.getTransforms().add(new Translate(rec.getX(), rec.getY()+300));
		
		/****************************** ANIMATION ****************************************/
		//Wir erzeugen einen Pfad
	    Path path = new Path();
	    //ACHTUNG: MoveTo = Ausgangspunkt [Muss immer einmal festgelegt werden]
	    path.getElements().add(new MoveTo(150, 250));
	    path.getElements().add(new LineTo(1500, 250));
	    
	    PathTransition pt = new PathTransition();
	    pt.setDuration(Duration.millis(5000));
	    pt.setPath(path);
	    pt.setNode(rec);
	    pt.setCycleCount(Timeline.INDEFINITE);
	    pt.setAutoReverse(true);
	    
	    pt.play();


		mainPane.getChildren().add(rec);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
