package assertions;


public class TestAssertion {

	public static void main(String[] args) {
		Assertions ass = new Assertions();
		String[] testtext0 = {"1"};
		ass.main(testtext0);
		String[] testtext1 = {"1","2"};
		ass.main(testtext1);
		String[] testtext2 = {"1","2","3"};
		ass.main(testtext2);
	}
}
