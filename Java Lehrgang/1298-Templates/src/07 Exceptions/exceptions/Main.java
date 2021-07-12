package exceptions;

public class Main {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		ExceptionalClass ex = new ExceptionalClass();
		
		try {
			System.out.println(ex.dividiere(8,4));
			System.out.println(ex.dividiere(8,0));
			System.out.println(ex.dividiere(0,2));
		} /*catch (ArithmeticException e) {
			System.out.println("Ich habe einen Fehler in der main abgefangen");
		} */catch (Exception e) {
			System.out.println("Noch ein Fehler in der main abgefangen" + e.getMessage());
		}
		
		
		//System.out.println(ex.dividiere(8,2));
		
		/*
		try {
			ex.addiere(3, 4);
			ex.addiere(3, -5);
		} catch(DummerUserException e) {
			System.out.println("Fehler bei der Addition" + e.getMessage());
			e.printStackTrace();
		}*/
		
		
		

	}

}
