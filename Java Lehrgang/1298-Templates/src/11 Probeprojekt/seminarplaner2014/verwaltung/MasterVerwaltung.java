package verwaltung;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import view.View;
import daten.Adresse;
import daten.Datenhaltung;
import daten.Dozent;
import daten.Seminar;
import daten.Teilnehmer;


/**
 * @author c-ix-03-11
 * @version 1.0
 * @created 22-Jul-2014 11:56:55
 */
public class MasterVerwaltung {

	private static MasterVerwaltung instance;
	private Datenhaltung daten;
	private DozentenVerwaltung dv;
	private SeminarVerwaltung sv;
	private TeilnehmerVerwaltung tv;
	

	private MasterVerwaltung(){
		daten = new Datenhaltung();
		dv = DozentenVerwaltung.getInstance();
		sv = SeminarVerwaltung.getInstance();
		tv = TeilnehmerVerwaltung.getInstance();
	}
	
	public static MasterVerwaltung getInstance() {
		if (instance == null)
			instance = new MasterVerwaltung();
		return instance;
	}
	
	


	/**
	 * Fügt einen Dozenten in der passenden Liste der Datenhaltung sortiert mit ein.
	 * Sorgt außerdem dafür, dass ein Dozent nicht mehrmals existiert
	 * 
	 * @param doz
	 */
	public void addDozent(Dozent doz){
		String s = "Der Dozent mit der PersNr " + doz.getPersNr();
		if (!daten.getDozenten().contains(doz)){
			daten.getDozenten().add(doz);
			s += " wurde hinzugefügt.";
		} else {
			s += " ist bereits vorhanden." ;
		}
		View.show(s);
	}

	/**
	 * 
	 * @param sem
	 */
	public void addSeminar(Seminar sem){
		String s = "Das Seminar mit dem Titel " + sem.getTitel();
		if (!daten.getSeminare().contains(sem)){
			daten.getSeminare().add(sem);
			s += " wurde hinzugefügt.";
		} else {
			s += " ist bereits vorhanden." ;
		}
		View.show(s);
	}

	/**
	 * Fügt ein Teilnehmer-Objekt in die entsprechende Liste in daten ein, und
	 * kontrolliert dabei, ob es den Teilnehmer schon gibt!
	 * 
	 * @param tln
	 */
	public void addTeilnehmer(Teilnehmer tln){
		String s = "Der Teilnehmer mit der ID " + tln.getId();
		if (!daten.getTeilnehmer().contains(tln)){
			daten.getTeilnehmer().add(tln);
			s += " wurde hinzugefügt.";
		} else {
			s += " ist bereits vorhanden." ;
		}
		View.show(s);
	}

	/**
	 * Löscht das Dozenten-Objekt mit der übergebenen Id aus der Liste der
	 * Datenhaltung
	 * 
	 * @param id
	 */
	public void dropDozent(int id){
		dropDozent(getDozentFromId(id));
	}

	/**
	 * Löscht das Dozenten-Objekt aus der Liste der
	 * Datenhaltung
	 * 
	 * @param id
	 */
	public void dropDozent(Dozent doz){
		if (daten.getDozenten().remove(doz))
			View.show("Der Dozent mit der Id " + doz.getId() + " wurde gelöscht.");
		else
			View.show("Der Dozent mit der Id " + doz.getId() + " konnte nicht gelöscht werden.");
	}

	/**
	 * Löscht das Seminar-Objekt mit dem übergebenen Titel aus der Liste der
	 * Datenhaltung
	 * 
	 * @param title
	 */
	public void dropSeminar(String title){
		dropSeminar(getSeminarFromTitle(title));
	}

	/**
	 * Löscht das Seminar-Objekt aus der Liste der
	 * Datenhaltung
	 * 
	 * @param title
	 */
	public void dropSeminar(Seminar sem){
		if (daten.getSeminare().remove(sem))
			View.show("Das Seminar mit dem Titel " + sem.getTitel() + " wurde gelöscht.");
		else
			View.show("Das Seminar mit dem Titel " + sem.getTitel() + " konnte nicht gelöscht werden.");
	}

