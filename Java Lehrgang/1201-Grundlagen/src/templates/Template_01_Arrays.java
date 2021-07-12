package templates;

import java.util.Arrays;


public class Template_01_Arrays
{
	public static void main(String[] args)
	{
		/* Skripkiddie-Variante fuer 10 Messwerte
		int messwert1, messwert2, messwert3, messwert4, messwert5, messwert6, messwert7, messwert8, messwert9, messwert10;
		
		System.out.print("Bitte Messwerte eingeben: ");
		Scanner sc = new Scanner(System.in);
		
		messwert1 = sc.nextInt();
		messwert2 = sc.nextInt();
		messwert3 = sc.nextInt();
		messwert4 = sc.nextInt();
		messwert5 = sc.nextInt();
		messwert6 = sc.nextInt();
		messwert7 = sc.nextInt();
		messwert8 = sc.nextInt();
		messwert9 = sc.nextInt();
		messwert10 = sc.nextInt();
		
		// Ab hier koennen wir mit den Messwerten arbeiten
		*/
		// Moegliche Datentypen sind:
		// -- primitive Datentypen, werden mit 0 oder false vorinitialisiert
		// -- Referenztypen werden mit null vorinitialisiert
		// -- Referenztypen anderer Arrays, um mehrdimensionalte Arrays zu realisieren
		
		// Erwachsenen-Variante fuer 10 Messwerte
		int[] messwerte = null;			// 1. Array-Variable deklarieren
		int[] messwerte1 = null ;
		messwerte = new int[5];	        // 2. Array im Speicher allozieren/reservieren/speichern fuer 5 Elemente
		
		// Ausgabe ohne Objekt-Anlegung? initialisiert!  null, bei Initialisierung, ansonsten Compiler-Fehler
		System.out.println(messwerte);

		System.out.println("Laenge-messwerte: " + messwerte.length);
		//java.util zur Veranschaulichung, dass die Klasse Arrays aus einer Bibliothek
		//in Java kommt. Somit hat irgendwann jemand die Klasse und deren Methoden
		//"Arrays" in der Bibliothek java.util.* geschrieben.
		System.out.println("Messwerte: " + java.util.Arrays.toString(messwerte)); // Standard-Array ausgabe
		
	
		if (messwerte instanceof Object ){
			System.out.println("messwerte ist von Object abgeleitet und somit ein Referenztyp");
		}
		
		if (messwerte instanceof Cloneable ){
			System.out.println("messwerte besitzt die Schnittstelle: Cloneable und somit die clone-Methode");
		}

		
		if (messwerte1 != null) {
			System.out.println("Laenge-messwerte1: (vorher) " + messwerte1.length); // geht nicht, kein Array erzeugt
		}
		else {
			System.out.println("Referenz-messwerte1: " + messwerte1);
			messwerte1 = new int[]{}; // leere Reihung, zu nichts zu gebrauchen.
			System.out.println("Referenz-messwerte1: " + messwerte1);
		}
		
		if (messwerte1 != null) {
			System.out.println("Laenge-messwerte1: (vorher) " + messwerte1.length); 
		}
		
		// Zuweisung von Referenzen
		messwerte1 = messwerte;
		
		if (messwerte1 != null) {
			System.out.println("Laenge-messwerte1: (nachher) " + messwerte1.length);
		}
		
		if (messwerte == messwerte1){
			System.out.println("Die Referenzen der Reihungen sind gleich");
			System.out.println("Referenz-messwerte1: " + messwerte1);
		}
		
		/***********************************************************************
		 * Erzeugt ein neues Array und macht eine flache Kopie der Komponenten
		 * bei primitiven Datentypen in Ordnung.
		 ***********************************************************************/
		messwerte1 = messwerte.clone();
		
		if (messwerte != messwerte1){
			System.out.println("Die Referenzen der Reihungen sind ungleich");
			System.out.println("Messwerte1: " + messwerte1);
			
			// Inhalte von Arrays, für primitive Datentypen, vergleichen
			if ( Arrays.equals(messwerte, messwerte1) ){
				System.out.println("Die Inhalte der Array's sind gleich");
			}
			
			// Inhalte von Arrays, fuer primitive Datentypen, vergleichen
			// bringt nicht erwartetes Verhalten!
			if ( messwerte.equals(messwerte1) ){
				System.out.println("Die Inhalte der Array's sind gleich");
			}
			else {
				System.out.println("Die Inhalte der Array's sind ungleich!!");
			}
			
		}
		
		
		for (int i = 0; i < messwerte.length; i++)
		{
			messwerte[i] = HilfsMeth.readInt("Bitte Messwerte eingeben: ");	
		}
		
		// Ausgabe aller Werte im Format Index i = Wert
		for (int wert : messwerte)
		{
			System.out.println("Wert = " + wert);
		} 
		
		System.out.println("Messwerte1: " + Arrays.toString(messwerte1)); // Standard-Array ausgabe
		// Werte von zwei existierenden Arrays oder innerhalb eines Arrays kopieren
		// nach links oder rechts verschieben
		System.arraycopy(messwerte, 0, messwerte1, 0, messwerte.length);
		
		System.out.println("Messwerte1: " + Arrays.toString(messwerte1)); // Standard-Array ausgabe
		
		/*******************************************************
		 * reihe nach links rotieren
		 * 
		 *******************************************************/
		int[] reihe = {1,2,3,4};
		System.out.println("Reihe: " + Arrays.toString(reihe)); // Standard-Array ausgabe
		
		int ersterWert = reihe[0];
		for (int i = 0; i < (reihe.length - 1); i++ ){
			reihe[i] = reihe[i+1];
		}
		reihe[reihe.length-1] = ersterWert;
		
		System.out.println("Reihe: " + Arrays.toString(reihe)); 

		
		/*******************************************************
		 * reihe1 nach rechts rotieren
		 * 
		 *******************************************************/
		int[] reihe1 = {1,2,3,4};
		System.out.println("Reihe1: " + Arrays.toString(reihe1)); 
		
		int letzterWert = reihe1[reihe1.length-1];
		
		for (int i = (reihe1.length-1); i > 0; i--){
			 reihe1[i] = reihe1[i-1];
		}
		
		reihe1[0] = letzterWert; 
		System.out.println("Reihe1: " + Arrays.toString(reihe1)); 
		
	}
}