package alt.table.version4;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import javax.swing.JDialog;
import javax.swing.JOptionPane;



public class ControlImpl implements Control{

	private Model model;
	private View view;
	
	private int zaehler;
	
	public ControlImpl(Model model, View view) {
		this.model = model;
		this.view = view;
		zaehler=0;
		view.setControl(this);
	}

	public void addString() {
		
		//String eingabe =JOptionPane.showInputDialog("Geben Sie bitte einen String ein");
		//model.addString(eingabe);
		
		model.addString("test"+zaehler, "wert"+zaehler);
		zaehler++;
		
	}

	
}
