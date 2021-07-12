package _006Controls.standard;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Oberflaeche implements Initializable{

// Bauteile der Buehne	

    @FXML
    private Pane pane;
    
    @FXML
    private Button btn;


    @FXML
    private ToggleButton ToggleBtnBW;
    
    @FXML
    private ToggleButton ToggleBtn3;

    @FXML
    private ToggleButton ToggleBtn1;

    @FXML
    private ToggleButton ToggleBtn2;


    @FXML
    private RadioButton RadioBtn3;

    @FXML
    private RadioButton RadioBtn2;

    @FXML
    private RadioButton RadioBtn1;
    
    @FXML
    private MenuBar MenuBar;
    
    @FXML
    private MenuItem Killer;

    @FXML
    private MenuButton MenuButton;

    @FXML
    private Button ButtonBarLinks;

    @FXML
    private Button ButtonBarHoch;

    @FXML
    private Button ButtonBarRunter;

    @FXML
    private Button ButtonBarRechts;

    @FXML
    private SplitMenuButton SplitMenuButton;

    @FXML
    private MenuItem SplitMenuKreis;

    @FXML
    private MenuItem SplitMenuEllipse;

    @FXML
    private MenuItem SplitMenuViereck;
    
    @FXML
    private Rectangle Rectangle;

    @FXML
    private Ellipse Ellipse;

    @FXML
    private Circle Circle;


    
    
    
// Steuerungs Events    
    
    @FXML
    void clicked(MouseEvent event) {
    	this.btn.setText("Danke !");
    }
     
    @FXML
    void clickedradio(MouseEvent event) {
        	
    	ToggleGroup radiogrp = new ToggleGroup();
	    
    	this.RadioBtn1.setToggleGroup(radiogrp);
	    this.RadioBtn2.setToggleGroup(radiogrp);
	    this.RadioBtn3.setToggleGroup(radiogrp);


    }
    @FXML
    void clickedtoggle(MouseEvent event) {
    	ToggleGroup togglegrp = new ToggleGroup();
    	this.ToggleBtn1.setToggleGroup(togglegrp);
       	this.ToggleBtn2.setToggleGroup(togglegrp);
       	this.ToggleBtn3.setToggleGroup(togglegrp);
        }
    

  
    
    
    @FXML
    void toggle(MouseEvent event) {
    	if(ToggleBtnBW.selectedProperty().get() == true)
		{
			pane.setStyle("-fx-background-color: BLACK");
		}
		else
		{
			pane.setStyle("-fx-background-color: WHITE");
		}
    }
    @FXML
    void mover(ActionEvent event) {}
       
   
    
    

    @FXML
    void formChoice(ActionEvent event) {
    	System.out.println("Hallo Kreis");
		this.Circle.setVisible(true);
		this.Rectangle.setVisible(false);
		this.Ellipse.setVisible(false);
		this.Circle.setLayoutX(100);
		this.Circle.setLayoutY(100);
    }
    
    @FXML
    void formChoice1(ActionEvent event) {
    	System.out.println("Hallo ELLI");
		this.Circle.setVisible(false);
		this.Rectangle.setVisible(false);
		this.Ellipse.setVisible(true);
		this.Ellipse.setLayoutX(100);
		this.Ellipse.setLayoutY(100);
    }

    @FXML
    void formChoice2(ActionEvent event) {
    	System.out.println("Hallo VIERECK");
		this.Circle.setVisible(false);
		this.Rectangle.setVisible(true);
		this.Ellipse.setVisible(false);
		this.Rectangle.setLayoutX(100);
		this.Rectangle.setLayoutY(100);
    }
    
    
    @FXML
    void kill(ActionEvent event) {
    	this.Circle.setVisible(false);
		this.Rectangle.setVisible(false);
		this.Ellipse.setVisible(false);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	

		
 	ButtonBarHoch.setOnAction(move ->{
    		
    		if(Circle.isVisible()== true)
    		{
    			Circle.setLayoutY(Circle.getLayoutY()-10);
    		}
    		
    		if(Ellipse.isVisible() == true)
    		{
    			Ellipse.setLayoutY(Ellipse.getLayoutY()-10);
    		}
    		
    		if(Rectangle.isVisible() == true)
    		{
    			Rectangle.setLayoutY(Rectangle.getLayoutY()-10);
    		}	
    	});
    	
    	ButtonBarRunter.setOnAction(move ->{
    		
    		if(Circle.isVisible()== true)
    		{
    			Circle.setLayoutY(Circle.getLayoutY()+10);
    		}
    		
    		if(Ellipse.isVisible() == true)
    		{
    			Ellipse.setLayoutY(Ellipse.getLayoutY()+10);
    		}
    		
    		if(Rectangle.isVisible() == true)
    		{
    			Rectangle.setLayoutY(Rectangle.getLayoutY()+10);
    		}	
    	});
    	
    	ButtonBarRechts.setOnAction(move ->{
    		
    		if(Circle.isVisible()== true)
    		{
    			Circle.setLayoutX(Circle.getLayoutX()+10);
    		}
    		
    		if(Ellipse.isVisible() == true)
    		{
    			Ellipse.setLayoutX(Ellipse.getLayoutX()+10);
    		}
    		
    		if(Rectangle.isVisible() == true)
    		{
    			Rectangle.setLayoutX(Rectangle.getLayoutX()+10);
    		}	
    	});

    	ButtonBarLinks.setOnAction(move ->{
    		
    		if(Circle.isVisible()== true)
    		{
    			Circle.setLayoutX(Circle.getLayoutX()-10);
    		}
    		
    		if(Ellipse.isVisible() == true)
    		{
    			Ellipse.setLayoutX(Ellipse.getLayoutX()-10);
    		}
    		
    		if(Rectangle.isVisible() == true)
    		{
    			Rectangle.setLayoutX(Rectangle.getLayoutX()-10);
    		}	
    	});

	}
}