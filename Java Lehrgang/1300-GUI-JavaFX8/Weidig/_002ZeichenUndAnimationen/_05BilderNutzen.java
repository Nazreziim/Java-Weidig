package _002ZeichenUndAnimationen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class _05BilderNutzen extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = new Pane();
		Scene mainScene = new Scene(mainPane);
		
		/* -------------------------------- */
		/* ------ Eigener Icon       ------ */
		/* -------------------------------- */
		
		//Nutzt das angegebene Bild und quetscht es auf die n�tige Form
		primaryStage.getIcons().add(new Image("_003Medien/ressourcen/ITSBW.png"));
		
		//M�glichkeit 2 - Unterschied: relative Pfadangabe m�glich
		primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("../res/ITSBW.png")));
		
		//M�glichkeit 3
		primaryStage.getIcons().add(new Image(this.getClass().getResource("../res/ITSBW.png").toString()));
		
		
		/* -------------------------------- */
		/* --- Formen mit Bild f�llen ----- */
		/* -------------------------------- */
		
		Image bild = new Image("_003Medien/ressourcen/ITSBW.png");
		Rectangle rec = new Rectangle(50, 50, (int) bild.getWidth(), (int) bild.getHeight());
		
		//Rechteck mit Bild bef�llen
		rec.setFill(new ImagePattern(bild));
		
		//Zum Zeigen des Randes
		rec.setStroke(Color.BLACK);
		rec.setStrokeWidth(1);
		
		
		mainPane.getChildren().add(rec);
		//Aufzeigen der Transparenz
		mainPane.setStyle("-fx-background-color: grey");
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}	

}
