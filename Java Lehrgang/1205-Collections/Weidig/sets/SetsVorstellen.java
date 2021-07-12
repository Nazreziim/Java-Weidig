package sets;

import java.util.Comparator;
import java.util.HashSet;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetsVorstellen {

	public static void main(String[] args) {
		HashSet<Integer> hsI = new HashSet<>();
		
		// Wird hinzugef�gt und kann ausgegeben werden
		hsI.add(null);

		int a = 1;

		hsI.add(a++);
		hsI.add(a++);
		hsI.add(a++);
		hsI.add(a++);
		hsI.add(a++);

		// Wird nicht hinzugef�gt, da ein identisches bereits vorhanden ist
		hsI.add(5);

		System.out.println(hsI);

		// Entfernt ALLES aus dem Set
		hsI.clear();

		System.out.println(hsI);

		HashSet<String> hsS = new HashSet<>();

		hsS.add("Weidig");
		hsS.add("Wente");
		hsS.add("Josiger");
		hsS.add("Muetze");
		hsS.add("Krenz");
		hsS.add("Madl");
		hsS.add("Eggert");
		hsS.add("Weeg");

		// Wird nicht hinzugef�gt, da identisches bereits vorhanden ist
		System.out.println(
				"Weeg hinzugef�gt? - " + hsS.add("Weeg") + " - .add gibt true zur�ck wenn der Prozess erfolgreich war.");
		System.out.println("Weeg schon vorhanden? - " + hsS.contains("Weeg")
				+ " - .contains �berpr�ft ob der Wert bereits enthalten ist.");

		// Sortierung immer gleich aber wahllos ohne echte Regeln
		System.out.println(hsS);

		// Sortierung nach Insertion order
		LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
		lhs.add(5);
		lhs.add(2);
		lhs.add(3);
		lhs.add(1);
		lhs.add(4);

		System.out.println(lhs);

		// Sortiert automatisch nach nat�rlicher Ordnung
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(5);
		ts.add(2);
		ts.add(3);
		ts.add(1);
		ts.add(4);

		System.out.println(ts);

		// Auch Strings
		TreeSet<String> sts = new TreeSet<>();
		sts.add("Weidig");
		sts.add("Wente");
		sts.add("Josiger");
		sts.add("Muetze");
		sts.add("Krenz");
		sts.add("Madl");
		sts.add("Eggert");
		sts.add("Weeg");

		System.out.println(sts);

		/**
		 * Hinweis: Es gibt viele viele Collections und davon viele n�tzliche Methoden
		 * ab hier ist es notwendig, dass man schaut was vorhanden ist und was man
		 * sinnvoll nutzen k�nnte und wie man es benutzt.
		 */

		// Nutzt einen eigenen Comparator f�r das TreeSet
		TreeSet<MenschMitAlter> tsM = new TreeSet<>(new MenschMitAlterComparator());

		tsM.add(new MenschMitAlter(1));
		tsM.add(new MenschMitAlter(2));
		tsM.add(new MenschMitAlter(4));
		tsM.add(new MenschMitAlter(5));
		tsM.add(new MenschMitAlter(3));

		System.out.println(tsM);
	}

}

class MenschMitAlterComparator implements Comparator<MenschMitAlter> {

	@Override
	public int compare(MenschMitAlter o1, MenschMitAlter o2) {
		/**
		 * Gibt zur�ck: - 0 wenn beide gleich sind - Negativer Wert wenn links numerisch
		 * kleiner als rechts - Positiver Wert wenn links numerisch gr��er als rechts
		 */
		return o1.compareTo(o2);
	}

}

class MenschMitAlter {
	private int alter;

	public MenschMitAlter(int alter) {
		this.alter = alter;
	}

	// M�glichkeit 1 nach Alter (Zahl-Werten) zu vergleichen
	public int compareTo(MenschMitAlter o2) {
		// R�ckgabe festlegen
		int rueckgabe = 0;
		// Wenn "Mein" Alter gr��er als das des anderen ist gebe 1 zur�ck
		if (this.alter > o2.getAlter()) {
			rueckgabe = -1;
		}

		// Wenn "Mein" Alter kleiner als das des anderen ist gebe -1 zur�ck
		if (this.alter < o2.getAlter()) {
			rueckgabe = 1;
		}

		// Sonst 0 == beide sind gleich
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
