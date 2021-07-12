package iteratorComparator;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Ein StepOverIterator liefert jedes zweite Element einer Collection zurück
 * @author lgerhard
 *
 * @param <E>
 */
public class StepOverIterator<E> implements Iterator<E> {

	private List<E> coll;
	private int pos;
	
	public StepOverIterator(List<E> coll) {
		super();
		this.coll = coll;
		this.pos = -2;
	}

	
	@Override
	public boolean hasNext() {
		if (coll.size() - 2 > pos) {
			return true;
		} else {
			return false;
		}
		
		// return (coll.size() - 2 > pos);  
		
	}

	@Override
	public E next() {
		pos += 2;
		return coll.get(pos);		
	}

	@Override
	public void remove() {
		
	}

}
