package seminarplaner2012.model;
import java.util.LinkedList;
import java.util.List;

import seminarplaner2012.domain.Dozent;



/**
 * @author c-ix-03-02
 * @version 1.0
 * @created 04-Mai-2012 09:48:44
 */
public class Dozentenbestand {

	private List<Dozent> dozenten;
	private List<Dozent> dozentenArchiv;

	public Dozentenbestand(){
		this.dozenten = new LinkedList<Dozent>();
		this.dozentenArchiv = new LinkedList<Dozent>();
	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param d
	 */
	public void hinzufuegen(Dozent d){

	}

	/**
	 * 
	 * @param d
	 */
	public void loeschen(Dozent d){

	}

	/**
	 * 
	 * @param nr
	 */
	public Dozent lieferDozent(int nr){
		return null;
	}
}//end Dozentenbestand