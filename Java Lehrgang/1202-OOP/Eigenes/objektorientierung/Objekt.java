package objektorientierung;

import java.util.Objects;

public class Objekt {
	private static int counter = 0;
	private final int ID;
	private String name;

	Objekt(String n) {
		ID = counter;
		counter++;
		name = n;

	}

	public String getName() {
		return name;
	}
	
	public int getID() {
		return ID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}

	

	

	

	
	
	
}
