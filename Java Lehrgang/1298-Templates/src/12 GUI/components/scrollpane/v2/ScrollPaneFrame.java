package components.scrollpane.v2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class ScrollPaneFrame extends JFrame {
	/**
	 * Scrollbares Panel mit mehr Komponenten als Darstellbar soll hier scrollbar gemacht werden.
	 */
	public ScrollPaneFrame(){
		//Hier setzt man die Höhe/Breite die tatsächlich zur Verfügung steht
		
		this.setSize(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel an ScrollPane geben
		JScrollPane pane = new JScrollPane(new ViewPanel());
		
		//ScrollPane an Frame geben			
		this.add(pane);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		ScrollPaneFrame of = new ScrollPaneFrame();
	}
}