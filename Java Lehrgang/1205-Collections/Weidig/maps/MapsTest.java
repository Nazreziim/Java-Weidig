package maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;


public class MapsTest {

	public static void main(String[] args) {
		//unsortiert
		HashMap<Integer, String> unsortiert = new HashMap<>();		
		System.out.println(unsortiert);
		
		for(int i = 0; i < 100000; i++ ) {
			unsortiert.put(i, null);
		}
		
		Iterator<Integer> itKeys = unsortiert.keySet().iterator();
		
		while(itKeys.hasNext()) {
			System.out.println(itKeys.next());
		}
		
		System.out.println("\nLinkedHashMap:");
		
		
		//Insertion Sort
		LinkedHashMap<Integer, String> insertionSort = new LinkedHashMap<>();
		
		insertionSort.put(0, "Weidig");
		insertionSort.put(5, "Weeg");
		insertionSort.put(2, "Krenz");
		insertionSort.put(1, "Madl");
		insertionSort.put(4, "Eggert");
		insertionSort.put(3, "Muetze");
		insertionSort.put(6, "Wente");
		
		
		Iterator<String> itValues = insertionSort.values().iterator();
		
		while(itValues.hasNext()) {
			System.out.println(itValues.next());
		}
		
		Iterator<Integer> itKeyInsertSort = insertionSort.keySet().iterator();
		
		while(itKeyInsertSort.hasNext()) {
			System.out.println(itKeyInsertSort.next());
		}
		
		//Nach Natürlichkeit oder Spezifizierung sortiert
		System.out.println("\nTreeMap:");
		TreeMap<Integer, String> sortiert = new TreeMap<>();
		
		sortiert.put(0, "Weidig");
		sortiert.put(5, "Weeg");
		sortiert.put(2, "Krenz");
		sortiert.put(1, "Madl");
		sortiert.put(4, "Eggert");
		sortiert.put(3, "Muetze");
		sortiert.put(6, "Wente");
		
		Iterator<String> itNameIterator = sortiert.values().iterator();
		
		while(itNameIterator.hasNext()) {
			System.out.println(itNameIterator.next());
		}
		
		Iterator<Integer> itKeyIterator = sortiert.keySet().iterator();
		
		while(itKeyIterator.hasNext()) {
			System.out.println(itKeyIterator.next());
		}
	}


}