package setTest;

import java.util.*;

public class PersonSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Person person1=new Person("Lars","Gerhard", 10054381);
		Person person2=new Person("Daniel","Borkowitz", 10054176);
		Person person3=new Person("Ruediger","Huesch",  10057433);
		
				
		// HashSet
		HashSet<Person> personal = new HashSet<Person>();
		personal.add(person1);
		personal.add(person2);
		personal.add(person3);
		
		if (personal.add(person1)) {
			System.out.println("Person 1 nochmal eingefügt");
		} else {
			System.out.println("Person 1 gibts schon");
		}
		
		if (personal.contains(new Person("Daniel","Borkowitz", 10054176))) {
			System.out.println("Person 2 gibts schon");
		} else {
			System.out.println("Person 2 gibts noch nicht");
		}
				
		Iterator<Person> it = personal.iterator();
		
		while (it.hasNext()) {
			it.next().printPerson();
		}
		
		// TreeSet
		SortedSet<Integer> intBaum = new TreeSet<Integer>();
		TreeSet<Person> personalBaum = new TreeSet<Person>();
		
		// Erstmal der intBaum
		intBaum.add(3);
		intBaum.add(9);
		intBaum.add(2);
		intBaum.add(7);
		intBaum.add(6);		
		
		Iterator<Integer> intIt = intBaum.iterator();		
		while (intIt.hasNext()) {
			System.out.println(intIt.next());
		}
		
		// jetzt schwieriger: der personalBaum
		personalBaum.add(person1);
		personalBaum.add(person2);
		personalBaum.add(person3);
		Iterator<Person> baumIt = personalBaum.iterator();
		while (baumIt.hasNext()) {
			baumIt.next().printPerson();
		}

	}

}
