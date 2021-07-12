package seminarplaner2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import seminarplaner2013.HilfsMeth;


/**
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:18
 */
public class DozentenverwaltungView {

	public DozentenverwaltungView(){

	}

		
	public int zeigeMenue(){
		int erg;
		erg = HilfsMeth.readInt("Geben sie die gewünschte Nummer für die nächste Aktion an : \n"
				+ "1: \tDozent hinzufuegen\n"
				+ "2: \tDozent aendern\n"
				+ "3: \tDozent loeschen\n"
				+ "4: \tDozent auswaehlen\n"
				+ "0: \tabbrechen");
		
		return erg;
	}
	
	
	
	public int zeigeListe(ArrayList<Dozent> d){
		
		int chooseddoz = 0;
		for(Dozent doz : d ){
			
			System.out.println("Dozent " + doz);
		}
		chooseddoz = HilfsMeth.readInt("Geben sie die Personalnummer des ausgewaehlten Dozenten an");
		
		return chooseddoz;
	}
	
	public String frageNach(String abfrage) {
		
		try {
			String a;
			BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(abfrage);
			a = testin.readLine();
			return a;
		}
		catch (IOException e) {return "IO-Fehler";}
	}
	public int frageNachAendern(String abfrage){
		
			try {
				int a;
				BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(abfrage);
				a = Integer.parseInt(testin.readLine()); 
				return a;
			}
			catch (IOException e) {return 42;}
		
	}
	
}