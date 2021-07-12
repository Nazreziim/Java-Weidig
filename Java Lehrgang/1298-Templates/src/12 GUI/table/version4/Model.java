package table.version4;

import java.util.Observer;
import java.util.Vector;

public interface Model {
	
	public void addObserver2(Observer obs);

	public Vector<Vector<String>> getVector();

	public void addString(String string1, String string2);
}
