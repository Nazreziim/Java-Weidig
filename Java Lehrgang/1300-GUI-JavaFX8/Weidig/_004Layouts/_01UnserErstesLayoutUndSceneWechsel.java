package _004Layouts;

import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _01UnserErstesLayoutUndSceneWechsel extends Application {

	// Layout: Tabellenlayout

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ErsteAnwendung");
		primaryStage.getIcons().add(new Image("res/ITSBW.png"));
		primaryStage.setWidth(1280);
		primaryStage.setHeight(720);
		primaryStage.setResizable(false);

		primaryStage.setScene(this.scene1());
		primaryStage.show();
		
		
		/*********** Szenenwechsel ***************/
		System.out.println("Szenenwechsel? (J/N)");
		Scanner sc = new Scanner(System.in);
		
		String auswahl = sc.next();
		
		if(auswahl.equals("J")) {
			primaryStage.setScene(this.scene2());
		}
		
		sc.close();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public Scene scene1() {
		// Beim Festlegen der Scene mit den größen rumspielen bis man die optimale Größe
		// hat

		// 1. Welches Pane bietet sich an?
		VBox vbox = new VBox();
		vbox.setPrefSize(1280, 720);

		// 2. Wie legen wir die Felder fest
		// 3 Felder benötigen wir. Einfachste Möglichkeit: Panes
		Pane feld1 = new Pane();
		Pane feld2 = new Pane();
		Pane feld3 = new Pane();
		// ---> Wie sie sehen. Sehen sie Nichts.

		// 3. Farbe festlegen
		feld1.setStyle("-fx-background-color: grey");
		feld2.setStyle("-fx-background-color: lightgrey");
		feld3.setStyle("-fx-background-color: grey");
		// ---> Wie sie sehen. Sehen sie immernoch Nichts.

		// 4. Größe der Felder festlegen (Hier muss man rumspielen)
		feld1.setPrefSize(1280, 80);
		feld2.setPrefSize(1280, 620);
		feld3.setPrefSize(1280, 20);

		vbox.getChildren().add(feld1);
		vbox.getChildren().add(feld2);
		vbox.getChildren().add(feld3);

		return new Scene(vbox);

	}

	/************* Für die 2. Szene die vorhandene kopieren und umfärben ***************/
	public Scene scene2() {
		// Beim Festlegen der Scene mit den größen rumspielen bis man die optimale Größe
		// hat

		// 1. Welches Pane bietet sich an?
		VBox vbox = new VBox();
		vbox.setPrefSize(1280, 720);

		// 2. Wie legen wir die Felder fest
		// 3 Felder benötigen wir. Einfachste Möglichkeit: Panes
		Pane feld1 = new Pane();
		Pane feld2 = new Pane();
		Pane feld3 = new Pane();
		// ---> Wie sie sehen. Sehen sie Nichts.

		// 3. Farbe festlegen
		feld1.setStyle("-fx-background-color: red");
		feld2.setStyle("-fx-background-color: green");
		feld3.setStyle("-fx-background-color: red");
		// ---> Wie sie sehen. Sehen sie immernoch Nichts.

		// 4. Größe der Felder festlegen (Hier muss man rumspielen)
		feld1.setPrefSize(1280, 80);
		feld2.setPrefSize(1280, 620);
		feld3.setPrefSize(1280, 20);

		vbox.getChildren().add(feld1);
		vbox.getChildren().add(feld2);
		vbox.getChildren().add(feld3);

		return new Scene(vbox);
	}

}
