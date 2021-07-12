package persistenz.v1;

import java.io.Serializable;

public class Soldat implements Serializable {

	private static final long serialVersionUID = -1159597308309986796L;

	private String name;
	private String vorname;  // transient?!?
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
	@Override
	public String toString() {
		return "Soldat [name=" + name + ", vorname=" + vorname + ", pk=" + pk
				+ ", dg=" + dg + "]";
	}
	
	
}
