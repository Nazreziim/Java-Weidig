/**
 * Ersteller: Fw Josiger
 * Datum: 22.06.2021
 */
package _006Controls.standard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @category TODO Model/View/Controller
 * @since 0.0.1
 * @since 22.06.2021
 * @author Fw Josiger
 * 
 */
public class Praesi extends Application {

	/**
	 * TODO beschreiben, was die Methode tut
	 * 
	 * @since 0.0.1
	 * @since 22.06.2021
	 * @author 11805229
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader fLoad = new FXMLLoader(this.getClass().getResource("window.fxml"));
		Parent fxScene = fLoad.load();
		Scene scene = new Scene(fxScene);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
