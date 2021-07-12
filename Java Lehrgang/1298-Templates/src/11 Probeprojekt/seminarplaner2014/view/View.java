package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


/**
 * @author LGerhard
 * @version 1.0
 * @created 22-Jul-2014 11:56:57
 */
public class View {


	/**
	 * Diese Methode fordert den Nutzer mit einer waehlbaren Nachricht und einem folgenden Leerzeichen dazu auf einen
	 * Integer einzugeben und liefert diesen als return-Wert zurueck.
	 * @param nachricht Die auszugebende Meldung
	 * @return Der eingelesene Integer
	 */
	public static int readInt(String nachricht){
		int erg = 0;
		boolean einlesenOk = false;
		// Die Schleife wird erst verlassen, wenn eine korrekte Antwort eingelesen wurde
		while (!einlesenOk) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print(nachricht+" ");
				erg = Integer.parseInt(br.readLine());
				einlesenOk = true;
			} catch (IOException e) {
				
			}
		}
		return erg;
	}


	/**
	 * Diese Methode fordert den Nutzer mit einer waehlbaren Nachricht und einem folgenden Leerzeichen dazu auf einen
	 * String einzugeben und liefert diesen als return-Wert zurueck.
	 * @param nachricht Die auszugebende Meldung
	 * @return Der eingelesene String
	 */
	public static String readString(String nachricht){
		String erg = null;
		boolean einlesenOk = false;
		// Die Schleife wird erst verlassen, wenn eine korrekte Antwort eingelesen wurde
		while (!einlesenOk) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print(nachricht+" ");
				erg = br.readLine();
				einlesenOk = true;
			}
			catch (IOException e) {}
			
		}
		return erg;
	}

	/**
	 * Stellt dem Nutzer die Frage aus der nachricht und gibt true zurück, wenn die
	 * Entscheidung "ja" getroffen wurde, sonst false. Als Eingaben sind "Ja", "j", 
	 * "Nein" und "n" zulaessig (Gross- und Kleinschreibung ist nicht relevant!
	 * 
	 * @param nachricht
	 * @return boolean true, falls "ja", nein sonst
	 */
	public static boolean showEntscheidung(String nachricht){
		boolean erg = false;
		boolean einlesenOk = false;
		// Die Schleife wird erst verlassen, wenn eine korrekte Antwort eingelesen wurde
		while (!einlesenOk) { 
			try {
				System.out.println(nachricht);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String eingelesen = br.readLine();
				// Zulässige Eingaben sind: "JA" und "J" (in allen Varianten von Groß- und Kleinschreibung
				if (eingelesen.toLowerCase().equals("ja") || eingelesen.toLowerCase().equals("j") ) {
					erg = true;
					einlesenOk = true;
				} 
				if (eingelesen.toLowerCase().equals("nein") || eingelesen.toLowerCase().equals("n") ) {
					erg = false;
					einlesenOk = true;
				}
			} catch (IOException e) {
				// NICHTS TUN!
			}
		}
		return erg;
	}

	/**
	 * Diese Methode gibt eine uebergebene Nachricht auf der Konsole aus
	 * @param nachricht
	 */
	public static void show(String nachricht) {
		System.out.println(nachricht);
	}
	
	
	/**
	 * Gibt eine Liste von Strings aus. Dabei erfolgt eine automatische Nummerierung
	 * der Listenelemente von 1 beginnend
	 * 
	 * @param list Eine Liste von Strings, die ausgegeben werden sollen. Das erste Element
	 * in der Liste ist die Überschrift für die Ausgabe.
	 */
	public static void showListe(List<String> list){
		if (!list.isEmpty()) {
			// Überschrift ausgeben und unterstreichen
			System.out.println(list.get(0));
			for (int i=0; i < list.get(0).length(); i++) {
				System.out.print("=");
			}
			System.out.println("");
			
			// Restliche Elemente der Liste mit vorgestellter Nummerierung ausgeben
			for (int i=1; i < list.size(); i++) {
				System.out.println(i + " : " + list.get(i));
			}			
		}		
	}

	
	/**
	 * Diese Methode zeigt ein Auswahlmenü an, dessen Elemente über eine String-Liste übergeben
	 * werden. Das erste Element der Liste ist die Überschrift. Danach wird vom Nutzer eine 
	 * Menüauswahl (als Integer) eingelesen und überprüft
	 * @param menuItems eine Stringliste
	 */
	public static int showMenu(List<String> menuItems){
		int auswahl = -1;  // -1 = ungültiger Wert!
		
		// Liste ausgeben
		showListe(menuItems);

		// Eingabe der Menueauswahl und Überprüfung
		if (menuItems.size() >= 2) {
			boolean eingabeOK = false;
			while (!eingabeOK) {
				int eingeleseneWahl = readInt("Bitte treffen Sie eine Menueauswahl (1 - " + (menuItems.size()-1) + "): ");
				if (eingeleseneWahl >= 1 && eingeleseneWahl <= (menuItems.size()-1)) { // Eingabe korrekt!
					eingabeOK = true;
					auswahl = eingeleseneWahl;
				}
			}
		}

		return auswahl;
	}
	
	
}//end View