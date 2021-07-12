package generics.liste;

public class Main {
	public static void main (String[] args) {
		// A - readIn
		Liste<Integer> eine_liste = new Liste<Integer>();
		eine_liste.add_hinten(2);
		eine_liste.add_hinten(4);
		eine_liste.add_hinten(7);
		eine_liste.add_hinten(9);
		
		Liste<String> str_liste = new Liste<String>();
		str_liste.add_hinten(new String("Hallo"));
		str_liste.add_hinten(new String("Wiesnzeit"));
		str_liste.add_hinten(new String("Ozapft is"));
		
		Liste<Person> pers_liste = new Liste<Person>();
		Person p = new Person("Lars Gerhard", 186);
		pers_liste.add_hinten(p);
		
		// C - show
		eine_liste.show();
		pers_liste.show();
		str_liste.show();
		System.out.println("-------------");
		
		
		
	}
}
