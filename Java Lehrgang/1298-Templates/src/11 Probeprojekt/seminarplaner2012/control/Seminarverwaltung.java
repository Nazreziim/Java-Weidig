package seminarplaner2012.control;

import seminarplaner2012.model.Seminarbestand;
import seminarplaner2012.view.SeminarView;



/**
 * @author c-ix-03-01
 * @version 1.0
 * @created 04-Mai-2012 09:48:45
 */
public class Seminarverwaltung{

	private Seminarbestand seminarbestand;
	private SeminarView view;

	public Seminarverwaltung (){
		seminarbestand=new Seminarbestand();		
	}



	public void finalize() throws Throwable {

	}
	public void seminareAnzeigen(){

	}

	public void seminarErstellen(){

	}

	public void seminarArchivieren(){

	}

	public void seminarAaendern(){

	}

	public void starten(){

	}

	public void seminarArchivZeigen(){

	}

	/**
	 * 
	 * @param v
	 */
	public void setView(SeminarView v){
		this.view=v;
	}
}//end Seminarverwaltung 