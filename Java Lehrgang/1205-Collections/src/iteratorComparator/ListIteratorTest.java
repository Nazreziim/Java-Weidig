package iteratorComparator;

import java.util.Iterator;

public class ListIteratorTest {

	public static void listeIteratorIterable(){
		ListeIter liste = new ListeIter();
		
		System.out.println("Liste besitzt Iterator- und Iterable-Schinttstelle");
		
		liste.einfuegenVorne(4);
		liste.einfuegenVorne(34);
		liste.einfuegenVorne(12);
		liste.einfuegenVorne(24);
		liste.einfuegenVorne(32);
		liste.einfuegenVorne(4);
		liste.einfuegenVorne(5);
		
		for ( int wert : liste){
			System.out.println("Inhalt: " + wert);
		}
				
		System.out.println();
		// nutzt die Schnittstelle der Listenklasse
		IteratorInteger it = new IteratorInteger(liste);
		
		while (it.hasNext()){
			System.out.println("Wert= " + it.next());
		}
	}
	
	
	public static void listeMitgliedsKlasse(){
		 ListeIter2 liste2 = new ListeIter2();
			
		 liste2.einfuegenVorne(4);
		 liste2.einfuegenVorne(34);
		 liste2.einfuegenVorne(12);
		 liste2.einfuegenVorne(24);
		 liste2.einfuegenVorne(32);
		 liste2.einfuegenVorne(4);
		 liste2.einfuegenVorne(5);
			
		 for ( int wert : liste2){
		 	System.out.println("Inhalt: " + wert);
		 }
					
		 System.out.println();
			
		 Iterator<Integer> it2 = liste2.iterator();
			
		 while (it2.hasNext()){
			System.out.println("Wert= " + it2.next());
		}
			
	}
	
	public static void listeLokaleKlasse(){
		 ListeIter3 liste3 = new ListeIter3();
			
		 liste3.einfuegenVorne(4);
		 liste3.einfuegenVorne(34);
		 liste3.einfuegenVorne(12);
		 liste3.einfuegenVorne(24);
		 liste3.einfuegenVorne(32);
		 liste3.einfuegenVorne(4);
		 liste3.einfuegenVorne(5);
			
		 for ( int wert : liste3){
		 	System.out.println("Inhalt: " + wert);
		 }
					
		 System.out.println();
			
		 Iterator<Integer> it3 = liste3.iterator();
			
		 while (it3.hasNext()){
			System.out.println("Wert= " + it3.next());
		}
			
	}
	
	
	public static void main(String[] args) {
		
		listeIteratorIterable();
		
		listeMitgliedsKlasse();
		
		listeLokaleKlasse();
	}

}
