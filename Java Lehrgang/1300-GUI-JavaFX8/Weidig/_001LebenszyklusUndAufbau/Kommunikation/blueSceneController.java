package _001LebenszyklusUndAufbau.Kommunikation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class blueSceneController implements Initializable {
	@FXML
	private Pane fxBluePane;
	@FXML
	private Button fxButton;
	
	private int a;

	// Event Listener on Button[#fxButton].onAction
	@FXML
	public void sceneWechsel(ActionEvent event) {
		try {
			Stage mainStage = (Stage) fxButton.getScene().getWindow();
			
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("redScene.fxml"));
			Parent fxmlScene = loader.load();
			redSceneController controller = new redSceneController();
			controller.setA(50);
			controller.started();
			
			mainStage.setScene(new Scene(fxmlScene));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Blue Initialisiert!");

	}
	
	public void started() {
		Mensch.getUdo().setAlter(12);
		System.out.println("Udos Alter: " + Mensch.getUdo().getAlter());
		System.out.println("Heiﬂt er wirklich Udo?: " + Mensch.getUdo().getName());
	}
	
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
}
