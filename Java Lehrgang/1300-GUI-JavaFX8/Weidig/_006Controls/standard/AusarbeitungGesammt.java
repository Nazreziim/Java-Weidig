package _006Controls.standard;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AusarbeitungGesammt extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("War of Buttons");
		primaryStage.getIcons().add(new Image("ressourcen/ITSBW.png"));
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Oberflaeche.fxml"));
		
		Parent fxmlScene = loader.load();
		
		Oberflaeche controller = loader.getController();
		
		Scene scene = new Scene(fxmlScene);
		
	
		
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	
	public static void main(String[] args) {
		
		launch();
	}
}
