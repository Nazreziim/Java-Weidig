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

import pizzaria.Bestellung;
import pizzaria.Extras;

/**
 * @author user
 *
 */
public class ExtrasAuswahl implements OptionsButtons {

    /*
     * (non-Javadoc)
     * 
     * @see gui_pizza.OptionsButtons#create(javax.swing.JPanel)
     */
    @Override
    public void create(JPanel p) {
	ButtonGroup g = new ButtonGroup();
	List<JRadioButton> mListe = new ArrayList<JRadioButton>();
	p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

	for (Extras ex : Bestellung.mExtrasListe) {
	    JRadioButton rb = new JRadioButton(ex.getName());
	    mListe.add(rb);
	    g.add(rb);
	    p.add(rb);
	}
	mListe.get(0).setSelected(true);
	TitledBorder tb = new TitledBorder("Extras");
	p.setBorder(tb);
    }

}
