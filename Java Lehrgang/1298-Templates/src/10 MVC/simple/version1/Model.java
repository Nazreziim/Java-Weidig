package simple.version1;

public class Model implements ModelInterface {
	private int ctr = 0;
	
	/**
	 * Erh�ht den Z�hler um 1
	 */
	@Override
	public void inkr() {
		ctr++;
	}

	/** 
	 * Verringert den Z�hler um 1
	 */
	@Override
	public void dekr() {
		ctr--;
	}
	
	@Override
	public int getCtr() {
		return ctr;
	}
}
