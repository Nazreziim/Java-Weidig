package überschreiben;

public class ToString {
	private int alter;
	private String name;

	@Override
	public String toString() {
		String toStringString = "Das Alter ist " + alter + " , der Name ist " + name;
		return toStringString;
	}

	// GETTER UND SETTER
	/**
	 * @param alter the alter to set
	 */
	public void setAlter(int alter) {
		this.alter = alter;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
