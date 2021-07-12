package _006Controls.standard;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class combo extends Application{
	public void start(Stage primaryStage) throws Exception{
		Pane layer1 = new Pane();
		Image bild=new Image(this.getClass().getResource("../ressourcen/ALoch.gif").toString());
		
		ImageView iv = new ImageView();
		iv.setImage(bild);
		iv.setLayoutX(350);
		iv.setLayoutX(300);
		
		layer1.setStyle("-fx-background-color: blue");
	
		
		
		TextField txt=new TextField("Auswahl");
		txt.setLayoutX(50);
		txt.setLayoutY(350);
		ObservableList<Double> options = 
			    FXCollections.observableArrayList(
			        1.0,
			        0.9,
			        0.8,
			        0.7,
			        0.6,
			        0.5
			    );
		
	  
		
	
		ComboBox<Double> a = new ComboBox<Double>(options);
		a.setEditable(true);
		layer1.getChildren().addAll(a,txt,iv);
		a.setLayoutX(50);
		a.setLayoutY(50);
		a.getItems().addAll(
			    0.4,
			    0.3,
			    0.2,
			    0.1
			);
		a.setValue(1.0); //Default Wert
		
		a.setOnAction((event)->{
			System.out.println("Aktuelle Auswahl: "+a.getValue());
			txt.setText(a.getValue().toString());
			iv.setOpacity(a.getValue());
		
			
									 });
		

		
		
		Scene scene =new Scene(layer1,500,500);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args); 
	}

}
