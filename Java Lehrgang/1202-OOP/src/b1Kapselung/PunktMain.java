package b1Kapselung;


class PunktMain {

	public static void main(String[] args) {
		Punkt p1 = new Punkt();
		System.out.println(p1.getX());
		System.out.println(p1.getY());
		
		Punkt p2 = new Punkt(10,10);
		System.out.println(p2.getX());
		System.out.println(p2.getY());
	}

}