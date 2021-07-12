package components.dialoge.dialog3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class OwnFrame extends JFrame {
	JDialog dialog;

	public OwnFrame(int x, int y) {

	}

	public static void main(String[] args) {
		// �bersicht:
		// http://docs.oracle.com/javase/7/docs/api/index.html?javax/swing/JOptionPane.html

		// Dialog for a simple message
		JOptionPane.showMessageDialog(null, "Wir Kinder aus dem M�wenweg");

		// Dialog for a user input
		JOptionPane.showInputDialog("Bitte Zahl eingeben");

		// Dialog to confirm a choice
		int confirm = JOptionPane.showConfirmDialog(null, "Alles OK?");
		if (confirm == JOptionPane.OK_OPTION) {
			System.out.println("Jupp alles OK");
		}
		// Dialog with different choices
		String[] genderOptions = {"m�nnlich", "weiblich", "keine Ahnung", "�ndert sich st�ndig"};
		String gender = (String) JOptionPane.showInputDialog(null, "Geschlecht", "Bitte das Geschlecht w�hlen (eigenes, nicht gew�nschtes)",

		JOptionPane.QUESTION_MESSAGE, null, genderOptions, genderOptions[1]);
		System.out.println(gender);

		// Customized option dialog
		String[] yesNoOptions = {"Ja", "Nein", "Abbrechen"};
		int n = JOptionPane.showOptionDialog(null, "Ja oder Nein?", // question
				"Ja/Nein/Abbrechen", // title
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, // icon
				null, yesNoOptions, yesNoOptions[0]);
		if (n == JOptionPane.YES_OPTION)
			System.out.println("Ja gew�hlt");
		System.exit(0);
	}
}