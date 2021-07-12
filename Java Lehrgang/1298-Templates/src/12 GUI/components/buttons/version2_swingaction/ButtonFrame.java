package components.buttons.version2_swingaction;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Menu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class ButtonFrame extends JFrame {

	public ButtonFrame(int x, int y) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setSize(x, y);
		// Layout später
		this.setLayout(new BorderLayout());

		// Erstellen einer Action geht nur mit Hilfe eine Klasse,
		// die Action implementiert. AbstractAction implementiert das Interface,
		// lässt aber die Funktion actionPerformed abstrakt.
		// D.h. beim erstellen muss diese Methode implementiert werden.
		Action saveAction = new AbstractAction("Speichern") {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Der Benutzer moechte speichern.");
			}
		};

		//Der Action werden Eigenschaften über putValue zu geordnet.
		//hier z.B. Accelerator und Mnemonic. Die Funktion erfordert einen Schlüssel,
		//der die Eigenschaft identifiziert und einen Wert.
		
		// Auf Strg-S reagieren
		saveAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(
				KeyEvent.VK_S, InputEvent.CTRL_MASK));
		// Grafik setzen
		saveAction.putValue(Action.LARGE_ICON_KEY, new ImageIcon("./12 GUI/res/save.gif"));
		// Tooltip setzen
		saveAction.putValue(Action.SHORT_DESCRIPTION,
				"Klicken Sie hier, um zu speichern");
		//Buchstabe Alt + S als Mnemonic
		saveAction.putValue(Action.MNEMONIC_KEY, (int)'S' );
		
		//Buchstabe an Index 0 für Mnemonic unterstreichen
		saveAction.putValue(Action.DISPLAYED_MNEMONIC_INDEX_KEY, 0 );
		
		//Menüeintrag erstellen
		JMenu menu = new JMenu("Datei");
		menu.add(saveAction);
		
		//JMenuBar im Frame setzen
		this.setJMenuBar(new JMenuBar());
		//Jetzt kann der Menüeintrag in die Menüleiste geschoben werden
		this.getJMenuBar().add(menu);

		

		// Erzeugen der Buttons
		JButton button = new JButton(saveAction);
		// Button zum Frame hinzu
		this.add(button,BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(saveAction);
		this.add(toolBar,BorderLayout.SOUTH);
		
		// Vergößert Fenster auf benötigten Platz für alle Elemente
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		ButtonFrame of = new ButtonFrame(100, 100);
	}
}