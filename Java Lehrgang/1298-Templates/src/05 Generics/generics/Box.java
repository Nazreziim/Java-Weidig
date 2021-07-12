package generics;


/** Das ist eine Klasse mit generischem Typparameter
 * 
 */

public class Box<T> {
	private T val;
	
	public Box(T val) {
		this.val = val;		
	}
	
	/**
	 * @return the val
	 */
	public T getVal() {
		return val;
	}

	/**
	 * @param val the val to set
	 */
	public void setVal(T val) {
		this.val = val;
	}
	
}
