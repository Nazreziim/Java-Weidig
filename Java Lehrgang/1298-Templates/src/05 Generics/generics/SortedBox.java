package generics;



public class SortedBox<T extends Comparable>  {  // extends geht bei gen. Typparam. auch für Interfaces

	private T val;
	
	public SortedBox(T val) {
		this.val = val;	
	}
	
//	public int vergleicheMit(SortedBox<T> el) {
//		return this.val.compareTo(el.val);
//	}
	
	public T gibGroesser(SortedBox<T> el) {
		T erg;
		if (this.val.compareTo(el.val) > 0 ) {
			erg = this.val;
		} else {
			erg = el.val;
		}
		return erg;
	}
}
