package _006Controls.standard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class check extends Application{
	public void start(Stage primaryStage) throws Exception{
		Pane layer1 = new Pane();
		layer1.setStyle("-fx-background-color: lightblue");
		
		
		TextField txt=new TextField("Status CheckBox");
		txt.setLayoutX(50);
		txt.setLayoutY(100);
		
		Image bild=new Image(this.getClass().getResource("../ressourcen/bier.gif").toString());
		ImageView iv = new ImageView();
		iv.setImage(bild);
		iv.setLayoutX(200);
		iv.setLayoutY(200);
		iv.setVisible(false);
		
		
		
		
		CheckBox cb2 = new CheckBox("Indeterminated");
		layer1.getChildren().addAll(cb2,txt,iv);
		cb2.setLayoutX(50);
		cb2.setLayoutY(50);
		cb2.setIndeterminate(true);
		
		cb2.setOnAction((event)->{
			if (!cb2.isSelected()){
				cb2.setText("deactivated");
				txt.setText("Box checked");
				iv.setVisible(true);
			}
			else {cb2.setText("activated");
			txt.setText("Box unchecked");
			iv.setVisible(false);
			}
			
		});
	

				
		
		Scene scene =new Scene(layer1,500,500);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args); 
	}

}
