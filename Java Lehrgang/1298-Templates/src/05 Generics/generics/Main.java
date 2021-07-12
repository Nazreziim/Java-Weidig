package generics;

import java.util.*;

import comparable.Person;

public class Main {

	public static void main(String[] args) {
		
		// 1.) Wdh.: Nochmal rumspielen mit Arrays
		Number[] nummern = new Double[20]; // Nutzen der Polymorphie (durch Wrapper)		
		/*int[] num2 = new int[20];
		num2[0] = 4;
		num2[1] = 1.234;*/		
		nummern[0] = new Integer(4).doubleValue();
		nummern[1] = 1.234;			
		System.out.println(nummern[0]);
		System.out.println(nummern[1]);
		
		// 2. ) Vordefinierte generische Klasse aus java.util
		ArrayList<Double> al = new ArrayList<Double>();
		//al.add(4);
		al.add(1.234);
		//al.add("Hallo");		
		al.add(2.341);
		al.add(6.143);		
		System.out.println(al.get(0));
		System.out.println(al.get(1));
		System.out.println(al.get(2));		
		//Number erg = ((Integer)al.get(0)).doubleValue() + (Double)al.get(1);
		Double erg = al.get(0) + al.get(1);
		System.out.println(erg);
				
		// 3.) Eigene generische Klasse
		Box<Integer> b = new Box<Integer>(5);
		System.out.println(b.getVal());
		Box<String> b2 = new Box<String>("Tschuess");
		System.out.println(b2.getVal());
		ZahlenBox<Integer> zb1 = new ZahlenBox<Integer>(5);
		ZahlenBox<Double> zb2 = new ZahlenBox<Double>(4.23);
		System.out.println(zb1.addiere(8));
		System.out.println(zb2.addiere(3.2));
		
		
		Person p1 = new Person("Lars Gerhard", 186);
		SortedBox<Person> sb1 = new SortedBox<Person>(p1);
		Person p2 = new Person("Ruediger Huesch", 179);
		SortedBox<Person> sb2 = new SortedBox<Person>(p2);
		
		System.out.println(sb1.gibGroesser(sb2));
		
		
		//4.) Wildcards
		ArrayList<Integer> al2 = new ArrayList<Integer>(); // kann nur Integer aufnehmen
		ArrayList<Object> al3 = new ArrayList<Object>();
		ArrayList<?> al4;
		
		
	}

}
