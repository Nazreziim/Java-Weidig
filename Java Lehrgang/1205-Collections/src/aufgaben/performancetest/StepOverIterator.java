package aufgaben.performancetest;
import java.util.*;
import java.util.Iterator;

public class StepOverIterator<E> implements Iterator<E> {
	
		int pos = 0;
		List<E> l;
		
		public StepOverIterator(List<E> l) {
			this.l = l;
			this.pos = 0;
		}

	    
		 
	    public boolean hasNext() {
	        return (pos < (l.size()-2));
	    }

	    public E next() {
	        return l.get(pos += 2);
	    }

	    public void remove() {
	        throw new UnsupportedOperationException("Not supported yet.");
	    }
	}