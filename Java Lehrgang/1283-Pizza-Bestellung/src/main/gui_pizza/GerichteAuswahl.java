/**
 * 
 */
package gui_pizza;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import pizzaria.Gericht;
import pizzaria.Gerichte;

/**
 * @author user
 *
 */
public class GerichteAuswahl implements OptionsButtons {

    @Override
    public void create(JPanel p) {
	ButtonGroup g = new ButtonGroup();
	List<JRadioButton> mListe = new ArrayList<JRadioButton>();
	Gerichte gerichteAuswahl = new Gerichte(System.getProperty("user.dir") + "\\res\\Gerichte.txt");

	p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

	for (int index = 0; index < gerichteAuswahl.getAnzahlGerichte(); index++) {
	    Gericht gr = gerichteAuswahl.getGericht(index);
	    JRadioButton rb = new JRadioButton(gr.getName());
	    mListe.add(rb);
	    g.add(rb);
	    p.add(rb);
	}
	if ( mListe.size() > 0 ) {
		mListe.get(0).setSelected(true);
	};
	TitledBorder tb = new TitledBorder("Gericht");
	p.setBorder(tb);
    }
}
