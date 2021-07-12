package events.version2_eigene_klasse;

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

	public OwnFrame(int x, int y){
		super("OwnFrame");
		this.setSize(x,y);
		this.addWindowListener(new OwnWindowListener());
		
		
	}
	
	public static void main(String[] args){
		OwnFrame f = new OwnFrame(640, 480);
		f.setVisible(true);
	}
}
