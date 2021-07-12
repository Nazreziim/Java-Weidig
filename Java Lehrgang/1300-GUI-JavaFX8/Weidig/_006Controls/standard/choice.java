package _006Controls.standard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class choice extends Application{
	public void start(Stage primaryStage) throws Exception{
		Pane layer1 = new Pane();
		

		
	
	ChoiceBox<Object> ch=new ChoiceBox<>();
	layer1.getChildren().addAll(ch);
		ch.setLayoutX(50);
		ch.setLayoutY(50);
		ch.setStyle("-fx-background-color: lightcoral");
	ch.setRotate(10.0);
		 ch.getItems().addAll("bild1","bild2", "bild3", "bild4");
		 ch.setValue("bild1");
		 
		 ch.setOnAction(e -> {
		     System.out.println("Selected: " + ch.getValue());


		     
		   
		 });
		 
	

		

		
		
		Scene scene =new Scene(layer1,500,500);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args); 
	}

}
