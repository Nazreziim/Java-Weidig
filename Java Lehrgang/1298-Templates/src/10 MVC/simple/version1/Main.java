package simple.version1;

public class Main {

	public static void main(String[] args) {
		ModelInterface m = new Model();
		ViewInterface v = new AndereView(m);
		Control c = new Control(m,v);
		c.letsGo();

	}

}
