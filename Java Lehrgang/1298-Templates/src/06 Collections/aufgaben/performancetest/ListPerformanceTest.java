package aufgaben.performancetest;

import java.util.*;

public class ListPerformanceTest {
	private static final int N = 200_000;
	private static List<Integer> liste = new ArrayList<Integer>();
	
	public ListPerformanceTest() {

	}

	public static void main(String[] args) {
		liste = new ArrayList<Integer>();
		System.out.println("Zeitmessung für ArrayList:\n--------------------------");
		System.out.println("1. Anfuegen hinten: " + addHinten(N, liste) );
		liste = new ArrayList<Integer>();
		System.out.println("2. Anfuegen vorne: " + addVorne(N, liste) );
		System.out.println("3. Seq. Zufriff (Index): " + seqZugriff(N, liste) );
		System.out.println("4. Löschen (Index): " + loeschenViaIndex(N, liste) );
		addHinten(N, liste);
		System.out.println("5. Seq. Zugriff (Iterator): " + seqZugriffIt(N, liste) );
		System.out.println("6. Löschen (Iterator): " + loeschenViaIt(N, liste) );
		System.out.println("7a. Reverse-Iterator: " + reverseIt(N, liste) );
		System.out.println("7b. StepOver-Iterator: " + stepOverIt(N, liste) );
		
		liste = new LinkedList<Integer>();
		System.out.println("\n\nZeitmessung für LinkedList:\n---------------------------");
		System.out.println("1. Anfuegen hinten: " + addHinten(N, liste) );
		liste = new LinkedList<Integer>();
		System.out.println("2. Anfuegen vorne: " + addVorne(N, liste) );
		System.out.println("3. Seq. Zufriff (Index): " + seqZugriff(N, liste) );
		System.out.println("4. Löschen (Index): " + loeschenViaIndex(N, liste) );
		addHinten(N, liste);
		System.out.println("5. Seq. Zugriff (Iterator): " + seqZugriffIt(N, liste) );
		System.out.println("6. Löschen (Iterator): " + loeschenViaIt(N, liste) );
		System.out.println("7a. Reverse-Iterator: " + reverseIt(N, liste) );
		System.out.println("7b. StepOver-Iterator: " + stepOverIt(N, liste) );
	}
	
	private static long addHinten(int N, List<Integer> l) {
		long start = System.currentTimeMillis();
		for (int i=0; i < N; i++) {
			l.add( i );
		}
		
		return System.currentTimeMillis() - start;
	}
	
	private static long addVorne(int N, List<Integer> l) {
		long start = System.currentTimeMillis();
		for (int i=0; i < N; i++) {
			l.add(0,i);
		}
		
		return System.currentTimeMillis() - start;
	}
	
	private static long seqZugriff(int N, List<Integer> l) {
		if (l.size() < N) {
			addHinten(N-l.size(), l);
		}
		long start = System.currentTimeMillis();
		for (int i=0; i < N; i++) {
			Integer in = l.get(i) + 1;
		}
		
		return System.currentTimeMillis() - start;
	}
	
	private static long loeschenViaIndex(int N, List<Integer> l) {
		
		if (l.size() < N) {
			addHinten(N-l.size(), l);
		}
		long start = System.currentTimeMillis();
		for (int i=0; i < N; i++) {
			l.remove(0);
		}
		
		return System.currentTimeMillis() - start;
	}

	private static long seqZugriffIt(int N, List<Integer> l) {
		if (l.size() < N) {
			addHinten(N-l.size(), l);
		}
		long start = System.currentTimeMillis();		
		Iterator<Integer> it = new MeinIterator<Integer>(l) ; //l.iterator();
		while (it.hasNext()) {
			// System.out.println(it.next());
			Integer i = it.next() + 1; 
		}
		
		return System.currentTimeMillis() - start;
	}
	
	private static long loeschenViaIt(int N, List<Integer> l) {
		
		if (l.size() < N) {
			addHinten(N-l.size(), l);
		}
		long start = System.currentTimeMillis();
		Iterator<Integer> it = l.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}		
		return System.currentTimeMillis() - start;
	}
	
	private static long reverseIt(int N, List<Integer> l) {
		if (l.size() < N) {
			addHinten(N-l.size(), l);
		}
		long start = System.currentTimeMillis();
		Iterator<Integer> it = new ReverseIterator<Integer>(l);
		while (it.hasNext()) {
			it.next();
		}		
		return System.currentTimeMillis() - start;
	}
	
	private static long stepOverIt(int N, List<Integer> l) {
		if (l.size() < N) {
			addHinten(N-l.size(), l);
		}
		long start = System.currentTimeMillis();
		Iterator<Integer> it = new StepOverIterator<Integer>(l);
		while (it.hasNext()) {
			it.next();
		}		
		return System.currentTimeMillis() - start;
	}
	
}
