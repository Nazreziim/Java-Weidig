package _006Controls.standard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _03RadioBtn  extends Application
{
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("01 Button");
 		primaryStage.getIcons().add(new Image("ressourcen/ITSBW.png"));
	
		Pane pane = new Pane();
		
		RadioButton radiobutton1 = new RadioButton("Option 1");
		RadioButton radiobutton2 = new RadioButton("Option 2");
		RadioButton radiobutton3 = new RadioButton("Option 3");
		
		ToggleGroup togglegroup = new ToggleGroup();
		
		radiobutton1.setToggleGroup(togglegroup);
		radiobutton2.setToggleGroup(togglegroup);
		radiobutton3.setToggleGroup(togglegroup);
		
		VBox vBox = new VBox(radiobutton1,radiobutton2,radiobutton3);
		
		vBox.setTranslateX(220);
		vBox.setTranslateY(220);
		
		
		pane.getChildren().add(vBox);
				
		Scene scene = new Scene(pane, 500,500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args)
 	{
 		launch();

 	}
}