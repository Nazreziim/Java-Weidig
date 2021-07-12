public class Main {
	public static void main(String[] args) {
		Baum baum = new Baum();
		baum.add(38);
		baum.add(14);
		baum.add(10);
		baum.add(56);
		baum.add(46);
		
		System.out.println(baum);
		System.out.println(baum.hoehe());
		
		baum.loesche(38);
		System.out.println(baum);
	}
}
