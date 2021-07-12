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
	private JSlider sliderGrün;
	private JSlider sliderBlau ;
	
	
	private class SliderChangeListener implements ChangeListener{
		@Override
		/**
		 * Wird ausgelöst, wenn sich Regler verändert
		 */
		public void stateChanged(ChangeEvent e) {
			//Abfragen müssen gemacht werden, da nur die gesetzt werden, die geändert wurden.
			//Problem ändert man einen Wert informiert Model wieder Observer, worauf update() aufgerufen wird.
			//Es werden wieder ChangeEvents ausgelöst, Schleife.
			if(m.getBlau() != sliderBlau.getValue()){
				m.setBlau(sliderBlau.getValue());
			}
			else if(m.getGruen() != sliderGrün.getValue()){
				m.setGruen(sliderGrün.getValue());
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
		JLabel gruenL = new JLabel("Grün:");
		gruenL.setHorizontalAlignment(JLabel.CENTER);
		JLabel blauL = new JLabel("Blau:");
		blauL.setHorizontalAlignment(JLabel.CENTER);
		
		
		//Zahlenbereich von 0 bis 255, Startwert abhängig vom Model
		sliderRot = new JSlider(0,255,this.m.getRot());
		sliderGrün = new JSlider(0,255,this.m.getGruen());
		sliderBlau = new JSlider(0,255,this.m.getBlau());
		
		
		//Einschalten, dass Ticks gezeichnet werden, vorher müssen aber Abstände gesetzt werden.
		sliderRot.setPaintTicks(true);
		sliderGrün.setPaintTicks(true);
		sliderBlau.setPaintTicks(true);
		
		//Setzen der Tickabstände für kleine Striche
		sliderRot.setMinorTickSpacing(5);
		sliderGrün.setMinorTickSpacing(5);
		sliderBlau.setMinorTickSpacing(5);
		
		//Setzen der Tickabstände für große Striche
		sliderRot.setMajorTickSpacing(50);
		sliderGrün.setMajorTickSpacing(50);		
		sliderBlau.setMajorTickSpacing(50);
		
		//Man kann auch erlauben, dass Striche nummeriert werden
		sliderRot.setPaintLabels(true);
		
		//Spur auf dem der Regler läuft.
		sliderRot.setPaintTrack(false);
		
		//ChangeListener zu den Slidern hinzufügen, siehe unten.
		SliderChangeListener h = new SliderChangeListener();
		
		sliderRot.addChangeListener(h);
		sliderGrün.addChangeListener(h);
		sliderBlau.addChangeListener(h);
		
		this.add(rotL);
		this.add(sliderRot);
		
		this.add(gruenL);
		this.add(sliderGrün);
		
		this.add(blauL);
		this.add(sliderBlau);
	}
	@Override
	public void update(Observable o, Object arg) {
		sliderRot.setValue(m.getRot());
		sliderGrün.setValue(m.getGruen());
		sliderBlau.setValue(m.getBlau());
	}
	
	

}
