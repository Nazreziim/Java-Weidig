package listen;

public class Template02Liste {

	/**
	 * // Ausgabe der Liste rekursiv
	 * @param liste
	 * @param vorwaerts
	 */
	public static void ausgabe(Liste02Rek liste, boolean vorwaerts){
		liste.ausgebenAllerElementeRek(vorwaerts);		
		System.out.println("Anzahl Elemente in der Liste: " + liste.anzahlElementeRek());
		System.out.println();
	}
	
	public static void main(String[] args) {
		Liste02Rek liste = new Liste02Rek();
		Liste02Rek listeNeu = null;
		
		// Elemente vorne in die Liste einfuegen
		liste.einfuegenVorne(7);
		liste.einfuegenVorne(5);
		liste.einfuegenVorne(3);
		liste.einfuegenVorne(1);
		
		
		ausgabe(liste, true);
		
		// Elemente hinten hinzufuegen
		liste.einfuegenHintenRek(9);
		liste.einfuegenHintenRek(11);
		liste.einfuegenHintenRek(13);

		
		ausgabe(liste, false);
		
		
		// Elemente sortiert in Liste aufnehmen
		liste.einfuegenSortiertRek(8);
		liste.einfuegenSortiertRek(4);
		liste.einfuegenSortiertRek(6);
		liste.einfuegenSortiertRek(0);
		
		ausgabe(liste, true);
		
		// Liste kopiert (tiefe Kopie)
        listeNeu = liste.clone();	
        System.out.println("==> tiefe Kopie");
		ausgabe(listeNeu, true);
		

		// Elemente aus der Liste ausketten
		System.out.println("Element 13 aus Liste geloescht? ");
		liste.loescheElementRek(13);
		System.out.println("Element 0 aus Liste geloescht? ");
		liste.loescheElementRek(0);
		System.out.println("Element 8 aus Liste geloescht? ");
		liste.loescheElementRek(8);
		System.out.println("Element 7 aus Liste geloescht? ");
		liste.loescheElementRek(7);
		System.out.println("Element 13 aus Liste geloescht? ");
		liste.loescheElementRek(13);
		
		System.out.println();
		
		ausgabe(liste, true);
		
		listeNeu.loescheAlleElementeRek();
		ausgabe(listeNeu, false);
	
	}

}
