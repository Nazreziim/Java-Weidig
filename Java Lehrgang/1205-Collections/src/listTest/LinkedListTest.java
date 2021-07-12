package listTest;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		// 1.) eine neue Liste mit Standard-Konstruktor anlegen
		LinkedList<String> liste = new LinkedList<String>();
		
		// nur zusaetzliche Methoden behandeln,
		liste.addFirst("Peter");
		liste.addFirst("Max");
		liste.addLast("Sepp");
		liste.addLast("Fritz");
		
		System.out.println(liste);
		
		System.out.println("Gebe erstes Element in der Liste (nicht entfernt) " + liste.getFirst());
		System.out.println(liste);
		
		System.out.println("Gebe letztes Element in der Liste (nicht entfernt) " + liste.getLast());
		System.out.println(liste);
		
		System.out.println("Entfernt erstes Element aus der Liste " + liste.removeFirst());
		System.out.println(liste);
		System.out.println("Entfernt letztes Element aus der Liste " + liste.removeLast());
		System.out.println(liste);
		System.out.println();
		
		// 2. eine neue Liste anlegen mit Inhalt.
		System.out.println("Neue Liste mit Inhalt angelegt");
		LinkedList<String> liste2 = new LinkedList<String>(liste);
		System.out.println(liste);
		
		// iterate through list descending
		Iterator<String> it = liste2.descendingIterator();
		
		while ( it.hasNext()){
			System.out.println("<= " + it.next());
		}
		System.out.println();
		
		
	}

}
