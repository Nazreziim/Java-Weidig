package v01_ohneEnums;

public class NoEnum {

	public void doSomething(int action) {
		if (action == 1) {
			System.out.println("Aktion Packen");
		} else if (action == 2) {
			System.out.println("Aktion Essen");
		} else {
			System.out.println("unbeaknnte Aktion");
		}
	}

	public static void main(String[] args) {
		NoEnum ne = new NoEnum();
		ne.doSomething(1);
		ne.doSomething(2);
		ne.doSomething(3);
	}
}
