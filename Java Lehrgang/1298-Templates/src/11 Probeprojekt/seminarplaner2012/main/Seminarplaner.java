package seminarplaner2012.main;

import seminarplaner2012.control.Dozentenverwaltung;
import seminarplaner2012.control.Kundenverwaltung;
import seminarplaner2012.control.Seminarverwaltung;
import seminarplaner2012.view.DozentenView;
import seminarplaner2012.view.KundenView;
import seminarplaner2012.view.SeminarView;
import seminarplaner2012.view.SeminarplanerView;



/**
 * @author dborkowitz
 * @version 1.0
 * @created 04-Mai-2012 09:48:45
 */
public class Seminarplaner {

	private Kundenverwaltung kundenverwaltung;
	private Seminarverwaltung  seminarverwaltung ;
	private Dozentenverwaltung dozentenverwaltung;
	private SeminarplanerView view;

	public Seminarplaner(){
		this.kundenverwaltung = new Kundenverwaltung();
		this.kundenverwaltung.setView(new KundenView());
		
		this.seminarverwaltung = new Seminarverwaltung();
		this.seminarverwaltung.setView(new SeminarView());
		
		this.dozentenverwaltung = new Dozentenverwaltung();
		this.dozentenverwaltung.setView(new DozentenView());
		
		this.view = new SeminarplanerView();
		
	}
	public void kundenVerwaltungAnzeigen(){
		this.kundenverwaltung.starten();
	}

	public void dozentenVerwaltungAnzeigen(){
		this.dozentenverwaltung.starten();
	}

	public void seminarVerwaltungAnzeigen(){
		this.seminarverwaltung.starten();
	}
	
	public static void main(String[] args){
		Seminarplaner sem = new Seminarplaner();
		sem.start();
	}
	private void start() {
		int eingabe = 0;
		do{
			eingabe = this.view.menue();
			switch(eingabe){
			case 1: 
				this.kundenverwaltung.starten();
				break;
			case 2:
				this.dozentenverwaltung.starten();
				break;
			case 3:
				this.seminarverwaltung.starten();
			}
		}while(eingabe != 0);
	}
}//end Seminarplaner