package uebungen04;

public class A1ListeTest {

	public static void main(String[] args) {
		final int ANZAHL = 10;
		A1Liste liste = new A1Liste();
		
		for (int i = 0; i < ANZAHL; i++){
			liste.readIn(i, i + 1);
		}
		
		System.out.println("Ausgabe: liste");
		liste.show();
		
		System.out.println("Liste kopieren (neueListe)");
		
		A1Liste neueListe = liste.copy();		
		neueListe.show();
		
		
		System.out.println("Liste anhaengen - bei leerer Liste - ");
		// Listen aneinanderhaengen
		A1Liste addListe = new A1Liste();
		System.out.println("addListe - vorher - ");
		addListe.show();
		
		addListe = addListe.conc(neueListe);
		System.out.println("addListe - nachher - ");
		addListe.show();
		
		System.out.println("Liste anhaengen (addListe) - leere Liste anhaengen");
		addListe = addListe.conc(new A1Liste());		
		addListe.show();
		
		
		System.out.println("Liste anhaengen (addListe) - Liste anhaengen (liste)");
        addListe = addListe.conc(liste);
		
        addListe.show();
		
        System.out.println("gebe erstes Element der Liste (liste): " + liste.head() );
        System.out.println("Ausgabe: Liste  - nachher -");
        liste.show();
        
        System.out.println(" tailListe von gebe zweites bis nte- Element der Liste (liste)  " );
        A1Liste tailListe = liste.tail();
        tailListe.show();
        
        System.out.println("Ausgabe: Liste");
        liste.show();
        System.out.println("Anzahl Elemente in der Liste (liste): " + liste.length() );
        
        System.out.println("Elemente in der Liste (liste) ersetzen: " );
        liste.add(19, 0);
        liste.add(19, 10);
        liste.show();
        
        System.out.println("In der Liste (liste) mit dem Key 4 ist folgende Info gespeichert: " + liste.get(4));
        
        System.out.println("Entferne Element mit dem Key 6 aus der Liste (liste) " );
        liste.drop(6);
        System.out.println("Anzahl Elemente in der Liste (liste): " + liste.length() );
        System.out.println("Ausgabe: Liste");
        liste.show();
        
        System.out.println("Ausgabe der Liste (liste) reverse");
        liste.reverse();
        liste.show();
        
        System.out.println("Ausgabe der Liste (liste) reverse");
        liste.reverse1();
        liste.show();
        
	}

}
