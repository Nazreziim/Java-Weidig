package alt.components.scrollpane.v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.Scrollable;

@SuppressWarnings("serial")
public class ViewPanel extends JPanel  {
	
	public ViewPanel(){
		
		
		GridLayout lay = new GridLayout(0,1);
	
		this.setLayout(lay);
		Font font =new Font("my",Font.ITALIC,30);	
		JLabel l = new JLabel();
		for(int i = 0; i < 10; i++){
			l = new JLabel("Test"+i);
			l.setFont(font);
			this.add(l);
		}
		
	}


	
	
}
