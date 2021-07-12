package aufgaben.telefonbuch;

public class Name {
	String vName;
	String nName;


	public Name(String vName, String nName) {
		this.vName = vName;
		this.nName = nName;

	}

	@Override
	public String toString() {
		return "Name=" + vName + ", Nachname=" + nName + " ";
	}
}
