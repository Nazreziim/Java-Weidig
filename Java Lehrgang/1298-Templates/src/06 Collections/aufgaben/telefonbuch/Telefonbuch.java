package aufgaben.telefonbuch;

import java.util.*;

public class Telefonbuch {
	
	Map<String, Kontakt> telBuch = new HashMap<String, Kontakt>();
	
	public void add(String vn, String nn, String st, String hNr, String tel) {
		telBuch.put(vn+nn,new Kontakt(vn,nn,st,hNr,tel));
	}
	
	public Kontakt get(String vn, String nn) {
		return telBuch.get(vn+nn);
	}
	
	public Kontakt remove(String vn, String nn) {
		return telBuch.remove(vn+nn);
	}
	
	
	
}
