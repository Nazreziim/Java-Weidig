/**
 * 
 */
package alt.einfuehrung.swing.version3Panel;

import java.awt.*;
import javax.swing.*;

/**
 * @author lgerhard
 *
 */
public class MyFrame extends JFrame{

	
	private JPanel myPanel;
	
	private static final long serialVersionUID = 1L;
	
	public MyFrame(String bezeichner){
		super(bezeichner);
		this.setSize(200, 100);
		this.setMaximumSize(new Dimension(500,500));
		//this.setBackground(new Color(150,0,0));
		this.setSize(250, 250);
		myPanel = new MyPanel();
		this.add(myPanel);
		JFrame frame2 = new JFrame("Fenster2"); //UnterFenster
		frame2.setSize(100, 500);
		frame2.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		System.out.println("Farbe gesetzt" + this.getBackground().getBlue()+  this.getBackground().getGreen() +  this.getBackground().getBlue());
		this.setVisible(true);
	}
	
}
