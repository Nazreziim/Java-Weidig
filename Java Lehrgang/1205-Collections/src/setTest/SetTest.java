package setTest;

/**
** Bei Sets (Mengen) duerfen keine doppelten Elemente enthalten sein.
** Beim Versuch ein bereits vorhandenes Element hinzu zufuegen, wird
** das bleibt das alte Element vorhanden. 
** Es gibt nur einen einfachen Iterator, kein ListIterator
** Die Objekte im Set duerfen nicht veraendert werden!
*/
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

public class SetTest{
	
	public static void hinzufuegen(Set<String> s){
		System.out.println("Klasse: " + s.getClass().getSimpleName());
		
		// add() hinzufuegen eines nicht vorhandenen Element liefert true  zurueck.
		// add() hinzufuegen eines vorhandenen Element liefert false  zurueck (keine
		//       Aenderugn im Datenbestand.     
    
		s.add("Willi");
		s.add("Bernd");
		s.add("Max");
		s.add("Michi");
		System.out.println(" Element schon vorhanden?  " + s.contains("Willi1"));
		System.out.println(" Element hinzugefuegt? " + s.add("Willi1"));
		
		System.out.println(" Element schon vorhanden?  " + s.contains("Willi1"));
		System.out.println(" Element hinzugefuegt?  " + s.add("Willi1"));
	}
	
	public static void main(String[] args){
		// HashSet: eine unsortierte Menge, keine Nebenlaeufigkeit, schnelle Zugriffszeit
		// (kann sortiert sein)
		HashSet<String> namen = new HashSet<String>();
		hinzufuegen(namen);
	
		System.out.println("\nAusgabe " + namen);
	
		
		// TreeSet: schnelle Zugriffszeit, Werte liegen sortiert vor. Schoen fuer Ausgaben
		// (balancierte Binaerbaeume)
		// Objekte muessen sortierbar sein, Comparalbe() implementieren,
		// ansonsten gibt es einen Fehler!
		// TreeSet nutzt nicht equals sondern compareTo()
		// TreeSet besitzt auch NavigableSet und SortSet-Schnittstelle
		TreeSet<String> namen2 = new TreeSet<String>();
		
		hinzufuegen(namen2);
	
		System.out.println("\nAusgabe " + namen2);                       
	
		
	// removeAll(Menge) bildet eine Differenzmenge
	// retainAll(Menge) bildet eine Schnittmenge
	// Anmerkung: Rueckgabetyp ist boolean nicht die entsprechende Menge
	// wird immer auf das entsprechende Objekt angewandt!
	
	}
}