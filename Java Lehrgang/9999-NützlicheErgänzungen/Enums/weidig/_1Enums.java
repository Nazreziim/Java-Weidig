/** Erstelldatum: 27-05-2021 **/

package weidig;

import java.util.Arrays;

public class _1Enums {
	public static void main(String[] args) {
		System.out.println("-------------------------------------------------------");
		System.out.println("------------- 1. Zugriffsm�glichkeiten ----------------");
		System.out.println("-------------------------------------------------------");
		/* 1. Zugriffsm�glichkeiten */
		// ACHTUNG: Das hier geht nicht. Es handelt sich um ein "Enumerations Objekt"
		// String montag = Wochentage1.Montag;
		String schtring = Wochentage.Montag.toString();
		System.out.println(schtring);

		// Gibt den Namen der Konstante aus "Montag"
		System.out.println(Wochentage.Montag);

		// Zeigt mir alle m�glichen Konstanten an
		System.out.println(Arrays.toString(Wochentage.values()));

		// Gibt mir die Nr. der Stelle an an der ich mein Enum gesetzt habe [von 0
		// beginnend]
		System.out.println(Wochentage.Montag.ordinal());

		System.out.println("\n-------------------------------------------------------");
		System.out.println("-------- 2. Erweiterte Nutzungsm�glichkeiten ----------");
		System.out.println("-------------------------------------------------------");
		/* 2. Erweiterte Nutzungsm�glichkeiten */

		// Ruft eigene Methoden zur Konstanten auf
		System.out.println(Wochentage.Montag.getInhalt());

		System.out.println(Wochentage.Dienstag.getTagNummer());

		// EIGENE GESCHRIEBENE METHODE: Gebe mir den Tag anhand des Indexes aus
		System.out.println(Wochentage.getByIndex(-1)); // Nicht gefunden = null

		System.out.println("\n-------------------------------------------------------");
		System.out.println("---------------- 3. Anwendungsbeispiel ----------------");
		System.out.println("-------------------------------------------------------");
		// ANWENDUNGSBEISPIEL IM SWITCH
		// Zufallszahl zwischen 0 und 6 [7 Konstanten = Indexe 0 bis 6]
		int randomIndex = (int) (Math.random() * 6);

		Wochentage tag = Wochentage.getByIndex(randomIndex);
		switch (tag) {
		case Montag:
			System.out.println("Noch so lange?");
			break;

		case Dienstag:
			System.out.println("Immernoch zu lange.");
			break;

		case Mittwoch:
			System.out.println("Halbzeit");
			break;
		case Donnerstag:
			System.out.println("Fast geschafft.");
			break;
		case Freitag:
			System.out.println("Hoch die H�nde Wochenende!");
			break;
		case Samstag:
			System.out.println("Party Hard!");
			break;
		case Sonntag:
			System.out.println("Schei�e morgen gehts weiter.");
			break;

		default:
			System.out.println("Wo bin ich?");
			break;

		}

	}
}

enum Wochentage {

	/*
	 * Deklaration der verschiedenen M�glichkeiten der Enumeration. Jede Konstante,
	 * getrennt mit " , ", stellt eine m�glich nutzbare Enum Konstante dar. Nur
	 * diese sind zul�ssig verwendbar.
	 */

	Montag("Der Tag Montag"), Dienstag("Der Tag Dienstag", 2), Mittwoch, Donnerstag, Freitag, Samstag, Sonntag;

	/*
	 * Erweiterung (Zus�tzliche Werte neben Konsante schreiben): - Sobald ich die
	 * Konstante durch Parameter erg�nze muss ich einen Konstruktor daf�r anlegen -
	 * M�chte ich auf den hinterlegten Inhalt zugreifen muss ich diese Werte
	 * zwischenspeichern
	 */

	private String inhalt;
	private int tagNummer;

	// Konstruktoren
	private Wochentage(String inhalt) {
		this.inhalt = inhalt;
	}

	private Wochentage() {
	}

	private Wochentage(String inhalt, int tagNummer) {
		this.tagNummer = tagNummer;
	}

	// Eigene Methoden
	public static Wochentage getByIndex(int index) {
		Wochentage gesuchterTag = null;
		Wochentage[] alleTage = Wochentage.values();

		for (Wochentage tag : alleTage) {
			if (tag.ordinal() == index) {
				gesuchterTag = tag;
			}
		}

		return gesuchterTag;
	}

	// Getter und Setter
	public String getInhalt() {
		return inhalt;
	}

	public int getTagNummer() {
		return tagNummer;
	}

}