package seminarplaner2012.control;

import seminarplaner2012.model.Kundenbestand;
import seminarplaner2012.view.KundenView;

/**
 * @author dborkowitz
 * @version 1.0
 * @created 04-Mai-2012 09:48:44
 */
public class Kundenverwaltung{

	private KundenView view;
	private Kundenbestand kundenbestand;


	public Kundenverwaltung(KundenView view, Kundenbestand kundenbestand){
		this.view = view;
		this.kundenbestand = kundenbestand;

	}
	
	public Kundenverwaltung()
	{
		this.kundenbestand = new Kundenbestand();
		this.view = new KundenView();
		
	}

	public void finalize() throws Throwable {

	}

	public void kundenAnzeigen() {

	}

	public void erstelleKunde() {

	}

	public void kundeLöschen() {

	}

	public void kundeÄndern() {

	}

	public void starten() {
		int eingabe = 0;
		do {
			
				eingabe = this.view.menüAnzeigen();
				switch (eingabe) {
				case 1:
					this.view.kundeAnzeigen(null);
					break;
				case 2:
					this.view.zeigeKundenAn(null);
					break;

				}

			}while (eingabe == 0);

		
	}

	/**
	 * 
	 * @param k
	 */

	public void setView(KundenView view){
		
		this.view = view;


	}

	public KundenView getView()
	{
		return this.view;
		
		
	}

	public Kundenbestand getKundenbestand() {
		return this.kundenbestand;
	}

	public void setKundenbestand(Kundenbestand kundenbestand) {
		this.kundenbestand = kundenbestand;
	}
	
	
}//end Kundenverwaltung//>>>>>>> .r17
