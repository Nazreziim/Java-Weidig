package _006Controls.standard;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class TabPaneUndSo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ScrollPane & Co.");
		primaryStage.getIcons().add(new Image("ressourcen/ITSBw.png"));
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("TabPane.fxml"));
		Parent fxmlScene = loader.load();
		
		TabPaneController controller = loader.getController();
		
		
		Scene scene = new Scene(fxmlScene);
		primaryStage.setScene(scene);
		primaryStage.show();	

	}

	public static void main(String[] args) {
		launch(args);
	}

}
