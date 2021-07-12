package listen;

public class Template01Liste {
	
	
	public static void ausgabe(Liste01 liste){
		liste.ausgebenAllerElemente();
		System.out.println("Anzahl Elemente in der Liste: " + liste.anzahlElemente());
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Liste01 liste = new Liste01();
		Liste01 listeNeu = null;
		
		// Elemente vorne in die Liste einfuegen
		liste.einfuegenVorne(7);
		liste.einfuegenVorne(5);
		liste.einfuegenVorne(3);
		liste.einfuegenVorne(1);
		
		ausgabe(liste);
		
		
		// Elemente hinten hinzufuegen
		liste.einfuegenHinten(9);
		liste.einfuegenHinten(11);
		liste.einfuegenHinten(13);
		
		
		// Elemente sortiert in Liste aufnehmen
		liste.einfuegenSortiert(8);
		liste.einfuegenSortiert(4);
		liste.einfuegenSortiert(6);
		liste.einfuegenSortiert(0);
				
		ausgabe(liste);
		
		// Elemente aus der Liste ausketten
		System.out.println("Element 13 aus Liste geloescht? " + liste.loescheElement(13));
		System.out.println("Element  0 aus Liste geloescht? " + liste.loescheElement(0));
		System.out.println("Element  8 aus Liste geloescht? " + liste.loescheElement(8));
		System.out.println("Element  7 aus Liste geloescht? " + liste.loescheElement(7));
		System.out.println("Element 13 aus Liste geloescht? " + liste.loescheElement(13));

		System.out.println();
			
		ausgabe(liste);
		
		System.out.println("==> tiefe Kopie der Liste");
		
		listeNeu = liste.clone();
		ausgabe(listeNeu);
													
	
		System.out.println("Alle Elemente der Liste geloescht!");
		liste.loescheAlleElemnte();
		
		ausgabe(liste);
		
		System.out.println("Element 0 aus Liste geloescht? " + liste.loescheElement(0));
		System.out.println("Element 0 in Liste eingefuegt ");
		liste.einfuegenSortiert(0);
		System.out.println("Element 0 aus Liste geloescht? " + liste.loescheElement(0));
		
		ausgabe(liste);
		
		ausgabe(listeNeu);
												
	}

}
