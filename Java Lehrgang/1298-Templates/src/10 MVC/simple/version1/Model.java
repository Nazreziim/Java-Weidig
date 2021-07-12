package simple.version1;

public class Model implements ModelInterface {
	private int ctr = 0;
	
	/**
	 * Erhöht den Zähler um 1
	 */
	@Override
	public void inkr() {
		ctr++;
	}

	/** 
	 * Verringert den Zähler um 1
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
