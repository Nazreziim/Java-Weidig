/**
 * 
 */
package gui_pizza;

import java.awt.Dimension;

import javax.swing.JTable;

/**
 * @author user
 *
 */
public class BestellungenTabelle extends JTable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private final static String cSpaltenNames[] = { "Gericht", "Preis" };

    BestellungenTabelle() {
	super(new BestellungenTableMode(System.getProperty("user.dir") + "\\res\\Bestellungen.txt"));
	this.setPreferredSize(new Dimension(200, 150));
    }

}
