public class Main {
	public static void main(String[] args) {
		Baum b = new Baum();
		
		b.add(5);
		b.add(4);
		b.add(7);
		b.add(1);
		b.add(6);
		b.add(9);
		b.add(3);
		b.add(1);
		b.show();
		System.out.println();
		b.drop(3);
		b.show();
		System.out.println();
		b.drop(5);
		b.show();
		System.out.println();
		
		System.out.println("Die Hoehe des Baumes ist: " + b.getHoehe());
	}

}
