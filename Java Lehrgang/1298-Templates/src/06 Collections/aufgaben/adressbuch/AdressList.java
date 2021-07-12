package aufgaben.adressbuch;

import java.util.*;

public class AdressList {
	private Set<Kontakt> adList = new TreeSet<Kontakt>();

	public boolean insert(Kontakt k) {
		return adList.add(k);
	}
	
	public boolean delete(Kontakt k) {
		return adList.remove(k);
	}
	
	public void printAdr() {
		Iterator<Kontakt> it = adList.iterator();
		while (it.hasNext()) {
			it.next().printKontakt();
		}
	}
}
