package seminarplaner2013;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * Diese Klasse enthält die statischen Methoden zum Laden und Speichern von allen
 * Daten des Seminarplaner
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:24
 */
public class Datensicherung {

	private ArrayList<Kunde> kundenSicherung;
	private ArrayList<Dozent> dozentenSicherung;
	private ArrayList<Seminar> seminarSicherung;
	private File dateiname;

	public Datensicherung(){
		this.dateiname = new File("U:\\Uebergabe\\Seminarplaner.save");
		if(!this.dateiname.exists()){
			try {
				this.dateiname.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			laden();
		}
	}

	public void finalize() throws Throwable {

	}
	
	/**
	 * Speichern der Arraylisten in der angegebenen Datei
	 */
	public void speichern(ArrayList<Kunde> kunList, ArrayList<Dozent> dozList, ArrayList<Seminar> semList){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.dateiname));
			
			oos.writeObject(kunList);
			oos.writeObject(dozList);
			oos.writeObject(semList);
			
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Laden aller Listen aus der angegebenen Datei
	 */
	@SuppressWarnings("unchecked")
	public void laden(){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.dateiname));
		
			this.kundenSicherung = (ArrayList<Kunde>) ois.readObject();
			this.dozentenSicherung = (ArrayList<Dozent>) ois.readObject();
			this.seminarSicherung = (ArrayList<Seminar>) ois.readObject();
			
			
			ois.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Kunde> getKundenSicherung(){
		return this.kundenSicherung;
	}

	public ArrayList<Dozent> getDozentenSicherung(){
		return this.dozentenSicherung;
	}

	public ArrayList<Seminar> getSeminarSicherung(){
		return this.seminarSicherung;
	}
}//end Datensicherung