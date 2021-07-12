package listen;

import java.util.Comparator;

public class PrimitiverComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		/**
		 * Gibt zurück:
		 * - 0 wenn beide gleich sind
		 * - Negativer Wert wenn links numerisch kleiner als rechts
		 * - Positiver Wert wenn links numerisch größer als rechts
		 */
		return o1.compareTo(o2);
	}

}
