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
		// Größe des Panels ausgehend von den Parametern des Models
		// Wegen der Vergrößerung mit Faktor 10 müssen Breite/Höhe um eins vergrößert werden
		// - sonst u.U. keine Paints für Punkte am unteren / rechten Rand
		panel.setSize((model.getWidth() + 1) * 10, (model.getHeight() + 1) *10);	
		
		// Größe des Frames ausgehend von seinen Minimalabmessungen + Größe des Panels
		this.setSize((int) (panel.getSize().getWidth() + this.getMinimumSize().getWidth()),
				(int)(panel.getSize().getHeight() + this.getMinimumSize().getHeight()));
		
		panel.setPoint(model.getPoint());
		panel.repaint();
		
	}
	
	
}
