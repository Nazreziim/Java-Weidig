package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Iteratoren {

	public static void main(String[] args) {
		ArrayList<String> liste = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			liste.add("Objekt " + i);
		}
		
		System.out.println(liste);
		
		// 1.) Standarditerator benutzen
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
		
		it = liste.iterator();
		
		
		// 2.) Eigenen Iterator benutzen
		System.out.println("----------------------------------");
		StepOverIterator<String> it2 = new StepOverIterator<>(liste);
		
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}

	}

}
