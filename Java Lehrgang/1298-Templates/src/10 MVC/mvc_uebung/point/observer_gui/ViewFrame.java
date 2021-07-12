package mvc_uebung.point.observer_gui;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;


public class ViewFrame extends JFrame implements Observer{
	
	private PointPanel panel = new PointPanel();
	
	public ViewFrame(){
		super("FlyingBall");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(m.getWidth()*10 + 3,m.getHeight()*10 + 3);			
		this.add(panel);
		
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		Model model = (Model) o;
		this.setSize(new Dimension(model.getWidth()*10 +3,model.getHeight()*10 +3));
		panel.setSize(new Dimension(model.getWidth()*10+3,model.getHeight()*10+3));
		panel.setPoint(model.getPoint());
		panel.repaint();
		
	}
	
	
}
