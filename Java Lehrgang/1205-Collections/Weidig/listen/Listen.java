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
		 * hinzugefügt wird ein neues Array erstellt mit der neuen Länge und die Werte
		 * des bestehenden in das Neue übernommen. Daher bietet es sich an die Länge der
		 * ArrayList vorher festzulegen um hier Performance zu sparen (Richtwert =
		 * Doppelte der anzunehmenden Anzahl an Werten) ACHTUNG: Die sichtbare Menge an
		 * Werten (Debugger) sind nur die welche wir auch nutzen. Sollte ich über die
		 * 5000 Plätze hinaus gehen wird wieder ein neues Array erzeugt (Performance)
		 */
		ArrayList<Integer> arrLi = new ArrayList<>(5000);
		// ^ Macht eine ArrayList mit 5000 MÖGLICHEN Plätzen

		/**
		 * HINWEIS: VEKTOREN SOLLTEN NICHT GENUTZT WERDEN Vektoren sind
		 * "vollsynchronisiert". Im ersten Moment könnte man meinen, dass dies sinnvoll
		 * wäre wenn man eine Nebenläufigkeit (Threads) nutzen möchte. Jedoch ist bei
		 * Vector jede Methode synchronized. Dies bedeutet, dass es nach jeder Anweisung
		 * synchronisiert. Dies macht die Methoden automatisch sehr langsam auch bei der
		 * Verwendung von Threads. Jedoch möchte man in der Regel mehrere Anweisungen
		 * also eine Sequenz von Operationen synchronisieren nicht jedoch jede einzelne
		 * Operation
		 */
		Vector<Integer> v = new Vector<>();

		/**
		 * LinkedList implementiert das Dequeue und darüber das Queue Interface Queues
		 * sind ähnlich wie Listen, jedoch, dass diese entweder nur ihren Anfang (Queue)
		 * oder Anfang und Ende (Dequeue) nutzen können [Zweifach verkettete Liste].
		 * Dies nutzt man hauptsächlich wenn ich schnellen Zugriff auf Elemente möchte
		 * welche nahe am Ende oder am Anfang sind. Sogenannte Sequenzielle Zugriffe.
		 */
		LinkedList<Integer> liLi = new LinkedList<>();

		// Wichtige Methoden//
		
		arrLi.add(null);

		// Hinzufügen immer hintereinander
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

		System.out.println("SO AB SOFORT NICHT MEHR!! \nAUßER: Man möchte nur bis zu einer bestimmten Stelle");
		for (int i = 0; i < arrLi.size(); i++) {
			System.out.println(arrLi.get(i));
		}

		System.out.println("\nMöglichkeit 1: Klassische ForEach");
		for (int i : arrLi) {
			System.out.println(i);
		}

		System.out.println("\nMöglichkeit 2: Iterator");
		// Iterator über die Methode erstellen (Eigenen Iterator werden wir noch
		// erstellen)
		Iterator<Integer> it = arrLi.listIterator();
		// Solange das nächste Element vorhanden ist
		while (it.hasNext()) {
			// Gebe mir das nächste Element aus und setze den Cursor auf die nächste
			// Position (Debugger)
			System.out.println(it.next());
		}
		// Man sieht: Ein Iterator wird bei der Nutzung automatisch eins weitergeschoben

		/**
		 * WOFÜR ITERATOR? Mit später selbstgebauten Iteratoren kann ich Regeln
		 * festlegen auf exakt welche Stellen ich springen möchte und könnte diese dann
		 * verändern.
		 */

		System.out.println("\nMöglichkeit 3: Lambda ForEach");
		arrLi.forEach(einInteger -> System.out.println(einInteger));

		System.out.println("\nMöglichkeit 4: Selbstgebauter Iterator");
		MeinEigenerListenIterator<Integer> mELI = new MeinEigenerListenIterator<>(arrLi);
		// Solange das nächste Element vorhanden ist
		while (mELI.hasNext()) {
			// Gebe mir das nächste Element aus und setze den Cursor auf die nächste
			// Position (Debugger)
			System.out.println(mELI.next());
		}

		// Sortieren
		System.out.println("\nMöglichkeit 1: Algorithmus");
		arrSort(arrLi);

		System.out.println("\nMöglichkeit 2: Vorhandene Methode");
		// Nach natürlicher Reihenfolge sortiert
		/** HINWEIS: ES MUSS EINE NATÜRLICHE REIHENFOLGE EXISTIEREN **/
		Collections.sort(arrLi);
		arrLi.sort(null); // Macht das gleiche

		System.out.println("Natürlich sortiert: " + arrLi);
		// Umgedreht sortiert
		Collections.reverse(arrLi);
		System.out.println("Umgedreht sortiert: " + arrLi);

		System.out.println("\nMöglichkeit 3: Eigenen Comparator");
		// Eigener Comparator
		arrLi.sort(new PrimitiverComparator());
		System.out.println("Mit Comparator sortiert: " + arrLi);

	}

	public static void arrSort(List<Integer> l) {
		// Iteriert über die Liste und wechselt die Zahlen miteinander
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