	/**
	 * Löscht das Teilnehmer-Objekt aus der Liste der
	 * Datenhaltung
	 * 
	 * @param id
	 */
	public void dropTeilnehmer(Teilnehmer tln){
		if (daten.getTeilnehmer().remove(tln))
			View.show("Der Teilnehmer mit der Id " + tln.getId() + " wurde gelöscht.");
		else
			View.show("Der Teilnehmer mit der Id " + tln.getId() + " konnte nicht gelöscht werden.");
	}

	/**
	 * Löscht das Teilnehmer-Objekt mit der übergebenen Id aus der Liste der
	 * Datenhaltung
	 * 
	 * @param id
	 */
	public void dropTeilnehmer(int id){
		dropTeilnehmer(getTeilnehmerFromId(id));
	}

	public void showDatenVerwaltung(){
		List<String> menuItems = new LinkedList<>();
		menuItems.add("Datenverwaltung");
		menuItems.add("Daten laden");
		menuItems.add("Daten speichern");
		menuItems.add("Zurück zum Hauptmenü");
		int auswahl = View.showMenu(menuItems);
		switch (auswahl) {
		case 1:
			daten.laden();
			showMainMenu();
			break;
		case 2:
			daten.speichern();
			showMainMenu();
			break;
		case 3:
			showMainMenu();
			break;
		default:
			View.show(fehlerNachricht(auswahl));
			showDatenVerwaltung();
			break;
		}
	}

	/**
	 * Dozentenverwaltungsmenü anzeigen
	 */
	private void showDozentenVerwaltung(){
		// Dozentenliste ausgeben
		dv.dozentenListeAusgeben(daten);
		
		// Dozentenmenü ausgeben
		List<String> menuItems = new LinkedList<>();
		menuItems.add("Dozentenverwaltung");
		menuItems.add("Dozent hinzufügen");
		menuItems.add("Dozent auswählen");
		menuItems.add("Zurück zum Hauptmenü");
		int auswahl = View.showMenu(menuItems);
		switch (auswahl) {
		case 1:
			dozentHinzufuegen();
			showDozentenVerwaltung();
			break;
		case 2:
			Dozent doz = dozentAuswaehlen();
			showDozentenAuswahl(doz);
//			showDozentenVerwaltung();
			break;
		case 3:
			showMainMenu();
			break;
		default:
			View.show(fehlerNachricht(auswahl));
			showDozentenVerwaltung();
			break;
		}
	}
	
	/**
	 * Abfrage-Menü zum Hinzufügen eines Dozenten 
	 */
	private void dozentHinzufuegen() {
		String name = View.readString("Name des Dozenten eingeben:");
		String vorname = View.readString("Vorname des Dozenten eingeben:");
		String fachgebiet = View.readString("Fachgebiet des Dozenten eingeben:");
		addDozent(dv.dozentHinzufuegen(name, vorname, fachgebiet));
	}
	
	/**
	 * Menüpunkt zum Auswählen eines Dozenten aus der Liste aus Datenhaltung
	 * @return
	 */
	private Dozent dozentAuswaehlen() {
		int dozAuswahl = View.readInt("Bitte Dozentenlistenpositionsnummer eingeben:");
		Dozent doz = null;
		Iterator<Dozent> it = daten.getDozenten().iterator();
		int i = 0;
		while (i < dozAuswahl) {
			doz = it.next();
			i++;
		}
		return doz;
	}
	
