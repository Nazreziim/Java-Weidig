package alt.components.version5_colorchooser.panels;


import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.ProgressMonitor;

import alt.components.version5_colorchooser.models.Model;

/**
 * Klasse für ein Panel mit einem Fortschrittsbalken.
 * Außerdem wird ein ProgressMonitor erstellt, der den Fortschritt nochmal in
 * einer einzelnen Dialogbox ausgibt
 * @author LGerhard
 *
 */
public class ProgressBarPanel extends JPanel implements Observer {
	private Model m;
	private JProgressBar progress;
	private ProgressMonitor monitor;
	
	public ProgressBarPanel(Model m){
		this.m = m;
//		this.m.addObserver(this);
		progress = new JProgressBar(0, 255 + 255 + 255);
		progress.setStringPainted(true);
		progress.setPreferredSize(new Dimension(150,20));
		this.add(progress);
		progress.setForeground(Color.RED);
		monitor = new ProgressMonitor(this, "Helligkeit", "Fortschritt", 0, 255 + 255 + 255);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		progress.setValue(this.m.getRot() + this.m.getGruen() + this.m.getBlau());
		progress.setForeground(new Color(this.m.getRot(), this.m.getGruen(), this.m.getBlau()  ));
		
		monitor.setProgress(this.m.getRot() + this.m.getGruen() + this.m.getBlau());
	
	}
}
