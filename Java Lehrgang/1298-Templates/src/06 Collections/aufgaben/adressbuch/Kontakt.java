package aufgaben.adressbuch;

public class Kontakt implements Comparable<Kontakt> {
     private String name;
     private String vorname;
     private String telNr;
     private String str;
     private String hausNr;
	
    Kontakt(String name, String vName, String tel, String str, String nr) {
    	this.name = name;
    	this.vorname = vName;
    	this.telNr = tel;
    	this.str = str;
    	this.hausNr = nr;    
    }
    
    
	@Override
	public int compareTo(Kontakt k) {
		if (this.name.compareTo(k.name)!=0) {
			return this.name.compareTo(k.name);
		} else {
			return this.vorname.compareTo(k.vorname);
		}
		
	}
	
	public void printKontakt() {
		System.out.println(name+", "+vorname + " - " + str + " " + hausNr + " - Tel: " + telNr);
	}

}
