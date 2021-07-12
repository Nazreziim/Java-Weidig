package mülleimer;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class test extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vbox = new VBox();
		TextField eingabeFeld = new TextField();
		Button button = new Button();
		button.setOnMouseClicked(event -> System.out.println(eingabeFeld.getText()));
		vbox.getChildren().addAll(eingabeFeld, button);
		
		Scene scene = new Scene(vbox, 500.0, 500.0);
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}

	public static void main(String[] args) {
		launch(args);

	}

}
