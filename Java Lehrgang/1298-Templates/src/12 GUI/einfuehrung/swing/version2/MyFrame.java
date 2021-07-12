/**
 * 
 */
package einfuehrung.swing.version2;

import java.awt.*;
import javax.swing.*;

/**
 * @author alandgraf
 *
 */
public class MyFrame extends JFrame{

	
	private JPanel myPanel;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyFrame(String bezeichner){
		super(bezeichner);
		this.setSize(200, 100);
		this.setMaximumSize(new Dimension(500,500));
		this.setBackground(new Color(150,0,0));
		this.setSize(250, 250);
		myPanel = new JPanel();
		myPanel.setSize(100, 100);
		myPanel.setBackground(new Color(23,0,255));
		this.add(myPanel);
		System.out.println("Farbe gesetzt" + this.getBackground().getBlue()+  this.getBackground().getGreen() +  this.getBackground().getBlue());
		this.setVisible(true);
	}
	
}
