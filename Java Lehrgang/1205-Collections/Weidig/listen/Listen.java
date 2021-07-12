package listen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Listen {
	public static void main(String[] args) {

		// SYNTAX //

		/**
		 * GROB: Eine ArrayList arbeitet im Hintergrund mit Arrays. Wird etwas
		 * hinzugef�gt wird ein neues Array erstellt mit der neuen L�nge und die Werte
		 * des bestehenden in das Neue �bernommen. Daher bietet es sich an die L�nge der
		 * ArrayList vorher festzulegen um hier Performance zu sparen (Richtwert =
		 * Doppelte der anzunehmenden Anzahl an Werten) ACHTUNG: Die sichtbare Menge an
		 * Werten (Debugger) sind nur die welche wir auch nutzen. Sollte ich �ber die
		 * 5000 Pl�tze hinaus gehen wird wieder ein neues Array erzeugt (Performance)
		 */
		ArrayList<Integer> arrLi = new ArrayList<>(5000);
		// ^ Macht eine ArrayList mit 5000 M�GLICHEN Pl�tzen

		/**
		 * HINWEIS: VEKTOREN SOLLTEN NICHT GENUTZT WERDEN Vektoren sind
		 * "vollsynchronisiert". Im ersten Moment k�nnte man meinen, dass dies sinnvoll
		 * w�re wenn man eine Nebenl�ufigkeit (Threads) nutzen m�chte. Jedoch ist bei
		 * Vector jede Methode synchronized. Dies bedeutet, dass es nach jeder Anweisung
		 * synchronisiert. Dies macht die Methoden automatisch sehr langsam auch bei der
		 * Verwendung von Threads. Jedoch m�chte man in der Regel mehrere Anweisungen
		 * also eine Sequenz von Operationen synchronisieren nicht jedoch jede einzelne
		 * Operation
		 */
		Vector<Integer> v = new Vector<>();

		/**
		 * LinkedList implementiert das Dequeue und dar�ber das Queue Interface Queues
		 * sind �hnlich wie Listen, jedoch, dass diese entweder nur ihren Anfang (Queue)
		 * oder Anfang und Ende (Dequeue) nutzen k�nnen [Zweifach verkettete Liste].
		 * Dies nutzt man haupts�chlich wenn ich schnellen Zugriff auf Elemente m�chte
		 * welche nahe am Ende oder am Anfang sind. Sogenannte Sequenzielle Zugriffe.
		 */
		LinkedList<Integer> liLi = new LinkedList<>();

		// Wichtige Methoden//
		
		arrLi.add(null);

		// Hinzuf�gen immer hintereinander
		arrLi.add(1);
		arrLi.add(2);
		arrLi.add(3);
		arrLi.add(4);

		// Setzt an Index 2 die 5 und schiebt alles andere nach rechts
		arrLi.add(2, 5);

		// Hinweis auf die Uhr der add Methode von Vektor [Beim Vorschlag]
		// --> synchronisiert
		v.add(1);

		// LinkedList (Zweifach verkettete Listen [Dequeue]) kennen ihr Anfang/Ende
		liLi.addFirst(2);
		liLi.addLast(1);

		// Iterieren

		System.out.println("SO AB SOFORT NICHT MEHR!! \nAU�ER: Man m�chte nur bis zu einer bestimmten Stelle");
		for (int i = 0; i < arrLi.size(); i++) {
			System.out.println(arrLi.get(i));
		}

		System.out.println("\nM�glichkeit 1: Klassische ForEach");
		for (int i : arrLi) {
			System.out.println(i);
		}

		System.out.println("\nM�glichkeit 2: Iterator");
		// Iterator �ber die Methode erstellen (Eigenen Iterator werden wir noch
		// erstellen)
		Iterator<Integer> it = arrLi.listIterator();
		// Solange das n�chste Element vorhanden ist
		while (it.hasNext()) {
			// Gebe mir das n�chste Element aus und setze den Cursor auf die n�chste
			// Position (Debugger)
			System.out.println(it.next());
		}
		// Man sieht: Ein Iterator wird bei der Nutzung automatisch eins weitergeschoben

		/**
		 * WOF�R ITERATOR? Mit sp�ter selbstgebauten Iteratoren kann ich Regeln
		 * festlegen auf exakt welche Stellen ich springen m�chte und k�nnte diese dann
		 * ver�ndern.
		 */

		System.out.println("\nM�glichkeit 3: Lambda ForEach");
		arrLi.forEach(einInteger -> System.out.println(einInteger));

		System.out.println("\nM�glichkeit 4: Selbstgebauter Iterator");
		MeinEigenerListenIterator<Integer> mELI = new MeinEigenerListenIterator<>(arrLi);
		// Solange das n�chste Element vorhanden ist
		while (mELI.hasNext()) {
			// Gebe mir das n�chste Element aus und setze den Cursor auf die n�chste
			// Position (Debugger)
			System.out.println(mELI.next());
		}

		// Sortieren
		System.out.println("\nM�glichkeit 1: Algorithmus");
		arrSort(arrLi);

		System.out.println("\nM�glichkeit 2: Vorhandene Methode");
		// Nach nat�rlicher Reihenfolge sortiert
		/** HINWEIS: ES MUSS EINE NAT�RLICHE REIHENFOLGE EXISTIEREN **/
		Collections.sort(arrLi);
		arrLi.sort(null); // Macht das gleiche

		System.out.println("Nat�rlich sortiert: " + arrLi);
		// Umgedreht sortiert
		Collections.reverse(arrLi);
		System.out.println("Umgedreht sortiert: " + arrLi);

		System.out.println("\nM�glichkeit 3: Eigenen Comparator");
		// Eigener Comparator
		arrLi.sort(new PrimitiverComparator());
		System.out.println("Mit Comparator sortiert: " + arrLi);

	}

	public static void arrSort(List<Integer> l) {
		// Iteriert �ber die Liste und wechselt die Zahlen miteinander
		for (int i = 0; i < l.size() - 1; i++) {
			if (l.get(i) > l.get(i + 1)) {
				int tmp = l.get(i);
				l.remove(i);
				l.add(i + 1, tmp);
			}
		}
		
		System.out.println(l);
		// Ich kann auch meine Liste zu einem Array machen und dieses auslesen bzw. alle Array Methoden nutzen
		//System.out.println(Arrays.toString(l.toArray()));
	}
}
