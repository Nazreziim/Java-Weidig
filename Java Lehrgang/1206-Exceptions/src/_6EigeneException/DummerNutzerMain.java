package _6EigeneException;

public class DummerNutzerMain {

	public static void main(String[] args) {

		// Hm warum wird hier nicht weiter übersetzt?
		DummeAktion dumm = new DummeAktion();

		/**
		 * Diese Exception MUSS behandelt werden. --> Erbt von Exception, ist keine
		 * RuntimeException --> checked Exception
		 * 
		 * Möglichkeit 1: Mit throws bis zur main durchreichen = DUMM! [dazu try / catch entfernen]
		 * 
		 * Möglichkeit 2: try/catch block nutzen.
		 */

		try {
			dumm.dummeAktion();
		} catch (DummerNutzerException e) {
			e.printStackTrace();
		}

	}

}

class DummeAktion {

	public void dummeAktion() throws DummerNutzerException {
		System.out.println("Diese Methode aufzurufen, war eine dumme Idee...");

		// Hier wird die Exception "geworfen"
		throw new DummerNutzerException();

		// Zu diesem Codeabschnitt kommen wir nie.
		// System.out.println("Diese Ausgabe wird niemals jemand zu Gesicht bekommen");
	}
}

class DummerNutzerException extends Exception {

	/**
	 * EINMAL LÖSCHEN und erklären, dass Exception erwartet, dass eine Exception
	 * serializable ist --> Dies bedeutet, dass ich anhand der entsprechenden ID
	 * eine Exception erkennen könnte die Wahrscheihnlichkeit, dass eine SV UID
	 * nochmals gleich generiert wird ist vorhanden! aber sehr gering. Der Grund
	 * hierfür ist, dass diese Exception auch von Außen (Netzwerk) zugreifbar sein
	 * soll und dafür ist die Serialisierung eine Grundvoraussetzung diese eindeutig
	 * identifizieren zu können, da ansonsten z.B. Fehler- / Debuginformationen
	 * verloren gehen können.
	 */
	private static final long serialVersionUID = 7901254489381481183L;

	public DummerNutzerException() {
		// HINWEIS: Einmal über super() fahren um zu gucken warum ich hier jetzt eine
		// Nachricht eingeben kann
		super("Hier muss ein ganz dummer Nutzer am Werk gewesen sein.");
	}

}
