/**
 * 
 */
package gui_pizza;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 * @author user
 *
 */
class AbholungAuswahl implements OptionsButtons {

    /*
     * (non-Javadoc)
     * 
     * @see gui_pizza.OptionsButtons#create(javax.swing.JPanel)
     */
    @Override
    public void create(JPanel p) {
	ButtonGroup g = new ButtonGroup();
	List<JRadioButton> mListe = new ArrayList<JRadioButton>();
	String auswahl[] = new String[] { "Ja", "Nein" };

	for (String s : auswahl) {
	    JRadioButton rb = new JRadioButton(s + "     ");
	    mListe.add(rb);
	    g.add(rb);
	    p.add(rb);
	}

	mListe.get(0).setSelected(true);
	TitledBorder tb = new TitledBorder("Selbstabholung");
	p.setBorder(tb);
    }

}