	/**
	 * Zeige das Menü, das einen Dozenten ändern kann
	 * 
	 * @param doz
	 */
	private void dozentAendern(Dozent doz) {
		// Dozentenänderungsmenü anzeigen
		List<String> menuItems = new LinkedList<>();
		menuItems.add("Dozent ändern");
		menuItems.add("Name ändern");
		menuItems.add("Vorname ändern");
		menuItems.add("Fachgebiet ändern");
		menuItems.add("Zurück zur Dozentenverwaltung");
		int auswahl = View.showMenu(menuItems);
		switch (auswahl) {
		case 1:
			dv.dozentBearbeitenName(doz, View.readString("Neuen Namen eingeben:"));
			dozentAendern(doz);
			break;
		case 2:
			dv.dozentBearbeitenVorname(doz, View.readString("Neuen Vornamen eingeben:"));
			dozentAendern(doz);
			break;
		case 3:
			dv.dozentBearbeitenFachgebiet(doz, View.readString("Neues Fachgebiet eingeben:"));
			dozentAendern(doz);
			break;
		case 4:
			showDozentenVerwaltung();
			break;
		default:
			View.show(fehlerNachricht(auswahl));
			dozentAendern(doz);
			break;
		}
	}
	
	/**
	 * Zeige das Menü nachdem ein Dozent ausgewählt wurde
	 * 
	 * @param doz
	 */
	private void showDozentenAuswahl(Dozent doz) {
		// Dozentendaten ausgeben
		View.show(doz.toString());
		// Dozentenauswahlmenü anzeigen
		List<String> menuItems = new LinkedList<>();
		menuItems.add("Dozentenverwaltung");
		menuItems.add("Dozent ändern");
		menuItems.add("Dozent löschen");
		menuItems.add("Zurück zur Dozentenverwaltung");
		int auswahl = View.showMenu(menuItems);
		switch (auswahl) {
		case 1:
			dozentAendern(doz);
//			showDozentenAuswahl(doz);
			break;
		case 2:
			dropDozent(doz);
			showDozentenVerwaltung();
			break;
		case 3:
			showDozentenVerwaltung();
			break;
		default:
			View.show(fehlerNachricht(auswahl));
			showDozentenAuswahl(doz);
			break;
		}
	}

	/**
	 * Diese Methode baut das Hauptmenü zusammen und übergibt es an die View.
	 * Nach Benutzereingabe (Auswahl des Menüpunktes) wird die entsprechende Methode aufgerufen.
	 * Bei einer Fehleingabe, wird eine Fehlernachricht ausgegeben und das Hauptmenü erneut angezeigt.
	 */
	public void showMainMenu(){
		List<String> menuList = new LinkedList<String>();
		menuList.add("Hauptmenü");
		menuList.add("Seminarverwaltung");
		menuList.add("Dozentenverwaltung");
		menuList.add("TeilnehmerVerwaltung");
		menuList.add("DatenVerwaltung");
		menuList.add("Programm beenden");
		int auswahl = View.showMenu(menuList);
		
		switch (auswahl) {
		case 1:
			showSeminarVerwaltung();
			break;
		case 2:
			showDozentenVerwaltung();
			break;
		case 3:
			showTeilnehmerVerwaltung();
			break;
		case 4:
			showDatenVerwaltung();
			break;
		case 5:
			break;
		default:
			View.show(fehlerNachricht(auswahl));
			showMainMenu();
			break;
		}
		
	}

	/** 
	 * Zeigt eine Liste von Seminaren an und gibt dem Benutzer die Auswahl zwischen:
	 * 1. Hinzufügen
	 * 2. Auswahl
	 */
	private void showSeminarVerwaltung(){
		// Teilnehmerliste ausgeben
				sv.seminarListeAusgeben(daten);
				
				// Teilnehmermenü ausgeben
				List<String> menuItems = new LinkedList<>();
				menuItems.add("Seminarverwaltung");
				menuItems.add("Seminar hinzufügen");
				menuItems.add("Seminar auswählen");
				menuItems.add("Zurück zum Hauptmenü");
				int auswahl = View.showMenu(menuItems);
				switch (auswahl) {
				case 1:
					seminarHinzufuegen();
					showSeminarVerwaltung();
					break;
				case 2:
					Seminar semAuswahl = seminarAuswaehlen();
					showSeminarAuswahl(semAuswahl);
//					showSeminarVerwaltung();
					break;
				case 3:
					showMainMenu();
					break;
				default:
					View.show(fehlerNachricht(auswahl));
					showSeminarVerwaltung();
					break;
				}
	}

