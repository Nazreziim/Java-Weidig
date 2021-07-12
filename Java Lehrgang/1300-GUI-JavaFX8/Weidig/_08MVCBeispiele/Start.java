package _08MVCBeispiele;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hörsaalchat");
		primaryStage.getIcons().add(new Image("res/ITSBW.png"));
		primaryStage.setResizable(false);

		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MonsterClicker.fxml"));
		Parent fxmlScene = loader.load();

		MainController controller = loader.getController();

		Scene scene = new Scene(fxmlScene);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		controller.gameRunning();

	}

	public static void main(String[] args) {
		setUserAgentStylesheet(STYLESHEET_CASPIAN);
		launch(args);

	}

}
