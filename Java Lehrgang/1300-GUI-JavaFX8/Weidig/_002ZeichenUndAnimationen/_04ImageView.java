package _002ZeichenUndAnimationen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class _04ImageView extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = new Pane();
		Scene mainScene = new Scene(mainPane);

		Image bild = new Image("_003Medien/ressourcen/BeweglichTransparentesBild.gif");

		ImageView iV = new ImageView();
		iV.setImage(bild);

		mainPane.getChildren().add(iV);

		// Zum Zeigen der Transparenz ändern der Hintergrundfarbe
		mainPane.setStyle("-fx-background-color: red");

		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

}
