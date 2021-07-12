package iteratorComparator;

import java.util.Iterator;

public class IteratorInteger implements Iterator<Integer> {

	private ListeIter liste;
	private int aktuellePos;
	
	public IteratorInteger(ListeIter liste){
		this.liste = liste;
		this.aktuellePos = 0;
		liste.iterator();
	}
	
	@Override
	public boolean hasNext() {
		if ( liste.anzahlElemente() - 2 >= aktuellePos) {
			return true;
		} 
		else {
			return false;
		}
	}

	@Override
	public Integer next() {
		Integer wert = null;
		aktuellePos += 2;
		
		liste.next();
		wert = liste.next();			
		return wert;
	}

}
