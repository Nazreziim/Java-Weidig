package templates;

public class Template07KontrollstrukturSwitch {

	public static void main(String[] args) {

		// Deklarationsteil
		// Zufallszahl erzeugen fuer Monate 1-12 erzeugen
		final double SPANNE = 12.0; // von 1 - 12 + 1 => Differenz von min und max Wert + 1
		final double MIN_WERT = 1.0;
		int monat = 1;
		int tage = 0;
		boolean eingabe = true;

		// Eingabeteil-- Erweiterung mit IF
		// Nutzerabfrage?
		if (eingabe) {
			monat = HilfsMeth.readInt("Geben Sie einen Monat ein: ");
		} else {
			monat = (int) (SPANNE * Math.random() + MIN_WERT);
		}

		// Es sind auch Strings fuer die switch-Anweisung erlaubt!
		// Verarbeitung
		String monatsName = "";
		switch (monat) {
		case 1:
			monatsName = "Januar";
			tage = 31;
			break;
		case 3:
		case 5:
		case 7:
			monatsName = "Juli";
			// Ohne break rutscht hier bei Eingabe
			// von 3-12 die Anweisung bis zum
			// nächsten Break --> Monat 3, 5 etc.
			// würden also den monatsName Juli
			// erhalten
		case 8:
			// Bei Monat 8 rutscht man ebenfalls
			// durch. Jedoch wird monatsName
			// nicht zugewiesen
		case 10:
		case 12:
			tage = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			tage = 30;
			break;
		case 2:
			tage = 28;
			break;
		default:
			monatsName = "Nicht existent";
			// Wird zugewiesen wenn keins
			// der Cases zutrifft
		}

		// Ausgabeteil
		if (tage != 0) {
			System.out.println("Der Monat: " + monatsName + " (" + monat + ")" + " hat " + tage + " Tage.");
		} else {
			System.out.println("Ungültige Eingabe (" + monatsName + ")");
		}
	}
}
