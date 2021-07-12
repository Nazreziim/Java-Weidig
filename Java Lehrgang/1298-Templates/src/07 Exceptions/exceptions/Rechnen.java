package exceptions;



public class Rechnen {

	/**
	 * @throws Exception Ex wird geworfen! 
	 */
	public int dividiere(int a, int b) throws RuntimeException {
		int erg = 0;
		try {
			if (a == 0) {
				throw new IllegalArgumentException("Ein Parameter war Null.");
			}
			if (a == b) {
				throw new DummerUserException("Juhu mein erster eigener Fehler.");
			}
			erg = a / b;
		} catch (DummerUserException ex) {
			System.out.println("Toll gemacht");
			ex.printStackTrace();
		} catch (ArithmeticException ex) {
			System.out.println("Der zweite Parameter war 0.");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			System.out.println("Aufräumarbeiten");
			throw new RuntimeException("Ein finaler Fehler.");
		}
		//return erg;
	}
}
