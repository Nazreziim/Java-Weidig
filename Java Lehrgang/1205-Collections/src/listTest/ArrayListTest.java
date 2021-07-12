package listTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListTest {

	public static void main(String[] args) {
		// 1.) Erzeugen einer ArrayList mit Default-Konstruktor
		// ArrayList<int> intList; geht nur fuer Referenztypen, K E I N E  primitiven Datentypen
		ArrayList<Integer> intListe = new ArrayList<Integer>();
		
		// hinten einfuegen
		for (int i = 0; i < 10; i++){
			intListe.add(i);
		}
		
		// vorne einfuegen
		for (int i = 0; i < 10; i++){
			intListe.add(0,i);
		}
		
		// Ausgabe-Methode toString()
		System.out.println(intListe);
		//Einzelelemente ausgeben
		for ( int wert : intListe){
			System.out.println("=> " + wert);
		}
		
		System.out.println();
		System.out.println("neue Liste mit vorhandener Liste anlegen.");
		// 2.) neue Liste anlegen mit Inhalt
		ArrayList<Integer> intListe2 = new ArrayList<Integer>(intListe); 
		
		System.out.printf("Die Liste besitzt %2d Elemente.\n", intListe2.size());
		
		//Einzelelemente ausgeben
		for ( Integer wert : intListe2){
			System.out.println("==> " + wert);
		}
		
		System.out.println();
		System.out.println("neue Liste anlegen mit Vorgabe des vorreservierten Speichers.");
		// 3.) neue Liste anlegen mit Vorgabe Speicher
		ArrayList<Integer> intListe3 = new ArrayList<Integer>(100); 
		
		if (intListe3.isEmpty()){
			System.out.println("Die Liste besitzt keine Elemente");
		}
		
		// Werte hinzufuegen
		intListe3.addAll(intListe);
		System.out.printf("Die Liste besitzt %2d Elemente.\n", intListe3.size());
		
		System.out.println(intListe3);
		
		// Zugriff auf letztes Element in der Liste
		System.out.println(intListe3.get(intListe3.size()-1));
		intListe3.set(intListe3.size()-1, 100);
		System.out.println(intListe3.get(intListe3.size()-1));
		
		
		System.out.println(intListe3);
		
		// suchen eines Elementes
		if (intListe3.contains(5) ){
			System.out.println("Die Zahl 5  wurde gefunden an Position: " + intListe3.indexOf(5) );
		}
		
		System.out.println("Die Zahl 5 wurde auch an Position: " + intListe3.lastIndexOf(5) + " gefunden.");
		
		
		// suchen einer Auswahl an Werten 
		if (intListe3.containsAll(Arrays.asList( 3, 5, 6 )) ){
			System.out.println("Die Zahlen 3, 5, 6 wurden gefunden.");
		}
		else{
			System.out.println("Die Zahlen wurden nicht gefunden.");
		}
			
		
		System.out.printf("Die Liste besitzt %2d Elemente.\n", intListe3.size());
		System.out.println(intListe3);
		
		// entfernt nur ein Element, bricht danach ab (equals). (Duplikate von Werten sind moeglich) 
		System.out.println("Eine 5 entfernt?");
		intListe3.remove(5);
		System.out.println("Hat die 4 entfernt, Zahl wird als Index interpretiert.");
		System.out.println(intListe3);
		
		System.out.println("Versuchen wir es nochmals eine 5 zu entfernen!");
		intListe3.remove(Integer.valueOf(5));
		
		System.out.println(intListe3);
		System.out.printf("Die Liste besitzt %2d Elemente.\n", intListe3.size());
		
	
		// entfernt alle Elemente mit dem gleichen Werten
		System.out.println("Entfernt alle Elemente mit dem Wert: 7.");
		intListe3.removeAll(Arrays.asList(7
				));
		System.out.println(intListe3);
		System.out.printf("Die Liste besitzt %2d Elemente.\n", intListe3.size());
		
		// Iterator
		Iterator<Integer> it = intListe3.iterator();
		while ( it.hasNext()){
			System.out.println(" ** " + it.next());
		}
		
		
		// ListIterarator
		ListIterator<Integer> listIt = intListe3.listIterator(intListe3.size());
		
		while ( listIt.hasPrevious()){
			System.out.println(" ++"
					
					+ " " + listIt.previous());
		}
		
		
		
		// loescht alle Elemente in der Liste
		intListe3.clear();
		System.out.printf("Die Liste besitzt %2d Elemente.\n", intListe3.size());
	}

}
