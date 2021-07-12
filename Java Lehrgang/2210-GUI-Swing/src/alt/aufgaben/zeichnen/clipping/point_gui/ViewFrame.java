package alt.aufgaben.zeichnen.clipping.point_gui;

import java.awt.Component;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;


public class ViewFrame extends JFrame implements Observer{
	
	private PointPanel panel = new PointPanel();
	
	public ViewFrame(){
		super("FlyingBall");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.add(panel);
		//this.pack();
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		Model model = (Model) o;
		// Gr��e des Panels ausgehend von den Parametern des Models
		// Wegen der Vergr��erung mit Faktor 10 m�ssen Breite/H�he um eins vergr��ert werden
		// - sonst u.U. keine Paints f�r Punkte am unteren / rechten Rand
		panel.setSize((model.getWidth() + 1) * 10, (model.getHeight() + 1) *10);	
		
		// Gr��e des Frames ausgehend von seinen Minimalabmessungen + Gr��e des Panels
		this.setSize((int) (panel.getSize().getWidth() + this.getMinimumSize().getWidth()),
				(int)(panel.getSize().getHeight() + this.getMinimumSize().getHeight()));
		
		panel.setPoint(model.getPoint());
		panel.repaint();
		
	}
	
	
}
