package equals;

public class Equals {
	public static void main(String[] arg) {
		Person p1 = new Person("Lars Gerhard", 29, 186);
		Person p2 = new Person("Lars Gerhard", 29, 186);
		Person p3 = new Person("Lars Gerhard", 30, 186);
		Person p4 = p1;
		
		System.out.println(p1 == p2);  // false
		System.out.println(p1 == p4);  // true 
		System.out.println(p1.equals(p3)); // false - durch Überschreiben von equals in Person wirds true
		System.out.println(p1.equals(p2)); // false- durch Überschreiben von equals in Person wirds true
		System.out.println("-----------------");
		
		String str1 = "Hallo";
		String str2 = "Hallo";
		String str3 = new String("Hallo");
		
		System.out.println(str1 == str2); // true - wegen String-Pool
		System.out.println(str1 == str3); // false - wie gewohnt
		System.out.println(str1.equals(str3)); // true - vordefiniert!
		
	}
}