	/**
	 * Diese Methode gibt zur Seminarauswhl die Möglichkeiten von Bearbeiten, löschen oder zurück.
	 * @param semAuswahl
	 */
	private void showSeminarAuswahl(Seminar semAuswahl) {
		// Teilnehmermenü ausgeben
		List<String> menuItems = new LinkedList<>();
		menuItems.add("Seminar Auswahl");
		menuItems.add("Seminar bearbeiten");
		menuItems.add("Seminar löschen");
		menuItems.add("Zurück zur Seminarverwaltung");
		int auswahl = View.showMenu(menuItems);
		switch (auswahl) {
		case 1:
			showSeminarBearbeiten(semAuswahl);
//			showSeminarAuswahl(semAuswahl);
			break;
		case 2:
			dropSeminar(semAuswahl);
			showSeminarVerwaltung();
			break;
		case 4:
			showSeminarVerwaltung();
			break;
		default:
			View.show(fehlerNachricht(auswahl));
			showSeminarAuswahl(semAuswahl);
			break;
		}

	}

	/**
	 * Diese Methode gibt die Auswahlmöglichkeiten zum Seminar bearbeiten
	 * 1. Titel
	 * 2. Teilnehmeranzahl
	 * 3. Strasse
	 * 4. Hausnummer.
	 * 5. plz
	 * 6. Ort
	 * 7. Dozent
	 * @param semAuswahl
	 */
	private void showSeminarBearbeiten(Seminar semAuswahl) {
		// einlesen der Adresse zum Bearbeiten
		String strasse = semAuswahl.getVeranstaltungsort().getStrasse();
		String hausnummer = semAuswahl.getVeranstaltungsort().getStrasse();
		String plz = semAuswahl.getVeranstaltungsort().getPlz();
		String ort = semAuswahl.getVeranstaltungsort().getOrt();
				
		List<String> menuItems = new LinkedList<>();
		menuItems.add("Seminar Bearbeiten");
		menuItems.add("Titel bearbeiten");
		menuItems.add("Teilnehmeranzahl bearbeiten");
		menuItems.add("Strasse bearbeiten");
		menuItems.add("Hausnummer bearbeiten");
		menuItems.add("Postleitzahl bearbeiten");
		menuItems.add("Ort bearbeiten");
		menuItems.add("Dozent bearbeiten");
		menuItems.add("zurück zur Auswahl");
		int auswahl = View.showMenu(menuItems);
		switch (auswahl) {
		case 1:
			String titel = View.readString("Bitte geben Sie den neuen Namen ein: ");
			sv.seminarBearbeiten(semAuswahl, titel);
			showSeminarBearbeiten(semAuswahl);
			break;
		case 2:
			int anz = View.readInt("Bitte geben Sie die neue Teilnehmeranzahl ein: ");
			sv.seminarBearbeiten(semAuswahl, anz);
			showSeminarBearbeiten(semAuswahl);
			break;
		case 3:
			strasse = View.readString("Bitte geben Sie die neue Strasse ein: ");
			sv.seminarBearbeiten(semAuswahl, new Adresse(strasse, hausnummer, plz, ort));
			showSeminarBearbeiten(semAuswahl);
			break;
		case 4:
			hausnummer = View.readString("Bitte geben Sie die neue Hausnummer ein: ");
			sv.seminarBearbeiten(semAuswahl, new Adresse(strasse, hausnummer, plz, ort));
			showSeminarBearbeiten(semAuswahl);
			break;
		case 5: 
			plz = View.readString("Bitte geben Sie die neue Postleitzahl ein: ");
			sv.seminarBearbeiten(semAuswahl, new Adresse(strasse, hausnummer, plz, ort));
			showSeminarBearbeiten(semAuswahl);
			break;
		case 6:
			ort = View.readString("Bitte geben Sie den neuen Ort ein: ");
			sv.seminarBearbeiten(semAuswahl, new Adresse(strasse, hausnummer, plz, ort));
			showSeminarBearbeiten(semAuswahl);
			break;
		case 7:
			Dozent doz = dozentZuSeminarAuswaehlen();
			sv.seminarBearbeiten(semAuswahl, doz);
			showSeminarBearbeiten(semAuswahl);
			break;
		case 8:
			showSeminarAuswahl(semAuswahl);
			break;
		default:
			View.show(fehlerNachricht(auswahl));
			showSeminarBearbeiten(semAuswahl);
			break;
		}
	}

