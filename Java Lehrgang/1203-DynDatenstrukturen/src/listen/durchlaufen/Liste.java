package listen.durchlaufen;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Liste implements  Iterator<ListenElement>, Iterable<ListenElement>{
	ListenElement start;
	// gehört zum Iterator
	private ListenElement current;
	
	public void add(int wert){
		
		this.start = new ListenElement(wert,this.start);
	}
	
	public void ausgabe(){
		ListenElement hilf = start;
		while (hilf != null){
			System.out.println(hilf);
			hilf = hilf.getNext();
		}
	}

	public int besucheAlleElemente(Aktion aktion){
		int erg = 0;
		
		for (ListenElement element : this){
			if (aktion != null){
				erg = aktion.aktion(element.getInhalt());
			}
		}
		return erg;
	}
	
	/**
	 * muss von Iterator-Interface gesetzt werden.
	 */
	@Override
	public boolean hasNext() {
		
		return (current != null);
	}

	/**
	 * muss von Iterator-Interface gesetzt werden.
	 */
	@Override
	public ListenElement next() {
		
		if (!hasNext()){
			throw new NoSuchElementException("Kein Element in der Liste!");
		}
		
		ListenElement hilf = current;
		current = current.getNext();
		return hilf;
	}
/*
	/**
	 * muss von Iterable-Interface implementiert werden.
	 * Startwert der Liste setzen und gibt einen
	 * Iterator zurueck! Also muss auch ein
	 * Iterator-Interface vorhanden sein!
	 */
	@Override
	public Iterator<ListenElement> iterator() {
		this.current = this.start;
		return this;
	}


	
}
