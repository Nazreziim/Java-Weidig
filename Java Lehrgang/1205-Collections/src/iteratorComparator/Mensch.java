package iteratorComparator;

public class Mensch implements Comparable<Mensch>{
	private String vName;
	private String nName;
	private int alter;
	
	public Mensch(String vName, String nName, int alter) {
		this.vName = vName;
		this.nName = nName;
		this.alter = alter;
	}
	
    // Getter fuer Comparator-Interface extern erforderlich
	public int getAlter() {
		return alter;
	}
	
	
	public int compareTo(Mensch p) {
		if (this.nName.compareTo(p.nName) != 0) {
			return this.nName.compareTo(p.nName);
		} else {
			return this.vName.compareTo(p.vName);
		}
	}

	

	@Override
	public String toString() {
		return this.alter + " - " + this.vName + " "+ this.nName;
	}
	
}
