package mapTest;

import java.util.*;

import setTest.Person;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Integer,Person> personal = new HashMap<Integer,Person>(); 
		
		Person person1=new Person("Lars","Gerhard", 10054381);
		Person person2=new Person("Daniel","Borkowitz", 10054176);
		Person person3=new Person("Ruediger","Huesch",  10057433);
		Integer key1 = 678;
		Integer key2 = 123;
		Integer key3 = 198;
		
		personal.put(key1, person1);
		personal.put(key2, person2);
		personal.put(key3, person3);
		personal.put(965,  person3);
		
		Iterator<Person> mapIt = personal.values().iterator();
		
		while (mapIt.hasNext()) {
			mapIt.next().printPerson();
		}
		
		personal.remove(965).printPerson();
		
		
		// Aus der HashMap eine TreeMap machen
		System.out.println("------------");
		TreeMap<Integer,Person> personalBaum = new TreeMap<Integer, Person>();
		TreeMap<Integer,Person> personalBaum2 = new TreeMap<Integer, Person>(personal);
		
		personalBaum.putAll(personal);
		mapIt = personalBaum.values().iterator();
		while (mapIt.hasNext()) {
			mapIt.next().printPerson();
		}
		
		Iterator<Integer> intIt = personal.keySet().iterator();
		while (intIt.hasNext()) {
			System.out.println(intIt.next().toString());
		}
		
		
		
		
		
		

	}

}
