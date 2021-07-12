package alt.aufgaben.zeichnen.fang_den_ball;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class FangDenBall extends JFrame implements MouseMotionListener, MouseListener {

	private int directionX = 1;
	private int directionY = 1;
	private int ballsize = 100;
	private int granularitaet = 5; // je größer, desto genauer die Bewegung (max 20)
	
	public FangDenBall() {
		super("Spaß");
		 try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
			
			this.setUndecorated(true);
			this.setLocation(1000, 500);
			this.setSize( 100, 100 );
			this.setOpacity( 0.95F );
			this.add(new JLabel(" Fang mich doch!"));
			this.addMouseMotionListener(this);
			this.addMouseListener(this);
			this.setShape( new Ellipse2D.Float(0.0F, 0.0F, this.ballsize, this.ballsize) );
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			this.setVisible( true );
			//this.moveInfinity(this);
		 } catch (Exception ex) {
			ex.printStackTrace();
		 }
	}
	
//	protected void paintComponent(Graphics g) {
//		super.paintComponents(g);
//
//		this.changeDirection(this, null);
//		this.setBounds(this.getX()+this.directionX, this.getY()+this.directionY, this.getWidth(), this.getHeight());
//		
//	}
	
	
	public void moveInfinity(JFrame frame) {
		while (true) {
			try {
				this.changeDirection(this, null);
				this.setLocation(this.getX()+this.directionX, this.getY()+this.directionY);
//				frame.setBounds(frame.getX()+this.directionX, frame.getY()+this.directionY, frame.getWidth(), frame.getHeight());
//				frame.repaint(1,frame.getX()+this.directionX, frame.getY()+this.directionY, frame.getWidth(), frame.getHeight());
				Thread.sleep(100);
				System.out.println(frame.getIgnoreRepaint() + "HAHA " + frame.getX() + " " + frame.getY() + "    " + this.getX() + " " + this.getY());
//				this.update(getGraphics());
//				frame.update(getGraphics());
				
//				this.repaint();
//				this.pack();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		FangDenBall fdb1 = new FangDenBall();
		fdb1.moveInfinity(fdb1);
		//FangDenBall fdb2 = new FangDenBall();
		//FangDenBall fdb3 = new FangDenBall();
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		FangDenBall f = (FangDenBall)e.getSource();
		this.changeDirection(f, e);
		f.setLocation(f.getX()+this.directionX, f.getY()+this.directionY);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	public void changeDirection(JFrame f, MouseEvent e) {
		// Abfragen des Maus-Ortes nur, wenn die Maus die Neuberechunung ausgelöst hat
		if (e != null) {
			// Erkennen von welcher Seite der Ball angeschoben wird
			if ((e.getX()) < f.getWidth()/2) { // von links			
				this.directionX = (f.getWidth()/2 - e.getX())/this.granularitaet;
			}
			else {// von rechts
				this.directionX = -(e.getX() - f.getWidth()/2)/this.granularitaet;
			}
			
			// Analog für oben/unten
			if (e.getY() < f.getHeight()/2) {// von oben
				this.directionY = (f.getHeight()/2 - e.getY())/this.granularitaet;
			}
			else { // von unten
				this.directionY = -(e.getY() - f.getHeight()/2)/this.granularitaet;
			}
		}
		
		// In jedem Fall: Die Grenzen des Bildschirms abfangen
		if (f.getX() <= 0) 
			this.directionX = Math.abs(this.directionX);
		if (f.getY() <= 0)
			this.directionY = Math.abs(this.directionY);
		if (f.getX() >= Toolkit.getDefaultToolkit().getScreenSize().width - f.getWidth())
			this.directionX = -Math.abs(this.directionX);
		if (f.getY() >= Toolkit.getDefaultToolkit().getScreenSize().height - f.getHeight())
			this.directionY = -Math.abs(this.directionY);
	}

	// nicht implementierte vererbte Methoden
	public void mouseDragged(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
