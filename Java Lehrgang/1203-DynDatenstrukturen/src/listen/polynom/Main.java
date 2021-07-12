package listen.polynom;

public class Main {

	public static void main(String[] args) {
		Polynom polynom = new Polynom();
		
		System.out.println("Aufnahme der Polynom-Glieder");
		polynom.einfuegenHinten(4, 14.3);
		polynom.einfuegenHinten(2, 3.7);
		polynom.einfuegenHinten(1, 10.9);
		polynom.einfuegenHinten(0, 4.0);
		
		System.out.println("Ausgabe der Polynom-Glieder");
		polynom.drucke();
		
		System.out.printf("Berechne das Polynom: %.2f", polynom.auswerte(2.0));
		
		System.out.println();
		
		
		Polynom polynom1 = new Polynom();
		
		System.out.println("Aufnahme der Polynom-Glieder");
		polynom1.einfuegenHinten(3, 2.0);
		polynom1.einfuegenHinten(2, 3.0);
		polynom1.einfuegenHinten(1, 3.0);
		polynom1.einfuegenHinten(0, 1.0);
		System.out.println("Ausgabe Polymom 1:");
		polynom1.drucke();
		
        Polynom polynom2 = new Polynom();
		
		System.out.println("Aufnahme der Polynom-Glieder");
		polynom2.einfuegenHinten(2, 4.0);
		polynom2.einfuegenHinten(1, 2.0);
		polynom2.einfuegenHinten(0, 2.0);
		System.out.println("Ausgabe Polymom 2:");
		polynom2.drucke();
		
		System.out.println("Addiere zwei Polynome");
		Polynom ergAdd = Polynom.add(polynom1, polynom2);
		
		System.out.println("Ausgabe der Polynom-Glieder");
		ergAdd.drucke();
		
	
		System.out.println("Aufnahme der Polynom-Glieder");
		Polynom polynom3 = new Polynom();
		polynom3.einfuegenHinten(2, 2.0);
		polynom3.einfuegenHinten(0, 1.0);
		System.out.println("Ausgabe Polymom 3:");
		polynom3.drucke();
		
		Polynom polynom4 = new Polynom();
		polynom4.einfuegenHinten(1, 3.0);
		polynom4.einfuegenHinten(0, 2.0);
		System.out.println("Ausgabe Polymom 4:");
		polynom4.drucke();
		
		System.out.println("Multipliziere zwei Polynome");
		Polynom ergMult = Polynom.mult(polynom3, polynom4);
		
		System.out.println("Ausgabe der Polynom-Glieder");
		ergMult.drucke();
	}

}
