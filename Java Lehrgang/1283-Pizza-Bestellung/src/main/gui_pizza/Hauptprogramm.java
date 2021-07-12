/**
 * 
 */
package gui_pizza;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author user
 *
 */
public class Hauptprogramm {

    /**
     * @param args
     */
    public static void main(String[] args) {
	JFrame frame = new JFrame("Pizza Bestellung");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setMinimumSize(new Dimension(400, 300));
	frame.setLocation(300, 400);

	BestellungenTabelle table = new BestellungenTabelle();
	JScrollPane topPanel = new JScrollPane(table);
	topPanel.setPreferredSize(new Dimension(200, 150));
	frame.getContentPane().add(topPanel, BorderLayout.NORTH);

	JPanel mainPanel = new JPanel();
	frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

	OptionsButtons auswahlListe[] = new OptionsButtons[] { new GerichteAuswahl(), new ExtrasAuswahl(),
		new PizzaGroessenAuswahl(), new AbholungAuswahl(), new KundeAuswahl() };

	mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

	for (OptionsButtons auswahl : auswahlListe) {
	    JPanel p = new JPanel();
	    mainPanel.add(p);
	    auswahl.create(p);
	}

	frame.pack();
	frame.setVisible(true);

    }
}
