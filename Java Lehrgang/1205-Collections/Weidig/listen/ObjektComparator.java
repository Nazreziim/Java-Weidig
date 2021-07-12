package listen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ObjektComparator {
	public static void main(String[] args) {
		ArrayList<MenschMitAlter> arrLiA = new ArrayList<>();
		
		arrLiA.add(new MenschMitAlter(1));
		arrLiA.add(new MenschMitAlter(2));
		arrLiA.add(new MenschMitAlter(4));
		arrLiA.add(new MenschMitAlter(5));
		arrLiA.add(new MenschMitAlter(3));
		
		System.out.println("\nMöglichkeit 1: Zahlwerte vergleichen");
		// Eigener Comparator
		arrLiA.sort(new MenschMitAlterComparator());
		System.out.println("Mit Comparator sortiert: " + Arrays.toString(arrLiA.toArray()));
		
		
		ArrayList<MenschMitName> arrLiN = new ArrayList<>();
		
		arrLiN.add(new MenschMitName("Weidig"));
		arrLiN.add(new MenschMitName("Eggert"));
		arrLiN.add(new MenschMitName("Madl"));
		arrLiN.add(new MenschMitName("Krenz"));
		arrLiN.add(new MenschMitName("Muetze"));
		arrLiN.add(new MenschMitName("Weeg"));
		arrLiN.add(new MenschMitName("Josiger"));
		arrLiN.add(new MenschMitName("Wente"));
		
		System.out.println("\nMöglichkeit 2: Buchstaben-Werte vergleichen");
		// Eigener Comparator
		arrLiN.sort(new MenschMitNameComparator());
		System.out.println("Mit Comparator sortiert: " + Arrays.toString(arrLiN.toArray()));
	}
}


class MenschMitAlterComparator implements Comparator<MenschMitAlter> {

	@Override
	public int compare(MenschMitAlter o1, MenschMitAlter o2) {
		/**
		 * Gibt zurück:
		 * - 0 wenn beide gleich sind
		 * - Negativer Wert wenn links numerisch kleiner als rechts
		 * - Positiver Wert wenn links numerisch größer als rechts
		 */
		return o1.compareTo(o2);
	}

}

class MenschMitAlter{
	private int alter;
	
	public MenschMitAlter(int alter) {
		this.alter = alter;
	}
	
	//Möglichkeit 1 nach Alter (Zahl-Werten) zu vergleichen
	public int compareTo(MenschMitAlter o2) {
		//Rückgabe festlegen
		int rueckgabe = 0;
		//Wenn "Mein" Alter größer als das des anderen ist gebe 1 zurück 
		if(this.alter > o2.getAlter()) {
			rueckgabe = -1;
		} 
		
		//Wenn "Mein" Alter kleiner als das des anderen ist gebe -1 zurück
		if(this.alter < o2.getAlter()) {
			rueckgabe = 1;
		}
		
		//Sonst 0 == beide sind gleich
		return rueckgabe;
	}
	
	

	public int getAlter() {
		return alter;
	}
	
	@Override
	public String toString() {
		return "Alter: " + this.alter;
	}
}

class MenschMitNameComparator implements Comparator<MenschMitName> {

	@Override
	public int compare(MenschMitName o1, MenschMitName o2) {
		/**
		 * Gibt zurück:
		 * - 0 wenn beide gleich sind
		 * - Negativer Wert wenn links numerisch kleiner als rechts
		 * - Positiver Wert wenn links numerisch größer als rechts
		 */
		return o1.compareTo(o2);
	}

}


class MenschMitName{
	private String nachname;
	
	public MenschMitName(String nachname) {
		this.nachname = nachname;
	}

	//String < hat bereits eine compareTo welche die String lexikalisch miteinander vergleicht und somit eine Sortierung zulässt
	public int compareTo(MenschMitName o2) {
		int rueckgabe = 0;
			//Wenn es über 1 ist dann steht this.nachname höher in der lexikalischen Ordnung (sonst niedriger)
			//Je nachdem ob ich 1 oder -1 nutze kann ich ab oder aufsteigend sortieren
			if(this.nachname.compareTo(o2.getNachname()) > 0) {
				rueckgabe = 1;
			} 
			
			if (this.nachname.compareTo(o2.getNachname()) < 0) {
				rueckgabe = -1;
			}
		
		return rueckgabe;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.nachname;
	}
}
