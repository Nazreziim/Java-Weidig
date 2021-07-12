package _4Throws;

public class ThrowsInMethoden {
	public static void main(String[] args) {
		
		//exceptionMethode2(); //Muss behandelt werden --> checked
		exceptionMethode1();  //Muss nicht behandelt werden --> unchecked [KANN aber behandelt werden]
		exceptionMethode3();  //Muss nicht behandelt werden --> unchecked [KANN aber behandelt werden]
		
	} 

	//RuntimeExceptions = unchecked --> müssen NICHT behandelt werden 
	// Try/Catch um Methode in der Main machen um zu zeigen, dass eine Weiterreichung stattfindet
	public static void exceptionMethode1() throws RuntimeException {
		// Siehe _1aufzeigen --> Wird eine NullPointer werfen
		String exception = null;
		exception.toString();
	}

	//Alle anderen Exceptions als RuntimeExceptions
	public static void exceptionMethode2() throws Exception{
		
	}
	
	public static void exceptionMethode3() throws StackOverflowError{
		
	}
}