	/**
	 * Wählt aus der angezeigten Liste von Seminaren ein Seminar nach der Positionsnummer aus und gibt dieses zurück.
	 * @return sem 
	 */
	private Seminar seminarAuswaehlen() {
		int auswahl = View.readInt("Bitte Seminarlistenpositionsnummer eingeben: ");
		Iterator<Seminar> it = daten.getSeminare().iterator();
		Seminar sem = null;
		int i = 1;
		while(i < auswahl){
			sem = it.next();
			i++;
		}
		return sem;
	}

	/**
	 * Diese Methode fragt die wichtigsten Daten zur Erstellung eines Seminars vom Benutzer ab und erstellt dieses Seminar dann.
	 * 
	 */
	private void seminarHinzufuegen() {
		Adresse adr = null;
		String titel = View.readString("Bitte geben Sie den Titel für das neue Seminar ein: ");
		View.show("Bitte geben Sie den Veranstaltungsort zu dem neuen Seminar ein!");
		String strasse = View.readString("Bitte geben Sie die Strasse ein: ");
		String hausnummer = View.readString("Bitte geben Sie die Hausnummer ein: ");
		String plz = View.readString("Bitte geben Sie die Postleitzahl ein: ");
		String ort = View.readString("Bitte geben Sie den Ort ein: ");
		adr = new Adresse(strasse, hausnummer, plz, ort);
		int anz = View.readInt("Bitte geben Sie die maximale Teilnehmeranzahl des Seminars ein: ");
		Dozent doz = dozentZuSeminarAuswaehlen();
		sv.seminarHinzufuegen(titel, adr, anz, doz);
	}
	
	/**
	 * Die Methode gibt eine Liste aus, aus der ein Dozent ausgewählt werden kann, oder aber ein neuer Dozent hinzugefügt werden kann.
	 * Dieser ausgewählte Dozent wird dann zurückgegeben.
	 * @return doz
	 */
	private Dozent dozentZuSeminarAuswaehlen(){
		View.show("Hier ist eine Liste der aktuellen Dozenten: ");
		dv.dozentenListeAusgeben(daten);
		Dozent doz = null;
		if (View.showEntscheidung("Wollen Sie einen Dozenten aus der Liste übernehmen?")){
				doz = dozentAuswaehlen();
		}
		else {
			dozentHinzufuegen();
			Iterator<Dozent> it = daten.getDozenten().iterator();
			while(it.hasNext()){
				doz = it.next();
			}
		}
		return doz;
	}

