package events.version4_innere_klassen;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class PrivateClassFrame extends JFrame {
	private class CloseWindowAction extends WindowAdapter {
		
		public void windowClosing(WindowEvent e){
			System.out.println("Schließen mit Adapter");
			sayHello();
			System.exit(0);
		}

	}

	public PrivateClassFrame(int x, int y){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(x, y);			
		//Hinzufügen des Adapters als Listener für WindowEvents.
		this.addWindowListener(new CloseWindowAction());
		this.setVisible(true);
	}
	public void sayHello(){
		
		System.out.println("Hello!");
	}
	
	public static void main(String[] args){
		PrivateClassFrame of = new PrivateClassFrame(640,480);
	}
}