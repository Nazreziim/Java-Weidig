package observer.version2_java_util;
/**
 * Das Interface sollte von jedem expliziten Model implementiert werden. Es stellt die Vorgaben an Methoden zum Erhöhen
 * und Verringern eines Zählers zur Verfügung.
 * @author LGerhard
 *
 */
public interface ModelInterface {

	/**
	 * Erhöht den Zähler um 1
	 */
	public abstract void inkr();

	/** 
	 * Verringert den Zähler um 1
	 */
	public abstract void dekr();

	public abstract int getCtr();

}