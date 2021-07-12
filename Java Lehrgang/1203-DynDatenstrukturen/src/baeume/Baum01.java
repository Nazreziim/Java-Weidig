package baeume;

import java.util.Arrays;

public class Baum01 {
	
	private Knoten01 wurzel;
	
	public Baum01() {
		this.wurzel = null;
	}
	
	private Knoten01 einfuegen(Knoten01 wurzel, int key, char info){
		Knoten01 knoten = wurzel;
		
		if ( knoten == null){
			knoten = new Knoten01(key, info);
		}
		else{
			if (key <= knoten.getKey()){
				knoten.setLeft(einfuegen(knoten.getLeft(), key, info));
			}
			else{
				knoten.setRight(einfuegen(knoten.getRight(), key, info));
			}
		}
		return knoten;
	}
	
	public void einfuegen(int key, char info){
		this.wurzel = einfuegen(this.wurzel, key, info);
	}
	
	private Knoten01 loeschen(Knoten01 wurzel, int key){
		Knoten01 knoten = wurzel;
		Knoten01 hilf = null;
		
		if (knoten != null){
			
			if (key < knoten.getKey()){
				// weitersuchen im linken Teilbaum
				knoten.setLeft(loeschen(knoten.getLeft(), key));
			}
			else if (key > knoten.getKey()){
				// weitersuchen im rechten Teilbaum
				knoten.setRight(loeschen(knoten.getRight(), key));
			}
			else{// Knoten gefunden
				
				if (knoten.isLeaf()){ // Blatt gefunden
					knoten = null;
				}
				else if (knoten.isLeftSon()){ // nur linker Sohn vorhanden
					knoten = knoten.getLeft(); // ausketten des Knotens
				}
				else if (knoten.isRightSon()){ // nur rechter Sohn vorhanden
					knoten = knoten.getRight(); // ausketten des Knotens
				}
				else{ // zwei Soehne vorhanden
					
					// 1. in den rechten Teilbaum gehen
					hilf = wurzel.getRight();
					
					// 2. dort kleinstes Element suchen
					while (hilf.getLeft() != null){
						hilf = hilf.getLeft();
					}
					
					// 3. Inhalt des kleinsten Elements uebertragen
					knoten.setInfo(hilf.getInfo());
					knoten.setKey(hilf.getKey());
					
					// 4. kleinstes Element im rechten Teilbaum loeschen
					// (hat hoechstens einen Nachfolger)
					knoten.setRight(loeschen(knoten.getRight(), hilf.getKey()));
					
				}
			}
		}
		
		return knoten;
	}
	
	public void loeschen(int key){
		this.wurzel = loeschen(this.wurzel, key);
	}
	
	
	private void ausgabeInOrder(Knoten01 wurzel){
		if (wurzel != null){
			ausgabeInOrder(wurzel.getLeft());
			// Aktion
			System.out.println(wurzel.toString());
			ausgabeInOrder(wurzel.getRight());
		}
	}
	
	
	
	/**
	 * Geeignet fuer eine sortierte Ausgabe (Key) der Knoten.
	 */
	public void ausgabeInOrder(){
		System.out.println("Ausgabe Baum in (InOrder)- Reihenfolge ");
		ausgabeInOrder(this.wurzel);
		System.out.println();
	}
	
	private void ausgabePreOrder(Knoten01 wurzel){
		if (wurzel != null){
			// Aktion
			System.out.println(wurzel.toString());
			
			ausgabePreOrder(wurzel.getLeft());			
			ausgabePreOrder(wurzel.getRight());
		}
	}
	
	
	
	/**
	 * Geeignet fuer eine 1:1 Kopie eines Baumes
	 */
	public void ausgabePreOrder(){
		System.out.println("Ausgabe Baum in (PreOrder)- Reihenfolge ");
		ausgabePreOrder(this.wurzel);
		System.out.println();
	}
	
	
	private void ausgabePostOrder(Knoten01 wurzel){
		if (wurzel != null){
			
			ausgabePostOrder(wurzel.getLeft());			
			ausgabePostOrder(wurzel.getRight());
			// Aktion
			System.out.println(wurzel.toString());
		}
	}
	
	
	/**
	 * Geeignet zum Loeschen des gesamten Baumes (nur Blaetter loeschen)
	 */
	public void ausgabePostOrder(){
		System.out.println("Ausgabe Baum in (PostOrder)- Reihenfolge ");
		ausgabePostOrder(this.wurzel);
		System.out.println();
	}
	
	public void ausgabeInfo(Knoten01 wurzel, int hierarchie) {
		
		if ( wurzel != null ) {
			// *************   Aktion  ****************
			if ( hierarchie != 0 ) {
				char[] zeile1 = new char[hierarchie];
				char[] zeile2_1 = null;
				char[] zeile2_2 = null;
				
				Arrays.fill(zeile1, ' ');
				
				zeile2_1 = zeile1.clone();
				zeile2_2 = zeile1.clone();
				
				zeile1[zeile1.length-1] = '|';
				Arrays.fill(zeile2_2, '-');
				
				System.out.println(String.valueOf(zeile1));
				System.out.print(String.valueOf(zeile2_1));
				System.out.print(String.valueOf(zeile2_2));
				System.out.print('>');
			}
			
			System.out.print(wurzel.getInfo());
			
			if (wurzel.isLeaf()) {
				System.out.print('*');
			}
			System.out.println();
			
			// ************** Ende Aktion ********************
			ausgabeInfo(wurzel.getLeft(), hierarchie +1);
			ausgabeInfo(wurzel.getRight(), hierarchie +1);
		}
		
	}
	
	public void ausgabeInfo() {
		System.out.println("Ausgabe Baum in (PreOrder)- Reihenfolge mit Hierarchie");
		ausgabeInfo(this.wurzel, 0);
		System.out.println();
	}
	
	private int anzahlKnoten(Knoten01 wurzel){
		int erg = 0;
		
		if ( wurzel != null){
			erg = 1 + anzahlKnoten(wurzel.getLeft()) +  anzahlKnoten(wurzel.getRight());
		}
		return erg;
	}
	
	public int anzahlKnoten(){
		
		return anzahlKnoten(this.wurzel);
	}
	
	private int anzahlBlaetter(Knoten01 wurzel){
		int erg = 0;
		
		if (wurzel == null){
			erg = 0;
		}
		else if (wurzel.isLeaf()){
			erg = 1;
		}
		else{
			erg = anzahlBlaetter(wurzel.getLeft()) + anzahlBlaetter(wurzel.getRight());
		}
		
		return erg;
	}
	
	public int anzahlBlaetter(){
		return anzahlBlaetter(this.wurzel);
	}
	
	
	private int hoehe(Knoten01 wurzel){
		int erg = 0;
		if ( wurzel == null){
			erg = 0;
		}
		else{
			erg = 1 + Math.max(hoehe(wurzel.getLeft()), hoehe(wurzel.getRight()));
		}
		return erg;
	}
	
	public int hoehe(){
		return hoehe(this.wurzel);
	}
}
