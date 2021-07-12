package aufgaben.performancetest;

import java.util.*;

public class MeinIterator<T> implements Iterator<T> {

	private List<T> l;
	private int index; // Das ist der "Zeiger" des Iterators
	
	public MeinIterator(List<T> l) {
		this.l = l;
		this.index = 0;
	}
	
	
	public boolean hasNext() {
		return l.size() > index; 
	}


	public T next() {
		T el;
		el = l.get(index);
		index++;		
		return el;
	}


	public void remove() {

	}

}
