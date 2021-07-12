public class Kurzschluss {
	public static void main(String[] args) {
		
		System.out.println(false && ausgabe());
		System.out.println(true || ausgabe());
		
		System.out.println(false & ausgabe());
		System.out.println(true | ausgabe());
	}
	
	public static boolean ausgabe() {
		System.out.println("Ich wurde aufgerufen");
		
		return true;
	}
}
