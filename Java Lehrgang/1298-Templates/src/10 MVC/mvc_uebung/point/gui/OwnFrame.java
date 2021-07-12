package mvc_uebung.point.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OwnFrame extends JFrame {

	public OwnFrame( Model m){
		super("FlyingBall");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(m.getWidth(),m.getHeight());
		OwnPanel panel = new OwnPanel(m);	
		
		this.add(panel);
		
		this.pack();
		this.setVisible(true);
	}
	
	
}
