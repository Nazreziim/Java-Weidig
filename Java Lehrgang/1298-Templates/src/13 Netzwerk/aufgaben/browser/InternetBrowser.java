package aufgaben.browser;

import java.io.Console;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class InternetBrowser {

	//private final static String ADRESSE = "http://docs.oracle.com/javase/tutorial/";
	//private final static String ADRESSE = "http://tutzing.de/default.asp?tg=&wid=164&kon=&spk=de&spkg=de&sid=90690052&art=h";
//	private final static String ADRESSE  = "http://sheldonbrown.com/web_sample1.html";
//	private final static String ADRESSE  = "http://www.it-training.fus";
	private final static String ADRESSE  = "http://192.168.4.200";
	

	public static void main(String[] args) {

		// Wurde der URL-String im Programmaufruf vergessen, wird eine
		// Ausnahme vom Typ IllegalArgumentException mit einem eigenen
		// Meldungstext geworfen
		// if (args.length != 1)
		// throw new IllegalArgumentException(
		// "Im Programmaufruf wurde kein URL-String angegeben");

		// JFrame-Komponente erzeugen und zu dieser einen Editor vom Typ
		// der inneren Klasse hinzufügen

		JFrame f = new JFrame();
		f.setTitle("Internet-Browser");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		// f.add(new JScrollPane(new JEditorPanealsBrowser(args[0])));
		f.add(new JScrollPane(new BrowserPanel(ADRESSE)));
		f.setVisible(true);
	}
}
