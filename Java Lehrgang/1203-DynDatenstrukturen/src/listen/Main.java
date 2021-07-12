package listen;

public class Main {
	public static void main (String[] args) {
		// A - readIn
		Liste eine_liste = new Liste();
		eine_liste.add_hinten(2);
		eine_liste.add_hinten(4);
		eine_liste.add_hinten(7);
		eine_liste.add_hinten(9);
		eine_liste.add_sortiert(1);
		eine_liste.add_sortiert(5);
		eine_liste.add_sortiert(13);
		
		// C - show
		eine_liste.show();
		System.out.println("-------------");
		
		// B)
		System.out.println("copy:");
		Liste kopie = eine_liste.copy();
		kopie.show();
		System.out.println("-------------");
		
		// D)
		System.out.println("conc:");
		Liste zusammen = eine_liste.conc(kopie);
		zusammen.show();
		System.out.println("-------------");
		
		// E)
		System.out.println("head:");
		Liste head = eine_liste.head();
		head.show();
		System.out.println("-------------");
		
		// F)
		System.out.println("tail:");
		Liste tail = eine_liste.tail();
		tail.show();
		System.out.println("-------------");
		
		// G)
		System.out.println("length:");
		int laenge = eine_liste.length();
		eine_liste.show();
		System.out.println("Die Länge der Liste ist: " + laenge);
		System.out.println("-------------");
		
		
		// H)
		System.out.println("add(info, key): add(3,10)");
		eine_liste.show();
		eine_liste.add(3,10);
		eine_liste.show();
		System.out.println("-------------");
		
		// I)
		System.out.println(("get(int key): get(12)"));
		int info = eine_liste.get(12);
		System.out.println("Die info fuer key = 12 ist: " + info);
		System.out.println("-------------");
		
		// J)
		System.out.println("drop:");
		eine_liste.show();
		eine_liste.drop(7);
		eine_liste.show();
		System.out.println("-------------");
		
		// K)
		System.out.println("reverse:");
		Liste rueckwaerts = eine_liste.reverse();
		rueckwaerts.show();
		System.out.println("-------------");
		
		
		
	}
}
