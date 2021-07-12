package mvc_uebung.point.gui;


import java.awt.*;
import java.awt.geom.Line2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OwnPanel extends JPanel implements View{
	private Model m;
	public OwnPanel( Model m){
		this.m = m;
		m.setView(this);
		this.setPreferredSize(new Dimension(m.getWidth()+3,m.getHeight()+3));
		this.setBackground(Color.yellow);
	}
	
	public void update(){
		this.repaint();
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);		
		
		g.fillRect(this.m.getPoint().x, this.m.getPoint().y, 5, 5);		
	}
}
