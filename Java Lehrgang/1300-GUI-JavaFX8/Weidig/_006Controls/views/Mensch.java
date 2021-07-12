package _006Controls.views;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mensch {
	private StringProperty name;
	private IntegerProperty alter;
	private StringProperty geschlecht;

	public Mensch(String name) {
		this.name = new SimpleStringProperty(name);
	}
	
	public Mensch(String name, int alter, String geschlecht) {
		this.name = new SimpleStringProperty(name);
		this.alter = new SimpleIntegerProperty(alter);
		this.geschlecht = new SimpleStringProperty(geschlecht);
	}

	//Die zuerst nehmen und zeigen wo die Probleme sein werden
	
//	public String getName() {
//		return name.get();
//	}
//
//	public void setName(String name) {
//		this.name.set(name);
//	}
//
//	public int getAlter() {
//		return alter.get();
//	}
//
//	public void setAlter(int alter) {
//		this.alter.set(alter);
//	}
//
//	public String getGeschlecht() {
//		return geschlecht.get();
//	}
//
//	public void setGeschlecht(String geschlecht) {
//		this.geschlecht.set(geschlecht);
//	}
	
	//Wenn man mit änderbaren Werten [StringProperty etc.] arbeitet
	public StringProperty getName() {
		return name;
	}
	
	public IntegerProperty getAlter() {
		return alter;
	}
	
	public StringProperty getGeschlecht() {
		return geschlecht;
	}

}