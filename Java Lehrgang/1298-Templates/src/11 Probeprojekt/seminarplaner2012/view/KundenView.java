package seminarplaner2012.view;

import java.io.IOException;

import seminarplaner2012.domain.Kunde;
import seminarplaner2012.model.Kundenbestand;


/**
 * @author dborkowitz
 * @version 1.0
 * @created 04-Mai-2012 09:48:44
 */
public class KundenView {

	public KundenView(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param kl
	 */
	public void zeigeKundenAn(Kundenbestand kl){

	}

	/**
	 * 
	 * @param k
	 */
	public void kundeEinlesen(Kunde k){

	}

	public int menüAnzeigen(){
		int auswahl=0;
	
			System.out.println("Kunde Anzeigen     -->1");
			System.out.println("Kunden Anzeigen    -->2");
			System.out.println("Kunde Auswählen    -->3");
			System.out.println("Kunde Einlesen     -->4");
			System.out.println("Löschen Bestätigen -->5");
			System.out.println("Eingabe Bestätigen -->6");
			try {
				auswahl=HilfsMeth.readInt("Bitte eine Zahl eingeben:  ");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		return auswahl;
	}

	/**
	 * 
	 * @param k
	 */
	public void kundeAnzeigen(Kunde k){

	}

	/**
	 * 
	 * @param kb
	 */
	public Kunde kundeAuswählen(Kundenbestand kb){
		return null;
	}

	private boolean löschenBestätigen(){
		return false;
	}

	private boolean eingabeBestätigen(){
		return false;
	}
}//end KundenView