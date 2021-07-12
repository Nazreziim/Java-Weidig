package _006Controls.standard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _02ToggleBtn extends Application
{
	/*
	 * Im unterschied zur CheckBocx nur 2 Zustände selected
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("01 Button");
 		primaryStage.getIcons().add(new Image("ressourcen/ITSBW.png"));
	
		Pane pane = new Pane();
		
		ToggleButton togglebutton1 = new ToggleButton("Option 1");
		ToggleButton togglebutton2 = new ToggleButton("Option 2");
		ToggleButton togglebutton3 = new ToggleButton("Option 3");
		
		ToggleButton togglebutton4 = new ToggleButton("sieh mich an");
		
		ToggleGroup togglegroup = new ToggleGroup();
		
		togglebutton1.setToggleGroup(togglegroup);
		togglebutton2.setToggleGroup(togglegroup);
		togglebutton3.setToggleGroup(togglegroup);
		
		VBox vBox = new VBox(togglebutton1,togglebutton2,togglebutton3);
		
		vBox.setTranslateX(220);
		vBox.setTranslateY(220);
		
		
		togglebutton4.setOnAction(feuer -> {
			
			if(togglebutton4.selectedProperty().get() == true)
			{
				pane.setStyle("-fx-background-color: BLACK");
			}
			else
			{
				pane.setStyle("-fx-background-color: WHITE");
			}
				
			
		});
		
		pane.getChildren().addAll(vBox, togglebutton4);
	
				
		Scene scene = new Scene(pane, 500,500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args)
 	{
 		launch();

 	}
}