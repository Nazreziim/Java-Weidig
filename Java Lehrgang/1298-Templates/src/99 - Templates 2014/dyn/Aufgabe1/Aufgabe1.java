public class Aufgabe1 {
	public static void main(String[] args) {
		// a) READIN
		Liste liste = new Liste(0);
		liste.readIn(1);
		liste.readIn(3);
		liste.readIn(5);
		liste.readIn(7);
		System.out.println(liste);
		
		Liste liste2 = new Liste(7);
		liste2.readIn(5);
		System.out.println(liste2);
		
		// b) COPY
		System.out.println("Kopie von der ersten Liste");
		Liste kopie = liste.copy();
		System.out.println(kopie);
		System.out.println("Kopie von der zweiten Liste rekursiv");
		Liste kopie2 = liste2.copy_rek();
		System.out.println(kopie2);
		
		
		// c) SHOW ist die toString()-Methode
		
		// d) CONC
		liste.conc(liste2);
		
		// e) HEAD
		System.out.println("Erstes Element der Liste ist: " + liste.head());
		
		// f) TAIL
		System.out.println("Die restliche Liste ist: " + liste.tail());
		
		// g) LENGTH
		System.out.println(liste);
		System.out.println("Laenge der Liste: " + liste.length());
		
		// h) ADD
		liste.add(10, 2);
		liste.add_rek(15, 3);
		System.out.println(liste);
		
		// i) GET
		System.out.println("Wert bei Key 3: " + liste.get(3));
		System.out.println("Wert bei Key 13: " + liste.get(13));
		
		// j) DROP
		liste.drop(4);
		System.out.println(liste.copy_rek());
		
		// k) REVERSE
		Liste reverse = liste.reverse();
		System.out.println("Umgedreht ist die Liste: " + reverse.copy());
	}
}
