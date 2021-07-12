package exceptions;

public class ExceptionalClass {

	public int dividiere(int a, int b) throws Exception {
		int erg = 0;
		
		try {
			if (a==0) {
				throw new Exception("Der erste Parameter ist 0");
			}
			erg = a/b;
		} catch(ArithmeticException e) {
			System.out.println("Arithmetischer Fehler");
		} /*catch(Exception e) {
			System.out.println("Ich habe einen Fehler in der ExceptionClass abgefangen: "+e.getClass());
			System.out.println(e.getMessage());
			e.printStackTrace();
		} */
		finally {
			System.out.println("Wird auf jeden Fall ausgeführt!");
		}
		return erg;	
	}
	
	
	public int addiere(int a, int b) throws DummerUserException {
		int erg = 0;
		erg = a+b;
		if (erg < 0) {
			throw new DummerUserException("Du bist doof!");
		}
		return erg;		
	}
}
