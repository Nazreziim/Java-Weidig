package components.version5_colorchooser;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * In dieser Klasse werden alle nötigen Panels erstellt und als Observer dem Model
 * (Observable) zugeordnet. Außerdem werden die Panels natürlich auch dem Frame
 * hinzugefügt.
 * 
 * @author LGerhard
 *
 */
public class MainFrame extends JFrame {
	private Model m;
	
	public MainFrame( Model m){
		super("CoolorChooser-Frame");
		this.m = m;	
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(0,3,20,20));
		
		PaintPanel pp = new PaintPanel(m);	
		this.add(pp);
		m.addObserver(pp);
		
		// Das ButtonPanel ist kein Observer!!!
		ButtonPanel bp = new ButtonPanel(m);	
		this.add(bp);

		TextControllerPanel tcp = new TextControllerPanel(m);
		this.add(tcp);
		
		ListPanel lp = new ListPanel(); // Hier muss das Model durch einen Trick nicht weitergereicht werden - s. Code!
		this.add(lp);
		m.addObserver(lp);
		
		SliderPanel sp = new SliderPanel(m);
		this.add(sp);
		m.addObserver(sp);
		
		ProgressBarPanel pbp = new ProgressBarPanel(m);
		this.add(pbp);
		m.addObserver(pbp);
		
		ComboControlPanel ccp = new ComboControlPanel(m);
		this.add(ccp);
		m.addObserver(ccp);
		
		TabbedPanel tp = new TabbedPanel(m);
		this.add(tp);
		m.addObserver(tp);
		
		this.pack();
		this.setVisible(true);
	}

	public Model getModel() {
		return m;
	}
	
	
}
