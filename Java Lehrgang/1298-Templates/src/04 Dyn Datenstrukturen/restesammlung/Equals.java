package restesammlung;

public class Equals {

	public static void main(String[] args) {
		Person p1 = new Person("Lars Gerhard", 29, 186);
		Person p2 = new Person("Lars Gerhard", 29, 186);
		Person p3 = new Person("Lars Gerhard", 30, 185);
		Person p4 = p1;
		//Person p5 = p1.clone();
		System.out.println(p1 == p2);
		System.out.println(p1 == p4);
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p4));
		System.out.println("---------------");
		
		String str1 = "Hallo";
		String str2 = "Hallo";
		String str3 = new String("Hallo");
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
	}

}
