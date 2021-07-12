package alt.components.scrollpane.v1;

import java.awt.*;

import javax.swing.*;

public class ScrollPaneFrame extends JFrame {
	
	public ScrollPaneFrame(int x, int y){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,200);
		//JTextArea implementieren Verschiebefähigkeit nicht selbst. D.H.
		//von Haus aus keine Scrollleisten vorhanden.
		JTextArea t = new JTextArea();
		t.setSize(new Dimension(300,200));
		
		//Deshalb muss Textfeld in ScrollPane Platz nehmen.
		JScrollPane p = new JScrollPane(t,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//Jetzt wir die Scrollpane zum Frame hinzugefügt.
		this.add(p);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		ScrollPaneFrame of = new ScrollPaneFrame(300,200);
	}
}