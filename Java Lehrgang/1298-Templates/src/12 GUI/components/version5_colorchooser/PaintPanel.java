package components.version5_colorchooser;




import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PaintPanel extends JPanel implements Observer{
	private Model m;
	
	public PaintPanel(Model m){
		this.m = m;
		//m.addObserver(this);
		this.setPreferredSize(new Dimension(100,100));
		this.setBackground(Color.yellow);
	}


	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		try{
			this.setBackground(new Color(this.m.getRot(),this.m.getGruen(), this.m.getBlau()));
		}catch(Exception e){
			System.out.println(m.getRot()+ " "+ m.getGruen() + " "+ m.getBlau());
		}
		
		
	}

	
	public void update(Observable o, Object arg) {		
		this.repaint();		
	}
}
