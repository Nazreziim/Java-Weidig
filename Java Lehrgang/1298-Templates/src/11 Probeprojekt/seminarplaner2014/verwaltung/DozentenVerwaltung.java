package verwaltung;

import java.util.LinkedList;

import view.View;
import daten.Datenhaltung;
import daten.Dozent;


/**
 * @author c-ix-03-11
 * @version 1.0
 * @created 22-Jul-2014 11:56:50
 * In dieser Klasse k�nnen Dozenten aus der Liste entfernt und/oder ver�ndert(Name, Vorname, Fachgebiet) werden. 
 * Dar�ber hinaus gibt die Methode  "dozentenListeAusgeben" eine Liste mit Strings an die View weiter
 * 
 */


public class DozentenVerwaltung {
	
	


	private static DozentenVerwaltung dvInstance;

	public DozentenVerwaltung(){

	}

	/**
	 * Es wird aus den Dozenten-Objekten der Datenhaltungs-Listen eine LinkedList mit Strings erstellt, 
	 * die der View zur Ausgabe �bergeben wird 
	 * @param daten
	 */
	public void dozentenListeAusgeben(Datenhaltung daten){
		LinkedList<String> erg = new LinkedList<>();
		erg.add("Dozentenliste");
		if (daten.getDozenten() != null){
			for (Dozent dozent : daten.getDozenten()) {
				erg.add(" Dozent: \tName - " + dozent.getName() + " \tVorname - " +  dozent.getVorname() +
						" \tPersonalnummer - " +  dozent.getPersNr() + " \tFachgebiet - " +  dozent.getFachgebiet());
			}
		}

		// Gibt die LinkedList mit den Daten der Dozenten aus der Datenhaltung an die View_Methode showListe weiter
		View.showListe(erg);
	}

	/**
	 * Erstellt ein Dozent-Objekt und gibt es zur�ck!
	 * @param name
	 * @param vorname
	 * @param fachgebiet
	 */
	public Dozent dozentHinzufuegen(String name, String vorname, String fachgebiet){
		return new Dozent(name, vorname, fachgebiet);
	}

	/**
	 * Bearbeitet das Namen-Attribut des Dozent-Objektes
	 * @param doz
	 * @param name
	 */
	public void dozentBearbeitenName(Dozent doz, String name){
		doz.setName(name);
		View.show("Der Name wurde erfolgreich ge�ndert");
	}

	/**
	 * Bearbeitet das Vornamen-Attribut des Dozent-Objektes
	 * @param doz
	 * @param vorname
	 */
	public void dozentBearbeitenVorname(Dozent doz, String vorname){
		doz.setVorname(vorname);
		View.show("Der Vorname wurde erfolgreich ge�ndert");
	}

	/**
	 * Bearbeitet das Fachgebiet-Attribut des Dozent-Objektes
	 * @param doz
	 * @param fachgebiet
	 */
	public void dozentBearbeitenFachgebiet(Dozent doz, String fachgebiet){
		doz.setFachgebiet(fachgebiet);
		View.show("Das Fachgebiet wurde erfolgreich ge�ndert");
	}


	/**
	 * Diese Methode liefert das existierende Dozenten-Objekt zur�ck oder erstellt ein neues Dozent-Objekt
	 * @param doz
	 * @param name
	 */
	public static DozentenVerwaltung getInstance(){
		if (dvInstance == null){
			return dvInstance = new DozentenVerwaltung();
		}
		else{
			return dvInstance;
		}
	}
}//end DozentenVerwaltung