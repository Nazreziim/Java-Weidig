package _006Controls.standard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Date extends Application{
	public void start(Stage primaryStage) throws Exception{
		Pane layer1 = new Pane();
		layer1.setStyle("-fx-background-color: lightblue");
		
		
	DatePicker d = new DatePicker();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy"); // Formatierung des Datums
	
	
	
	

	//Textfeld zur Ausgabe

	TextField txt=new TextField("Ausgewähltes Datum");
	txt.setLayoutX(50);
	txt.setLayoutY(100);
	
;
	

	
	//----------------------------------
	layer1.getChildren().addAll(d,txt);
	d.setLayoutX(50);
	d.setLayoutY(50);
	d.setValue(LocalDate.now());
	
	
	//actionEvent für Textfeld
	d.setOnAction(e -> {
	     LocalDate date = d.getValue();
	     System.out.println("Selected date: " + formatter.format(date)); 
	    System.out.println(date.getDayOfYear());
	    System.out.println(date.getEra());
	
	     txt.setText(date.toString());
	
	 });
	
	
	
	
	

		

		
		
		Scene scene =new Scene(layer1,500,500);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args); 
	}

}
