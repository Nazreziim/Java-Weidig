package alt.einfuehrung.swing.version3Panel;

import java.awt.Color;

import javax.swing.*;

public class MyPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyPanel(){
		this.setSize(100, 100);
		this.setBackground(new Color(23,0,255));
		this.add(new JButton("OK"));
	}
	
}
