package _05ObjectServerSocket;

import java.io.Serializable;

public class Mensch implements Serializable{
	private static final long serialVersionUID = -2438584440954882934L;
	
	private String name;
	private int alter;

	public Mensch(String name, int alter) {
		this.name = name;
		this.alter = alter;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public int getAlter() {
		return alter;
	}

}
