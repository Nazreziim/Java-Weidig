package persistenz.v2;

import java.io.Serializable;

public class Hund  {
	private String name;
	private int alter;
	
	public Hund(String name, int alter) {
		super();
		this.name = name;
		this.alter = alter;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hund [name=" + name + ", alter=" + alter + "]";
	}
	
	

}
