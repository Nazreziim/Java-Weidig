package _3MehrereExceptions;

public class MultipleCatchExample {
	public static void main(String... args) {
		try {
			Integer[] iarr = new Integer[3];
			System.out.println(iarr[0].toString()); // NullPointerException
			// System.out.println( iarr[ 3 ].toString() ); // IndexOutOfBoundsException
		} catch (NullPointerException e) {
			System.err.println("Eine NullPointerException wurde verursacht.");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Eine IndexOutOfBoundsException wurde verursacht.");
		} catch (Exception e) { // Schlechtes Beispiel: nicht machen
			System.err.println("Irgend eine Exception wurde verursacht.");
		}

	}

}