	/**
	 * Die Teilnehmerverwaltung gibt die aktuelle Teilnehmerliste aus und bietet dem Benutzer danach eine Auswahl an Funktionen an:
	 * 1: Teilnehmer hinzufügen
	 * 2: Teilnehmer ausählen
	 * 3: zurück zum Hauptmenü
	 */
	private void showTeilnehmerVerwaltung(){
		// Teilnehmerliste ausgeben
		tv.teilnehmerListeAusgeben(daten);
		
		// Teilnehmermenü ausgeben
		List<String> menuItems = new LinkedList<>();
		menuItems.add("Teilnehmerverwaltung");
		menuItems.add("Teilnehmer hinzufügen");
		menuItems.add("Teilnehmer auswählen");
		menuItems.add("Zurück zum Hauptmenü");
		int auswahl = View.showMenu(menuItems);
		switch (auswahl) {
		case 1:
			teilnehmerHinzufuegen();
			showTeilnehmerVerwaltung();
			break;
		case 2:
			Teilnehmer tlnAuswahl = teilnehmerAuswaehlen();
			showTeilnehmerAuswahl(tlnAuswahl);
			showTeilnehmerVerwaltung();
			break;
		case 3:
			showMainMenu();
			break;
		default:
			View.show(fehlerNachricht(auswahl));
			showTeilnehmerVerwaltung();
			break;
		}
	}
	
	
	/**
	 * Zeigt das SubMenü des ausgewählten Teilnehmers an:
	 * 1. tln bearbeiten
	 * 2. tln löschen
	 * @param tln
	 */
	private void showTeilnehmerAuswahl(Teilnehmer tln){
		// Teilnehmermenü ausgeben
		List<String> menuItems = new LinkedList<>();
		menuItems.add("Teilnehmer Auswahl");
		menuItems.add("Teilnehmer bearbeiten");
		menuItems.add("Teilnehmer löschen");
		menuItems.add("Zurück zur Teilnehmerverwaltung");
		int auswahl = View.showMenu(menuItems);
		switch (auswahl) {
		case 1:
			showTeilnehmerBearbeiten(tln);
			showTeilnehmerAuswahl(tln);
			break;
		case 2:
			dropTeilnehmer(tln);
			showTeilnehmerVerwaltung();
			break;
		case 4:
			showTeilnehmerVerwaltung();
			break;
		default:
			View.show(fehlerNachricht(auswahl));
			showTeilnehmerAuswahl(tln);
			break;
		}
	}
	
	/**
	 * Wählt aus einer ausgegebenen Liste einen Teilnehmer gemäß der Position in der Liste aus und übergibt diesen für das weitere vorgehen.
	 * @return Teilnehmer => ausgewählter Teilnehmer
	 */
	private Teilnehmer teilnehmerAuswaehlen() {		
		int auswahl = View.readInt("Bitte Teilnehmerlistenpositionsnummer eingeben: ");
		Iterator<Teilnehmer> it = daten.getTeilnehmer().iterator();
		Teilnehmer t = null;
		int i = 1;
		while(i < auswahl){
			t = it.next();
			i++;
		}
		return t;
	}

