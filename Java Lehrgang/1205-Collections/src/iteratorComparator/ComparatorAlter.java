package iteratorComparator;

import java.util.Comparator;

public class ComparatorAlter implements Comparator<Mensch> {

	@Override
	public int compare(Mensch o1, Mensch o2) {
		
		return Integer.valueOf(o1.getAlter()).compareTo(o2.getAlter());
	}

}
