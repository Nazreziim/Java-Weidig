package seminarplaner2012.model;

import java.util.LinkedList;
import java.util.List;

import seminarplaner2012.domain.Dozent;
import seminarplaner2012.domain.Seminar;



/**
 * @author c-ix-03-01
 * @version 1.0
 * @created 04-Mai-2012 09:48:44
 */
public class Seminarbestand {

	private List<Seminar> seminare;
	private List<Seminar> seminarArchiv;

	public Seminarbestand(){
		this.seminare=new LinkedList<Seminar>();
		this.seminarArchiv=new LinkedList<Seminar>();
	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param s
	 */
	public void hinzufuegen(Seminar s){

	}

	/**
	 * 
	 * @param d
	 */
	public void hinzufuegenDozent(Dozent d){

	}

	/**
	 * 
	 * @param s
	 */
	public void archivieren(Seminar s){

	}

	/**
	 * 
	 * @param nr
	 */
	public Seminar lieferSeminar(int nr){
		return null;
	}
}//end Seminarbestand