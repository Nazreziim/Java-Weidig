package _004Layouts;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import javafx.scene.layout.Pane;

public class _02ErstesFXMLLayoutController implements Initializable{
	@FXML
	private VBox mainVBox;
	@FXML
	private Pane obereLeiste;
	@FXML
	private Pane mittleresFeld;
	@FXML
	private Pane untereLeiste;
	
	public void farbenÄndern() {
		this.obereLeiste.setStyle("-fx-background-color: red");
		this.mittleresFeld.setStyle("-fx-background-color: green");
		this.untereLeiste.setStyle("-fx-background-color: red");
	}

	//Wird aufgerufen sobald .load() durch den Loader aufgerufen wird
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Initialisiert!");
		location.getPath();
		
	}

}
