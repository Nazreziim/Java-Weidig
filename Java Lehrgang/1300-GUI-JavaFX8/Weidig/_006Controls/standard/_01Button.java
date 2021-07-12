package _006Controls.standard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class _01Button extends Application
{
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("01 Button");
 		primaryStage.getIcons().add(new Image("ressourcen/ITSBW.png"));
	
		Pane pane = new Pane();
		
		Button button = new Button("Bitte klicken sie mich !");
		
		button.setOnAction(e->{
			
		button.setText("Danke");
		pane.setStyle("-fx-background-color: PINK");
		
		});
		
		button.setTranslateX(200);
		button.setTranslateY(230);
		
		pane.getChildren().add(button);
		
		Scene scene = new Scene(pane, 500,500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	 
	 	
	 
	 	
	 	
	 	public static void main(String[] args)
	 	{
	 		launch();

	 	}
}