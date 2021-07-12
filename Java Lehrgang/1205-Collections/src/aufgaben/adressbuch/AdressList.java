package aufgaben.adressbuch;

import java.util.*;

public class AdressList {
	private TreeSet<Kontakt> adList; 

	
	public AdressList() {
		super();
		this.adList = new TreeSet<Kontakt>();
	}
	
	public AdressList(Comparator<? super Kontakt> comperator) {
		
		this.adList = new TreeSet<Kontakt>(comperator);
	}

	public boolean insert(Kontakt k) {
		return adList.add(k);
	}
	
	public boolean delete(Kontakt k) {
		return adList.remove(k);
	}
	
	public void printAdr() {
		Iterator<Kontakt> it = adList.iterator();
		while (it.hasNext()) {
			it.next().printKontakt();
		}
		System.out.println();
	}
	
	public Kontakt sucheAdr(String name, String vorname){
		Kontakt adr = null;
		Kontakt suchAdr = new Kontakt(name, vorname);
		
		
		if ( adList.contains(suchAdr) ){
			adr = adList.floor(suchAdr);
		}
		
		
		return adr;
	}
}
