package alt.components.version5_colorchooser.panels;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import alt.components.version5_colorchooser.models.Model;

/**
 * Dieses Panel enthält verschiedenste Textfelder
 * JTextField = Einzeiliges Textfeld 
 * JFormattedTextField = Einzeiliges Textfeld mit Formatierungsvorgaben 
 * JPasswordField = Einzeilige Eingabe mit verdeckten Zeichen 
 * JTextArea = Mehrzeiliges Textfeld 
 * JEditorPane = Editor-Komponente
 * JTextPane = Spezialisierung der Editor-Komponente
 * 
 * @author LGerhard
 * 
 */
public class TextControllerPanel extends JPanel implements Observer {
	private Model m;
	private JTextField inputRot;
	private JPasswordField inputGreen;
	private JTextField inputBlue;

	public TextControllerPanel(Model model) {
		this.m = model;
//		this.m.addObserver(this);
		this.setLayout(new GridLayout(0, 2));
		
		//Interne Action-Listener
		/////////////////////////
		ActionListener redActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					m.setRot(Integer.parseInt(inputRot.getText()));
				} catch (Exception ex) {

				}
			}
		};

		ActionListener greenActionListener = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				try {
					// An Eingabe kommt man über getPassword, was ein char[] liefert
					m.setGruen(Integer.parseInt(new String(inputGreen.getPassword())));
				} catch (Exception ex) {					
				}
			}
		};
		
		ActionListener blueActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.setBlau(Integer.parseInt(inputBlue.getText()));
			}
		};
		
		
		//Komponenten erstellen
		///////////////////////
		JLabel redL = new JLabel("Red:");
		redL.setHorizontalAlignment(JLabel.CENTER);
		JLabel greenL = new JLabel("Green:");
		greenL.setHorizontalAlignment(JLabel.CENTER);
		JLabel blueL = new JLabel("Blue:");
		blueL.setHorizontalAlignment(JLabel.CENTER);
		
		// Erstellen eines Textfeldes mit 20 Zeichen
		inputRot = new JTextField(this.m.getRot() + "", 10); 		
		inputRot.addActionListener(redActionListener);// ActionListener reagiert, wenn Text mit Enter bestätigt wird

		// Erstellen eines Passwordfeldes mit 15 Zeichen
		inputGreen = new JPasswordField(10);		
		inputGreen.setEchoChar('#');// Zeichen für Shadowing
		inputGreen.setText(m.getGruen() + "");
		inputGreen.addActionListener(greenActionListener);
		
		// Validierende Eingabefelder:Möglichkeit zur Formatierung und Validierung der Daten.
		// Gültige Werte bestimmt ein im Konstruktor übergebenes
		// java.text.Format-Objekt
		inputBlue = new JFormattedTextField(new DecimalFormat("#"));
		inputBlue.addActionListener(blueActionListener);
		
		// Komponenten hinzufügen
		this.add(redL);
		this.add(inputRot);
		this.add(greenL);
		this.add(inputGreen);
		this.add(blueL);
		this.add(inputBlue);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.inputBlue.setText(m.getBlau()+"");
		this.inputGreen.setText(m.getGruen()+"");
		this.inputRot.setText(m.getRot()+"");
	}

}
