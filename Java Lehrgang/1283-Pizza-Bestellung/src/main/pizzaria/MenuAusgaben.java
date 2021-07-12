/**
 * 
 */
package pizzaria;

/**
 * @author Administrator
 *
 */
public class MenuAusgaben 
{
	public static Gericht MenuSorte(Gerichte gerichte)
	{
		int eingabe;
		int anzahlSorten = gerichte.getAnzahlGerichte();
		
		System.out.println("Bitte die Sorte auswählen:");
		System.out.println();
		for (int i = 0; i < anzahlSorten; i++) {
			System.out.printf("%d - %s\n", i + 1, gerichte.getGericht(i)
					.getName());
		}
		eingabe = ReadInt();

		return gerichte.getGericht(eingabe-1);
	}
	
	public static PizzaGroesse MenuGroesse()
	{
		int eingGroesse;
		int i = 1;
		
		// ****************************  MENÜ- Grösse **************************
			
		do {
			i = 1;
			System.out.println("Bitte die Größe auswählen:");
			System.out.println();
			for (PizzaGroesse item : Bestellung.mGroessenListe) {
				System.out.printf("%d - %s\n", i, item.getGroesse());
				i++;
			}
			eingGroesse = ReadInt();
			
		} while (eingGroesse > Bestellung.mGroessenListe.length);
		
		return Bestellung.mGroessenListe[eingGroesse - 1];		
	}
	
	public static Extras MenuExtras()
	{
		int eingExtras;
		int i = 1;
		
		// ****************************  MENÜ- Extras **************************
		
		do {
			System.out.println("Bitte die Extras auswählen:");
			System.out.println();
			i = 1;
			for (Extras item : Bestellung.mExtrasListe) {
				System.out.printf("%d - %s\n", i, item.getName());
				i++;
			}
			eingExtras = ReadInt();
			
		} while (eingExtras > Bestellung.mExtrasListe.length);
		
		return Bestellung.mExtrasListe[eingExtras-1];	
	}

	public static boolean MenuWareMitnahme()
	{
		int eingAbholung;
		// ****************************  MENÜ- Ware holen ********************
		System.out.print("Holen Sie die Ware zur Mitnahme?\n" +
		         "1 - Ja\n" +
		         "2 - Nein\n");

		eingAbholung = ReadInt();
		return (eingAbholung == 1) ? true : false;
	}
	
	public static boolean MenuBereitsKunde()
	{
		int eingKunde;
		// ****************************  MENÜ- bereits Kunde **************************	
		System.out.print("Sind Sie bereits Kunde\n" +
				         "1 - Ja\n" +
				         "2 - Nein\n");
		
		eingKunde = ReadInt();
		return (eingKunde == 1) ? true : false;
	}
	
	public static boolean MenuWeitereBestellung()
	{
		int eingabe;
		// ****************************  MENÜ- bereits Kunde **************************	
		System.out.print("Wollen Sie eine weitere Bestellung tätigen?\n" +
				         "1 - Ja\n" +
				         "2 - Nein\n");
		
		eingabe = ReadInt();
		return (eingabe == 1) ? true : false;
	}
	
	private static int ReadInt()
	{
		int eingabe = -1;
		do {
			try {
				eingabe = tools.StdInput.readInt();
			} catch (java.lang.NumberFormatException e) {
				System.out.println("Bitte nur Zahlen eingeben!");
			}
		} while (eingabe == -1);
		return eingabe;
	}
}
