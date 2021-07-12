package _3MehrereExceptions;

public class MultipleExceptionsOneCatch {
	public static void main(String[] args) {
		try {
			Integer[] iarr = new Integer[3];
			System.out.println(iarr[0].toString()); // NullPointerException
			System.out.println( iarr[ 3 ].toString() ); // IndexOutOfBoundsException 
			 //^ Bricht bei der 1. Exception ab auch wenn mehrere ausgelöst werden würden
			
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			//Einfach eine Nachricht
			System.err.println("Eine NullPointerException oder eine IndexOutOfBoundsException wurde verursacht.\n");
			
			//Herausfinden welcher der Fehler
			System.err.println("Art des Fehlers: " + e.getClass().getSimpleName() + "\n");
			
			//Bekannte Ausgabe bei einer Exception ausgeben lassen:
			e.printStackTrace();
		}

	}

}
