package seminarplaner2012.control;

import seminarplaner2012.model.Dozentenbestand;
import seminarplaner2012.view.DozentenView;



/**
 * @author c-ix-03-02
 * @version 1.0
 * @created 04-Mai-2012 09:48:44
 */
public class Dozentenverwaltung {

	private Dozentenbestand dozentenbestand;
	private DozentenView view;

	public Dozentenverwaltung(){
		this.dozentenbestand = new Dozentenbestand();
		this.view = null;
	}

	public void finalize() throws Throwable {

	}
	public void dozentenAnzeigen(){

	}

	public void dozentenErstellen(){

	}

	public void dozentenArchivieren(){

	}

	public void dozentenAendern(){

	}

	public void starten(){

	}

	public void dozentenArchivZeigen(){

	}

	public void setView(DozentenView d){
		this.view = d;
	}
}