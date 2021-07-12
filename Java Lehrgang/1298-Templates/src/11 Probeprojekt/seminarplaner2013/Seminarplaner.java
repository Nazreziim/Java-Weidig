package seminarplaner2013;

import java.util.ArrayList;


/**
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:04
 */
public class Seminarplaner {
	private ArrayList<Dozent> dozentenListe = new ArrayList<Dozent>();
	private ArrayList<Kunde> kundenListe = new ArrayList<Kunde>();
	private ArrayList<Seminar> seminarListe = new ArrayList<Seminar>();
	private SeminarplanerView semPlanerView;
	private Datensicherung datensicherung;

	public Seminarplaner(){
		this.semPlanerView = new SeminarplanerView();
		this.datensicherung = new Datensicherung();
	}

	public void start(){
		int auswahl = this.semPlanerView.zeigeHauptmenue();
		switch(auswahl) {
		case 1: 
			new Seminarverwaltung(this).start();
			break;
		case 2: 
			new Kundenverwaltung(this).start();
			break;
		case 3:
			new Dozentenverwaltung(this).start();
			break;
		case 4: this.laden();
			break;
		case 5: this.speichern();
			break;
		default:
			System.exit(0);
		}
		start();
	}

	private void laden() {
		this.datensicherung.laden();
		this.kundenListe = this.datensicherung.getKundenSicherung();
		this.dozentenListe = this.datensicherung.getDozentenSicherung();
		this.seminarListe = this.datensicherung.getSeminarSicherung();
		start();
	}

	private void speichern() {
		this.datensicherung.speichern(this.kundenListe, this.dozentenListe, this.seminarListe);
		System.out.println("Seminarplaner gespeichert");
		start();
		
	}

	public ArrayList<Dozent> getDozenten(){
		return this.dozentenListe;
	}

	public ArrayList<Kunde> getKunden(){
		return this.kundenListe;
	}

	public ArrayList<Seminar> getSeminare(){
		return this.seminarListe;
	}
}//end Seminarplaner