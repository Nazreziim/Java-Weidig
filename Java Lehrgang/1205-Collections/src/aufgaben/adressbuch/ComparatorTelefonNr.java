package aufgaben.adressbuch;

import java.util.Comparator;

public class ComparatorTelefonNr implements Comparator<Kontakt> {

	@Override
	public int compare(Kontakt o1, Kontakt o2) {
		
		return o1.getTelNr().compareTo(o2.getTelNr());
	}

}
