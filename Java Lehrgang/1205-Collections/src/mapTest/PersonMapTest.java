package mapTest;

import java.util.*;

import setTest.Person;

public class PersonMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Integer,Person> personal = new HashMap<Integer,Person>(); 
		
		Person person1 = new Person("Lars","Gerhard"    , 100544444);
		Person person2 = new Person("Daniel","Borkowitz", 100555555);
		Person person3 = new Person("Ruediger","Huesch" , 100573333);
		Integer key1 = 678;
		Integer key2 = 123;
		Integer key3 = 198;
		
		// Wertepaare setzen
		personal.put(key1, person1);
		personal.put(key2, person2);
		
		Person p = personal.put(key3, person3);
		if (p != null){
			p.printPerson();
		}
		else{
			System.out.println("Neues Element");
		}
		
		// gleiche Person (Wert) wird nochmals aufgenommen
		// Schluessel ist neu, daher wird dieses Schluesselwertpaar hinzugefuegt.
		Person p1 = personal.put(965,  person3);
		if (p1 != null){
			p1.printPerson();
		}
		else{
			System.out.println("Neues Element");
		}
		
		System.out.printf("Suche eine Person mit key: %d vorhanden? %b " , 965, personal.containsKey(965));
		
		// gleicher Schluessel und unterschiedlicher Wert, Person (Wert) wird ersetzt und alte Person wird 
		// zurueckgegeben.
		Person p2 = personal.put(965,  new Person("Willi","Hoelzle",  100666666 ));
		if (p2 != null){
			p2.printPerson();
		}
		else{
			System.out.println("Neues Element");
		}
		
		System.out.printf("Suche eine Person mit key: %d vorhanden? %b \n" , 965, personal.containsKey(965));
		
		
		System.out.println("----------------------- Durchlauf der HashMap mit Collection -------------");
		System.out.println();
		
		Collection<Person> personen = personal.values();
		
		for (Person person : personen){
			System.out.println("Person: " );
			person.printPerson();
		}
		
		// Iterator Ausgabe aller Elemente
		Iterator<Person> mapIt = personal.values().iterator();
		
		while (mapIt.hasNext()) {
			mapIt.next().printPerson();
		}
		
		
		System.out.println("Entferne eine Person mit key: 965 ");
		// entfernt eine Person aus HashMap
		personal.remove(965).printPerson();
		
		// pruefen, ob Person vorhanden ist
		System.out.println("Suche eine Person mit key: 965 vorhanden? " + personal.containsKey(965));
		
		// gebe mir Person mit key
		personal.get(key2).printPerson(); 
		
		
		System.out.println("Anzahl Elemente: " + personal.size());
		System.out.println();
		
		
		System.out.println("----------------------- Durchlauf der TreeMap mit Set -------------");
		System.out.println();
		Set<Integer> keySet = personal.keySet();
		
		System.out.println("Ausgabe aller Schluessel in der Map");
		for ( Integer key : keySet ){
			System.out.println("Key : " + key);
		}
		
		Iterator<Integer> intIt = personal.keySet().iterator();
		while (intIt.hasNext()) {
			System.out.println(intIt.next().toString());
		}
			
		
		// Aus der HashMap eine TreeMap machen
		System.out.println("----- Aus HashMap eine TreeMap machen -------");
		TreeMap<Integer,Person> personalBaum  = new TreeMap<Integer, Person>();
		TreeMap<Integer,Person> personalBaum2 = new TreeMap<Integer, Person>(personal);
		
		personalBaum.putAll(personal);
		
		System.out.println("----------------------- Durchlauf der TreeMap mit Collection -------------");
		System.out.println();
		
		mapIt = personalBaum.values().iterator();
		while (mapIt.hasNext()) {
			mapIt.next().printPerson();
		}
		
		System.out.println("----------------------- Durchlauf der TreeMap mit Map.Entry -------------");
		System.out.println();
		Set<Map.Entry<Integer, Person>> eintraege = personalBaum2.entrySet();
		
		for (Map.Entry<Integer, Person> eintrag : eintraege){
			System.out.print("Schluessel => " + eintrag.getKey() + "\tInhalt: ");
			eintrag.getValue().printPerson();
			System.out.println();
		}	

	}

}
