package events.version3_mit_adapter;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class OwnFrame extends JFrame {
	
	public OwnFrame(int x, int y){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(x, y);			
		//Hinzufügen des Adapters als Listener für WindowEvents.
		this.addWindowListener(new CloseWindowAction());
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		OwnFrame of = new OwnFrame(640,480);
	}
}