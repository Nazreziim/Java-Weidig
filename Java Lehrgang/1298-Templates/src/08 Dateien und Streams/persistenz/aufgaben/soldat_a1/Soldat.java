package persistenz.aufgaben.soldat_a1;

public class Soldat {
	private String name;
	private String vorname;
	private String pk;
	private String dienstgrad;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getDienstgrad() {
		return dienstgrad;
	}

	public void setDienstgrad(String dienstgrad) {
		this.dienstgrad = dienstgrad;
	}
}
