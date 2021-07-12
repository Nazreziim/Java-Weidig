package components.version1_border;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class BorderFrame extends JFrame {

	public class KeyListen implements KeyListener {

		public void keyTyped(KeyEvent e) {
			System.out.println("typed " + e.getKeyChar());
			System.out.println("typed " + e.getKeyCode());
		}

		public void keyPressed(KeyEvent e) {
			System.out.println("pressed " + e.getKeyChar());
			System.out.println("pressed " + e.getKeyCode());
		}

		public void keyReleased(KeyEvent e) {
			System.out.println("released " + e.getKeyChar());
			System.out.println("released " + e.getKeyCode());
		}

	}

	public BorderFrame(int x, int y) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setSize(x, y);
		
		// Layout später
		this.setLayout(new GridLayout(0, 2, 10, 10));

		// 1.) Verschiedene Buttons mit Rand
		JButton b1 = new JButton("Tick");
		b1.setBorder(new BevelBorder(BevelBorder.RAISED));
		this.add(b1);

		JButton b2 = new JButton("Trick");
		b2.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.add(b2);

		JButton b3 = new JButton("Track");
		b3.setBorder(BorderFactory.createEtchedBorder()); // Design-Pattern!
		this.add(b3);

		JButton b4 = new JButton("Donald");
		b4.setBorder(new EtchedBorder(Color.blue, Color.yellow));		
		this.add(b4);
		
		// 2.) Ein Tooltip
		b4.setToolTipText("Kopf der Familie");
		b4.setMnemonic(KeyEvent.VK_D);
		
		// 3.) Versuche den Fokus zu bekommen
		b4.requestFocusInWindow();

		
		JTextField t = new JTextField();
		this.add(t);
		
		//KeyListener
		t.addKeyListener(new KeyListen());
		
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		BorderFrame of = new BorderFrame(100, 100);
	}
}