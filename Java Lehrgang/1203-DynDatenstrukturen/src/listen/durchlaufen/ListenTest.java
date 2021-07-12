package listen.durchlaufen;

import java.util.Iterator;

public class ListenTest {

	public static void main(String[] args) {
		Liste l  = new Liste();
		
		l.add(9);
		l.add(7);
		l.add(5);
		l.add(3);
		l.add(1);
		l.add(0);
		
		l.ausgabe();
		
		System.out.println();
		
		/*
		 * 1. Moeglichkeit
		 */
		for (ListenElement element : l){
			System.out.println(element);
			//element.setInhalt(1);
		}
		
		System.out.println();
		/*
		 * 2. Moeglichkeit
		 */
		Iterator<ListenElement> it = l.iterator();
		
		while (it.hasNext()){
			System.out.println(it.next());
		}
		
		/*
		 * 3. Moeglichkeit  ohne Iterator/Iterable - Schnittstelle 
		 *    3.1 Methode in Klasse Liste implementieren, die ueber 
		 *        alle Elemente laeuft und eine Schnittstellen-Methode ausfuehrt.
		 *        
		 *    3.2 Diese Methode hat einen Uebergabeparameter von einem Interface: Aktion
		 *        Dieses Interface implementiert eine Schnittstellen-Methode mit Parameter
		 *        des Inhalt-Typs der Liste (verwaltetes Element: hier int).
		 *        
		 *    3.3 Aktion-Methode schreiben, dazu vom Interface: Aktion ableiten
		 *        und konkrete Methode implementieren. 
		 *        
		 *    3.4 Beim Methodenaufruf der Liste, als Parameter ein Aktions-Objekt uebergeben
		 *       
		 */
		
		// konkrete Aktion: Ausgabe aller Wert in einem anderen Format:
		l.besucheAlleElemente(new AktionAusgabeEinfach());
		// konkrete Aktion: Berechnen der Summe alle Elemente
		System.out.println("Die Summe alle Werte betraegt: " + l.besucheAlleElemente(new AktionSumme()));
		// konkrete Aktion: Maximalwert der Liste zurueckgeben.
		System.out.println("Maximalwert ist: " + l.besucheAlleElemente(new AktionGroesstesElement()));
		
	}

}
