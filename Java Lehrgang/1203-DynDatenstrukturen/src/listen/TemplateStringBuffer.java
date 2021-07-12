package listen;

public class TemplateStringBuffer {

	
	public static void main(String[] args) {
		StringBuffer sb1= new StringBuffer();
		StringBuffer sb2= new StringBuffer(30);
		StringBuffer sb3= new StringBuffer("Test");
		
		// Kapazitaet ist groesse des Buffer der vorgehalten wird, und Laenge ist die aktuelle genutzte groesse des Buffers
		System.out.printf("Kapazitaet sb1: %d  und Groesse: %d\n" , sb1.capacity(), sb1.length());
		System.out.printf("Kapazitaet sb2: %d  und Groesse: %d\n" , sb2.capacity(), sb2.length());
		System.out.printf("Kapazitaet sb3: %d  und Groesse: %d\n" , sb3.capacity(), sb3.length());
	
		System.out.println();
		
		sb1.append("Hallo Feldafing");
		System.out.printf("Kapazitaet sb1: %d  und Groesse: %d\n" , sb1.capacity(), sb1.length());
		sb1.append("\tHallo Lehrgangsteilnehmer");
		System.out.printf("Kapazitaet sb1: %d  und Groesse: %d\n" , sb1.capacity(), sb1.length());
		System.out.println(sb1.toString());
	    // neue Laenge geringer als aktuelle Laenge
		// Werte werden abgeschnitten
		sb1.setLength(30);
		System.out.printf("Kapazitaet sb1: %d  und Groesse: %d\n" , sb1.capacity(), sb1.length());
		System.out.println(sb1.toString());
		
		// neue Laenge ist groesser als aktuelle Laenge
		// Rest wrid mit Leerzeichen aufgefuellt
		sb1.setLength(40);
		sb1.append("Ende");
		System.out.printf("Kapazitaet sb1: %d  und Groesse: %d\n" , sb1.capacity(), sb1.length());
		System.out.println(sb1.toString());
	}

}
