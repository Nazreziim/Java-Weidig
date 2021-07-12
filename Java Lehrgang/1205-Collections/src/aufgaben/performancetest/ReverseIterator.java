package aufgaben.performancetest;

import java.util.*;
import java.util.Iterator;


public class ReverseIterator<E> implements Iterator<E> {

	int pos;
	List<E> l;
	
	public ReverseIterator(List<E> l) {
		this.l = l;
		this.pos = l.size();
	}

    
	 
    public boolean hasNext() {
        return (pos > 0);
    }

    public E next() {
        return l.get(--pos);
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}