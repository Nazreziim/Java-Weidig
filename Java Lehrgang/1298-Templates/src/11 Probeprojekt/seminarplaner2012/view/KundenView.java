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

	public int men�Anzeigen(){
		int auswahl=0;
	
			System.out.println("Kunde Anzeigen     -->1");
			System.out.println("Kunden Anzeigen    -->2");
			System.out.println("Kunde Ausw�hlen    -->3");
			System.out.println("Kunde Einlesen     -->4");
			System.out.println("L�schen Best�tigen -->5");
			System.out.println("Eingabe Best�tigen -->6");
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
	public Kunde kundeAusw�hlen(Kundenbestand kb){
		return null;
	}

	private boolean l�schenBest�tigen(){
		return false;
	}

	private boolean eingabeBest�tigen(){
		return false;
	}
}//end KundenView