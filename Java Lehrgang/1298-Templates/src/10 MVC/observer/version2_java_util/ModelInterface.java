package observer.version2_java_util;
/**
 * Das Interface sollte von jedem expliziten Model implementiert werden. Es stellt die Vorgaben an Methoden zum Erh�hen
 * und Verringern eines Z�hlers zur Verf�gung.
 * @author LGerhard
 *
 */
public interface ModelInterface {

	/**
	 * Erh�ht den Z�hler um 1
	 */
	public abstract void inkr();

	/** 
	 * Verringert den Z�hler um 1
	 */
	public abstract void dekr();

	public abstract int getCtr();

}