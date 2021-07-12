package listen;

/**
 * Listen-Klassen mit rekursiven Methoden
 * @author whoelzle
 *
 */
public class Liste02Rek {
	private ListenElement start;
	
	Liste02Rek(){
		this.start = null;
	}
	
	public void einfuegenVorne(int info){
		
		this.start = new ListenElement(info, this.start);
	}
		
	
	private ListenElement einfuegenHintenRek( ListenElement element, int info){
		ListenElement elementNeu = element;
		
		if (elementNeu != null ){
			
			elementNeu.setNext( einfuegenHintenRek(element.getNext(), info) );		     
		}
		else{ // neues Element in leere Liste oder am Ende der Liste einfuegen
			
			elementNeu = new ListenElement(info);
		}
		return elementNeu;
	}
	
	
	public void einfuegenHintenRek(int info){
		
		this.start = einfuegenHintenRek(this.start, info);		
	}
	
	
	private ListenElement einfuegenSortiertRek(ListenElement element, int info){
		ListenElement elementNeu = element;
		
		if ( elementNeu == null  || info <= element.getInfo() ) {
			 
			elementNeu = new ListenElement(info, elementNeu);	 
		}
		else{
			elementNeu.setNext(einfuegenSortiertRek(element.getNext(), info));
		}		
				
		return elementNeu;
	}
	
	public void einfuegenSortiertRek(int info){
				
		this.start = einfuegenSortiertRek(this.start, info);
	}
	

	
	private ListenElement loescheElementRek( ListenElement element, int info){
		
		ListenElement hilf = element;
		
		if ( element != null ){
			if ( element.getInfo() == info){
				
				element = element.getNext();
				hilf.setNext(null);
			}
			else{
				element.setNext(loescheElementRek(element.getNext(), info));
			}
		}
		else{
			System.out.printf("==> Element %d nicht in Liste vorhanden! \n", info);
		}
		
		return element;
	}
	
	public void loescheElementRek(int info){
		
		this.start = loescheElementRek(this.start, info);
	}
	
	
	private ListenElement loescheAlleElementeRek(ListenElement element){
		
		
		if (element != null && element.getNext() != null ){
			element.setNext(loescheAlleElementeRek(element.getNext()));
		}
				
		return null;
	}
	
	public void loescheAlleElementeRek(){
		
		this.start = loescheAlleElementeRek(this.start);	
	}
	
	
	private void ausgebenAllerElementeRek(ListenElement element, boolean vorwaerts){
		
		if ( element != null ){
			
			if (vorwaerts){
				// Aktion: Ausgabe sortierter Liste vorwaerts
				System.out.println(element.toString());
			}
			
			// Rekursionsschritt
			ausgebenAllerElementeRek(element.getNext(), vorwaerts);
			
			
			if (!vorwaerts){
				// Aktion: Ausgabe sortierter Liste rueckwaerts
				System.out.println(element.toString());
			}
		}
	}
	
	public void ausgebenAllerElementeRek(boolean vorwaerts){
		
		System.out.print("Ausgabe aller Elemente: ");
		if (vorwaerts){
			System.out.println("vorwaerts");
		}
		else{
			System.out.println("rueckwaerts");
		}
		
		ausgebenAllerElementeRek(this.start, vorwaerts);
	}
	
	
	
	private int anzahlElementeRek(ListenElement element){
		int erg = 0;
		
		if ( element != null){
			erg = 1 +  anzahlElementeRek( element.getNext() );
		}
		
		return erg;
	}
	
	public int anzahlElementeRek(){
		
		return anzahlElementeRek(this.start);
	}
	
	private ListenElement clone(ListenElement quelle){
		
		ListenElement element = quelle;
		
		if ( quelle != null ){
			 element = quelle.clone();
			 
			 if ( quelle.getNext() != null){
				 element.setNext( clone(quelle.getNext()) );
			 }	 
		}
				
		return element;
	}
	
	@Override
	public Liste02Rek clone(){
		Liste02Rek liste = new Liste02Rek();
										
		liste.start = clone( this.start );			
						
		return liste;
	}
}
