package randomAccess.aufgaben.soldat;

public class Soldat {
	private String name;
	private String vorname;
	private String pk;
	private String dg;
	
	public Soldat() {
		
	}
	public Soldat(String name, String vorname, String pk, String dg) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.pk = pk;
		this.dg = dg;
	}


	public String getDg() {
		return dg;
	}


	public void setDg(String dg) {
		this.dg = dg;
	}


	public String getName() {
		return name;
	}


	public String getVorname() {
		return vorname;
	}


	public String getPk() {
		return pk;
	}
	
	
}
