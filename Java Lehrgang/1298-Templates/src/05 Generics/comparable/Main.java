package comparable;


public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("Lars Gerhard", 186);
		Person p2 = new Person("Ruediger Huesch", 179);
		System.out.println(p2.compareTo(p1));

	}

}
