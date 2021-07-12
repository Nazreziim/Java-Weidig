class Programm {
	public static void main(String[] args) {
		Punkt punkt1 = new Punkt(25, 50);
		
		manipuliere(punkt1);
		
		System.out.println(punkt1.toString());
		
		String s1 = "Hallo";
		String s2 = s1;
		s2 = "Hallo Welt";
		
		System.out.println(s2);
	}
	
	public static void manipuliere(Punkt p) {
		p.verschiebe(10);
		System.out.println(p.toString());
	}
}
