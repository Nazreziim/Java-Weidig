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
import pizzaria.PizzaGroesse;

/**
 * @author user
 *
 */
public class PizzaGroessenAuswahl implements OptionsButtons {

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

	for (PizzaGroesse gr : Bestellung.mGroessenListe) {
	    JRadioButton rb = new JRadioButton(gr.getGroesse());
	    mListe.add(rb);
	    g.add(rb);
	    p.add(rb);
	}
	mListe.get(0).setSelected(true);
	TitledBorder tb = new TitledBorder("Grössen");
	p.setBorder(tb);
    }
}
