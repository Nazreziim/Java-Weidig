 package alt.components.version5_colorchooser.panels;


import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import alt.components.version5_colorchooser.models.Model;

/**
 * Das ist eine (relativ simple) Klasse mit drei Slidern zum Anpassen der RGB-Werte
 * @author LGerhard
 *
 */
public class SliderPanel extends JPanel implements Observer {
	// Attribute
	private Model m;
	private JSlider sliderRot; 
	private JSlider sliderGr�n;
	private JSlider sliderBlau ;
	
	
	private class SliderChangeListener implements ChangeListener{
		@Override
		/**
		 * Wird ausgel�st, wenn sich Regler ver�ndert
		 */
		public void stateChanged(ChangeEvent e) {
			//Abfragen m�ssen gemacht werden, da nur die gesetzt werden, die ge�ndert wurden.
			//Problem �ndert man einen Wert informiert Model wieder Observer, worauf update() aufgerufen wird.
			//Es werden wieder ChangeEvents ausgel�st, Schleife.
			if(m.getBlau() != sliderBlau.getValue()){
				m.setBlau(sliderBlau.getValue());
			}
			else if(m.getGruen() != sliderGr�n.getValue()){
				m.setGruen(sliderGr�n.getValue());
			}
			else if(m.getRot() != sliderRot.getValue()){
				m.setRot(sliderRot.getValue());	
			}
		}
		
	}
	
	
	public SliderPanel(Model m){
		this.m = m;
//		m.addObserver(this);
		
		this.setLayout(new GridLayout(0,2,0,50));
		
		JLabel rotL = new JLabel("Rot:");
		rotL.setHorizontalAlignment(JLabel.CENTER);
		JLabel gruenL = new JLabel("Gr�n:");
		gruenL.setHorizontalAlignment(JLabel.CENTER);
		JLabel blauL = new JLabel("Blau:");
		blauL.setHorizontalAlignment(JLabel.CENTER);
		
		
		//Zahlenbereich von 0 bis 255, Startwert abh�ngig vom Model
		sliderRot = new JSlider(0,255,this.m.getRot());
		sliderGr�n = new JSlider(0,255,this.m.getGruen());
		sliderBlau = new JSlider(0,255,this.m.getBlau());
		
		
		//Einschalten, dass Ticks gezeichnet werden, vorher m�ssen aber Abst�nde gesetzt werden.
		sliderRot.setPaintTicks(true);
		sliderGr�n.setPaintTicks(true);
		sliderBlau.setPaintTicks(true);
		
		//Setzen der Tickabst�nde f�r kleine Striche
		sliderRot.setMinorTickSpacing(5);
		sliderGr�n.setMinorTickSpacing(5);
		sliderBlau.setMinorTickSpacing(5);
		
		//Setzen der Tickabst�nde f�r gro�e Striche
		sliderRot.setMajorTickSpacing(50);
		sliderGr�n.setMajorTickSpacing(50);		
		sliderBlau.setMajorTickSpacing(50);
		
		//Man kann auch erlauben, dass Striche nummeriert werden
		sliderRot.setPaintLabels(true);
		
		//Spur auf dem der Regler l�uft.
		sliderRot.setPaintTrack(false);
		
		//ChangeListener zu den Slidern hinzuf�gen, siehe unten.
		SliderChangeListener h = new SliderChangeListener();
		
		sliderRot.addChangeListener(h);
		sliderGr�n.addChangeListener(h);
		sliderBlau.addChangeListener(h);
		
		this.add(rotL);
		this.add(sliderRot);
		
		this.add(gruenL);
		this.add(sliderGr�n);
		
		this.add(blauL);
		this.add(sliderBlau);
	}
	@Override
	public void update(Observable o, Object arg) {
		sliderRot.setValue(m.getRot());
		sliderGr�n.setValue(m.getGruen());
		sliderBlau.setValue(m.getBlau());
	}
	
	

}
