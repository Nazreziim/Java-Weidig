/**
 * 
 */
package generics;

/**
 * Eine Box mit Boundaries
 * @author LGerhard
 *
 */
public class ZahlenBox<T extends Number>  {
	T val;
	
	public ZahlenBox(T val) {
		this.val = val;
	}
	
	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

	public T addiere(T nummer) {
		T erg;

		erg = (T)(Double)(this.val.doubleValue() + nummer.doubleValue());
		
		return erg;
	}


}
