package _08MVCBeispiele;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Statistik {
	private IntegerProperty besiegteMonster;
	private IntegerProperty verursachterSchaden;
	private double zeitinsgesamt;
	private ArrayList<Integer> clicksInSecond = new ArrayList<>();

	public Statistik() {
		this.besiegteMonster = new SimpleIntegerProperty(0);
		this.verursachterSchaden = new SimpleIntegerProperty(0);
	}

	public IntegerProperty getBesiegteMonsterProperty() {
		return besiegteMonster;
	}

	public IntegerProperty getVerursachterSchadenProperty() {
		return verursachterSchaden;
	}

	public void setBesiegteMonsterProperty(IntegerProperty besiegteMonster) {
		this.besiegteMonster = besiegteMonster;
	}

	public void setVerursachterSchadenProperty(IntegerProperty verursachterSchaden) {
		this.verursachterSchaden = verursachterSchaden;
	}

	public int getBesiegteMonster() {
		return besiegteMonster.get();
	}

	public void setBesiegteMonster(int besiegteMonster) {
		this.besiegteMonster.set(besiegteMonster);
	}

	public int getVerursachterSchaden() {
		return verursachterSchaden.get();
	}

	public void setVerursachterSchaden(int verursachterSchaden) {
		this.verursachterSchaden.set(verursachterSchaden);
	}
	
	public void setZeitinsgesamt(double zeitinsgesamt) {
		this.zeitinsgesamt = zeitinsgesamt;
	}
	
	public double getZeitinsgesamt() {
		return zeitinsgesamt;
	}
	
	public void setClicksInSecond(ArrayList<Integer> clicksInSecond) {
		this.clicksInSecond = clicksInSecond;
	}
	
	public ArrayList<Integer> getClicksInSecond() {
		return clicksInSecond;
	}
}
