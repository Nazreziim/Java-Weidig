/**
 * 
 */
package pizzaria;

/**
 * @author Administrator
 *
 */
public class Hauptprogramm {

	/**
	 * Programm zur Bestellung eines Gerichts.
	 * @param args
	 */
	public static void main(String[] args)
	{
		int anzahlBestellungen = 0;
		boolean kunde = false;
		boolean wareAbholen = false;
		
		// *******  Einlesen der Gerichte  aus der Text-Datei: Sorten.txt in Gerichte *****
		Gerichte gerichteAuswahl = new Gerichte(System.getProperty("user.dir") + "\\res\\Gerichte.txt");
		
		// *******  Einlesen der Bestellung aus der Text-Datei: Pizza.txt in Bestellungen*********
		System.out.println("Übersicht - Bestellungen -");
		Bestellungen bestellungen = new Bestellungen(System.getProperty("user.dir") + "\\res\\Bestellungen.txt");
		bestellungen.AusgabeDerBestellungen();
			
		do {
			// Benutzer-Menü Sorten erstellen
			Gericht auswahlGericht = MenuAusgaben.MenuSorte(gerichteAuswahl);
			if (auswahlGericht != null) {
				// Benutzer-Menü Größe erstellen	
				PizzaGroesse groesse = MenuAusgaben.MenuGroesse();

				// Benutzer-Menü Extras erstellen
				Extras extras = MenuAusgaben.MenuExtras();

				if ( anzahlBestellungen == 0 )
				{
					// Benutzer-Menü Warenmitnahme	
					wareAbholen = MenuAusgaben.MenuWareMitnahme();
	
					// Benutzer-Menü Kunde erstellen
					kunde = MenuAusgaben.MenuBereitsKunde();
				}
				// Erstellung einer Bestellung			
				Bestellung eineBestellung = new Bestellung(auswahlGericht,
						groesse, extras, wareAbholen, kunde);

				// Endpreis der Bestellungen berechnen
				eineBestellung.Berechne();

				// Bestellung in Bestellungen hinzufügen
				bestellungen.Add(eineBestellung);

				System.out.println("Ihre Bestellung wurde aufgenommen:");
				System.out.println(eineBestellung.getAusgabeBestellung());
				anzahlBestellungen++;
			} else {
				System.out.println("Ihre Bestellung ist fehlgeschlagen!\nVersuchen Sie es erneut!");
			}
			
		} while (MenuAusgaben.MenuWeitereBestellung());
		
		// Bestellungen in Datei Pizza.txt wegschreiben.
		bestellungen.SchreibenBestellungen(System.getProperty("user.dir") + "\\res\\Bestellungen.txt");
		// Programmende.
		bestellungen.AusgabeDerBestellungen(true);
		System.out.println("Bestellungen gesichert und \nProgramm beendet.");
		System.out.println("Press any Key ...");
		tools.StdInput.readString();
	}
}
