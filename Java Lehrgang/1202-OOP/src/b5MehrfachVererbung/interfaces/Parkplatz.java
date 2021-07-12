package b5MehrfachVererbung.interfaces;

public interface Parkplatz {

	public int test = 0;

	public final int TEST = 90;

	public static final int KONST = 100;

	public void parken();

	public default void parkenDefault() {
		System.out.println("es wird geparkt");
	}
	public static void parkenStatic() {
		System.out.println("es wird geparkt");
	}

}
