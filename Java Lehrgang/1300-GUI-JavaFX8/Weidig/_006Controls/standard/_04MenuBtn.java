package _006Controls.standard;


import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class _04MenuBtn extends Application
{
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		MenuButton m = new MenuButton("Burger");
		m.setPopupSide(Side.RIGHT);
		MenuItem menuItem1 = new MenuItem("Cheeseburger");
		menuItem1.setOnAction(e -> System.out.println("Lecker Cheeseburger"));
	}
 	
	 
	 	
	 	
	 	public static void main(String[] args)
	 	{
	 		launch();

	 	}
}