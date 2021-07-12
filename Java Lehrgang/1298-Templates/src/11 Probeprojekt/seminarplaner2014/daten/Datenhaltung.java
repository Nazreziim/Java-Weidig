package daten;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import view.View;

/**
 * @author c-ix-03-11
 * @version 1.0
 * @created 22-Jul-2014 11:56:45
 */
public class Datenhaltung {
	private Set<Dozent> dozenten = new HashSet<>();
	private Set<Seminar> seminare = new HashSet<>();
	private Set<Teilnehmer> teilnehmer = new HashSet<>();
	private File dozentenliste = new File("D:\\Seminarplaner\\Dozentenliste.basel");
	private File teilnehmerliste = new File("D:\\Seminarplaner\\Teilnehmerliste.basel");
	private File seminarliste = new File("D:\\Seminarplaner\\Seminarliste.basel");

	public Datenhaltung(){

	}

	public Set<Dozent> getDozenten() {
		return dozenten;
	}

	public void setDozenten(Set<Dozent> dozenten) {
		this.dozenten = dozenten;
	}

	public Set<Seminar> getSeminare() {
		return seminare;
	}

	public void setSeminare(Set<Seminar> seminare) {
		this.seminare = seminare;
	}

	public Set<Teilnehmer> getTeilnehmer() {
		return teilnehmer;
	}

	public void setTeilnehmer(Set<Teilnehmer> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public void laden() {
		File ordnerErstellen = new File("D:\\Seminarplaner");
		ordnerErstellen.mkdirs();
//		File dozentenFile = new File("D:\\Seminarplaner\\Dozentenliste.basel");
//		File teilnehmerFile = new File("D:\\Seminarplaner\\Teilnehmerliste.basel");
//		File seminarFile = new File("D:\\Seminarplaner\\Seminarliste.basel");
		try {
			ObjectInputStream dois = new ObjectInputStream(new FileInputStream(dozentenliste));
			ObjectInputStream tois = new ObjectInputStream(new FileInputStream(teilnehmerliste));
			ObjectInputStream sois = new ObjectInputStream(new FileInputStream(seminarliste));
			dozenten = new HashSet<>();
			boolean eof = false;																//solange EOF nicht erreicht, false
			
			//Die Datei Dozentenliste wird ausgelesen und jedes Objekt einzeln in einen neuen Listeneintrag geladen
			while(!eof) {
				try {
					dozenten.add((Dozent)dois.readObject());					
				}
				catch(EOFException eofe) {
					eof = true;
				}
			}
			
			teilnehmer = new HashSet<>();
			eof = false;
			
			//Die Datei Teilnehmerliste wird ausgelesen und jedes Objekt einzeln in einen neuen Listeneintrag geladen
			while(!eof) {
				try {
					teilnehmer.add((Teilnehmer)tois.readObject());
				}
				catch(EOFException eofe) {
					eof = true;
				}
			}
			
			seminare = new HashSet<>();
			eof = false;
			//Die Datei Seminarliste wird ausgelesen und jedes Objekt einzeln in einen neuen Listeneintrag geladen
			while(!eof) {
				try {
					seminare.add((Seminar) sois.readObject());
				}
				catch(EOFException eofe) {
					eof = true;
				}
			}
			
			dois.close();
			tois.close();
			sois.close();
		} 
		catch (FileNotFoundException e) {
			System.err.println("Datei wurde nicht gefunden");
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			System.err.println("Klasse konnte nicht gefunden werden");
		}
		
		//muss geloescht werden
		View.show("Laden der Daten erfolgreich.");
	}
	
	public void speichern(){
		//Hier werden die Dozenten gespeichert
//		File dozentenliste = new File ("D:\\Seminarplaner\\Dozentenliste.basel");
		Iterator it;
		try {
			dozentenliste.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ObjectOutputStream doz = new ObjectOutputStream(new FileOutputStream(dozentenliste));
			it = dozenten.iterator();
			while(it.hasNext()) {
				doz.writeObject(it.next());			
			}
			doz.flush();
			doz.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Seminare werden hier gespeichert
//		File seminarliste = new File("D:\\Seminarplaner\\Seminarliste.basel");
		try {
			dozentenliste.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ObjectOutputStream sem = new ObjectOutputStream(new FileOutputStream(seminarliste));
			it = seminare.iterator();
			while(it.hasNext()) {
				sem.writeObject(it.next());	
			}
			sem.flush();
			sem.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//hier werden Teilnehmer gespeichert
//		File teilnehmerliste = new File("D:\\Seminarplaner\\Teilnehmerliste.basel");
		try {
			teilnehmerliste.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ObjectOutputStream teil = new ObjectOutputStream(new FileOutputStream(teilnehmerliste));
			it = teilnehmer.iterator();
			while(it.hasNext()) {
				teil.writeObject(it.next());		
			}
			teil.flush();
			teil.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		View.show("Speichern der Daten erfolgreich.");
	}

}