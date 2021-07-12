package iteratorComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


import setTest.Person;

public class IteratorComperator {

	public static void ArrayListIterator(){
        ArrayList<String> liste = new ArrayList<String>();
		
		for(int i = 0; i < 10; i++) {
			liste.add("Objekt " + i);
		}
		
		// toString-Methode der Klasse
		System.out.println(liste);

		
		// 1.) Foreach nutzen fuers iterieren
		// funktioniert, da Klasse Iterable-Interface besitzt.
		for( String name : liste){
			System.out.println(name);
		}
		System.out.println();
		
		
		System.out.println("Jedes zweite Element entfernen.");
		// 2.) Standard-Iterator benutzen
		Iterator<String> it = liste.iterator();
		
		int i=0;
		while(it.hasNext()) {
			
			System.out.println(it.next());
			
			if (i % 2 == 0) {
				it.remove();
			}
			
			System.out.println(liste);
			i++;
		}
		
		System.out.println();
		
		// 3.) Eigenen Iterator benutzen
		System.out.println("----------------------------------");
		System.out.println("Gibt jedes zweite Element aus.");
		StepOverIterator<String> it2 = new StepOverIterator<String>(liste);
		
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		
		ArrayListIterator();
		System.out.println();
		ArrayListComperator();
	}


	private static void ArrayListComperator() {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		

		for (int i = 0; i < 10; i++){
			liste.add((int) (Math.random() * 100));
		}
		System.out.println(liste);
		
		
		liste.sort(Collections.reverseOrder());
		System.out.println(liste);
		
		// aufsteigende Reihenfolge
		liste.sort(null);
		System.out.println(liste);
		
		Collections.sort(liste);
		System.out.println(liste);
		
		
		ArrayList<Mensch> listePers = new ArrayList<Mensch>();
		
		
		listePers.add(new Mensch("Lars","Gerhard", 30));
		listePers.add(new Mensch("Daniel","Borkowitz", 35));
		listePers.add(new Mensch("Ruediger","Huesch",  55));
		
		
		System.out.println(listePers);
		
		// braucht Interface Comparable
		// default Implementierung in Klasse nach Nachname und Vorname
		System.out.println("sortiert nach Nachname, Vorname - aufsteigend -");
		Collections.sort(listePers);
		System.out.println(listePers);
		System.out.println();
		
		System.out.println("sortiert nach Nachname, Vorname - absteigend -");
		listePers.sort(Collections.reverseOrder());
		System.out.println(listePers);
		System.out.println();
		
		System.out.println("sortiert nach Alter - aufsteigend -");
		listePers.sort(new ComparatorAlter());
		System.out.println(listePers);
		System.out.println();
		
		System.out.println("sortiert nach Alter - absteigend -");
		listePers.sort(Collections.reverseOrder(new ComparatorAlter()));
		System.out.println(listePers);
		System.out.println();
		
		
	}

}
