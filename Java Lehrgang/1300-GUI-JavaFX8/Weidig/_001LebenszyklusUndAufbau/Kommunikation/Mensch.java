package _001LebenszyklusUndAufbau.Kommunikation;

public class Mensch {
	//Attribute
	private String name;
	private int alter;
	
	//Instanz
	private final static Mensch udo = new Mensch("Udo", 50);
	
	private Mensch(String name, int alter) {
		this.name = name;
		this.alter = alter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	
	public static Mensch getUdo() {
		return udo;
	}
	
	
	
}
