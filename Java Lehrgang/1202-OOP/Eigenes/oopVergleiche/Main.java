package oopVergleiche;

public class Main {
	public static void main(String[] args) {
		Ich ich = new Ich();
		Ich anderesIch = new Ich();
		Ich ich2 = ich;
		Ich ich3 = ich.immernochIch();

		System.out.println("---------------------------");
		System.out.println("Mit == Operator");
		System.out.println("---------------------------");

		// Mit == Operator
		System.out.println(ich == anderesIch);
		System.out.println(anderesIch == ich2);
		System.out.println(ich2 == ich3);
		System.out.println(ich == ich2);
		System.out.println(ich == ich3);

		// ABSATZ
		System.out.println("---------------------------");
		System.out.println("Mit .equals");
		System.out.println("---------------------------");

		// Mit .equals
		System.out.println(ich.equals(anderesIch));
		System.out.println(anderesIch.equals(ich2));
		System.out.println(ich2.equals(ich3));
		System.out.println(ich.equals(ich2));
		System.out.println(ich.equals(ich3));

		// ABSATZ
		System.out.println("---------------------------");
		System.out.println("Mit instanceof Ich");
		System.out.println("---------------------------");

		// instanceof Ich
		System.out.println(ich instanceof Ich);
		System.out.println(anderesIch instanceof Ich);
		System.out.println(ich2 instanceof Ich);
		System.out.println(ich instanceof Ich);
		System.out.println(ich instanceof Ich);

		// ABSATZ
		System.out.println("---------------------------");
		System.out.println("Mit instanceof Mensch");
		System.out.println("---------------------------");

		// instanceof Mensch
		System.out.println(ich instanceof Mensch);
		System.out.println(anderesIch instanceof Mensch);
		System.out.println(ich2 instanceof Mensch);
		System.out.println(ich instanceof Mensch);
		System.out.println(ich instanceof Mensch);

		// ABSATZ
		System.out.println("---------------------------");
		System.out.println("Mit instanceof Säugetier");
		System.out.println("---------------------------");

		// instanceof Säugetier
		System.out.println(ich instanceof Säugetier);
		System.out.println(anderesIch instanceof Säugetier);
		System.out.println(ich2 instanceof Säugetier);
		System.out.println(ich instanceof Säugetier);
		System.out.println(ich instanceof Säugetier);

		// ABSATZ
		System.out.println("---------------------------");
		System.out.println("Klassen");
		System.out.println("---------------------------");

		// Klassen
		System.out.println(ich.getClass());
		System.out.println(anderesIch.getClass());
		System.out.println(ich2.getClass());
		System.out.println(ich3.getClass());

		// ABSATZ
		System.out.println("---------------------------");
		System.out.println("Mit .getClass.isInstance");
		System.out.println("---------------------------");

		// .getClass().isInstance()
		System.out.println(ich.getClass().isInstance(anderesIch));
		System.out.println(anderesIch.getClass().isInstance(ich2));
		System.out.println(ich2.getClass().isInstance(ich3));
		System.out.println(ich.getClass().isInstance(ich2));
		System.out.println(ich.getClass().isInstance(ich3));
		
		
	}
}