	/**
	 * Hier wird der übergebene Teilnehmer gemäß Auswahl überarbeitet
	 * 1. Name
	 * 2. Vorname
	 * 3. Strasse
	 * 4. Hausnummer
	 * 5. PLZ
	 * 6. Ort
	 * 7. zurück zur Auswahl
	 * @param tln
	 */
	private void showTeilnehmerBearbeiten(Teilnehmer tln){
		// einlesen der Adresse zum Bearbeiten
		String strasse = tln.getAdresse().getStrasse();
		String hausnummer = tln.getAdresse().getStrasse();
		String plz = tln.getAdresse().getPlz();
		String ort = tln.getAdresse().getOrt();
				
		List<String> menuItems = new LinkedList<>();
		menuItems.add("Teilnehmer Bearbeiten");
		menuItems.add("Name bearbeiten");
		menuItems.add("Vorname bearbeiten");
		menuItems.add("Strasse bearbeiten");
		menuItems.add("Hausnummer bearbeiten");
		menuItems.add("Postleitzahl bearbeiten");
		menuItems.add("Ort bearbeiten");
		menuItems.add("zurück zur Auswahl");
		int auswahl = View.showMenu(menuItems);
		switch (auswahl) {
		case 1:
			String name = View.readString("Bitte geben Sie den neuen Namen ein: ");
			tv.teilnehmerBearbeitenName(tln, name);
			showTeilnehmerBearbeiten(tln);
			break;
		case 2:
			String vorname = View.readString("Bitte geben Sie den neuen Namen ein: ");
			tv.teilnehmerBearbeitenVorname(tln, vorname);
			showTeilnehmerBearbeiten(tln);
			break;
		case 3:
			strasse = View.readString("Bitte geben Sie die neue Strasse ein: ");
			tv.teilnehmerBearbeitenAdresse(tln, new Adresse(strasse, hausnummer, plz, ort));
			showTeilnehmerBearbeiten(tln);
			break;
		case 4:
			hausnummer = View.readString("Bitte geben Sie die neue Hausnummer ein: ");
			tv.teilnehmerBearbeitenAdresse(tln, new Adresse(strasse, hausnummer, plz, ort));
			showTeilnehmerBearbeiten(tln);
			break;
		case 5: 
			plz = View.readString("Bitte geben Sie die neue Postleitzahl ein: ");
			tv.teilnehmerBearbeitenAdresse(tln, new Adresse(strasse, hausnummer, plz, ort));
			showTeilnehmerBearbeiten(tln);
			break;
		case 6:
			ort = View.readString("Bitte geben Sie den neuen Ort ein: ");
			tv.teilnehmerBearbeitenAdresse(tln, new Adresse(strasse, hausnummer, plz, ort));
			showTeilnehmerBearbeiten(tln);
			break;
		case 7:
			showTeilnehmerAuswahl(tln);
			break;
		default:
			View.show(fehlerNachricht(auswahl));
			showTeilnehmerBearbeiten(tln);
			break;
		}
	}
	
	/**
	 * Fragt vom Benutzer die wichtigen Daten zur Erstellung eines Teilnehmers ab.
	 */
	private void teilnehmerHinzufuegen() {
		Adresse adr = null;
		String name = View.readString("Bitte geben Sie den Namen für den neuen Teilnehmer ein: ");
		String vorname = View.readString("Bitte geben Sie den Vornamen für den neuen Teilnehmer ein: ");
		if (View.showEntscheidung("Wollen Sie eine Adresse zu dem neuen Teilnehmer eingeben?")){
			String strasse = View.readString("Bitte geben Sie die Strasse ein: ");
			String hausnummer = View.readString("Bitte geben Sie die Hausnummer ein: ");
			String plz = View.readString("Bitte geben Sie die Postleitzahl ein: ");
			String ort = View.readString("Bitte geben Sie den Ort ein: ");
			adr = new Adresse(strasse, hausnummer, plz, ort);
		}
		addTeilnehmer(tv.teilnehmerHinzufuegen(name, vorname, adr));
	}

	/**
	 * gibt ein Dozentenobjekt aus der Datenhaltung zurück
	 * @param id
	 * @return null, wenn kein Dozent gefunden wurde
	 */
	private Dozent getDozentFromId(int id) {
		for (Dozent doz : daten.getDozenten()) {
			if (doz.getId() == id)
				return doz;
		}
		return null;
	}
	
	/**
	 * gibt ein Seminarobjekt aus der Datenhaltung zurück
	 * @param id
	 * @return null, wenn kein Dozent gefunden wurde
	 */
	private Seminar getSeminarFromTitle(String title) {
		for (Seminar sem : daten.getSeminare()) {
			if (sem.getTitel().equals(title))
				return sem;
		}
		return null;
	}
	
	/**
	 * gibt ein Teilnehmerobjekt aus der Datenhaltung zurück
	 * @param id
	 * @return null, wenn kein Dozent gefunden wurde
	 */
	private Teilnehmer getTeilnehmerFromId(int id) {
		for (Teilnehmer tln : daten.getTeilnehmer()) {
			if (tln.getId() == id)
				return tln;
		}
		return null;
	}
	
	private String fehlerNachricht(int auswahl){
		return "FEHLER: Ihre getroffene Auswahl " + auswahl + " entsprach keinem Menüpunkt!";
	}
}//end MasterVerwaltung