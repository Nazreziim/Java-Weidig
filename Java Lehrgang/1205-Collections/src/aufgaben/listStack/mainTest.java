package aufgaben.listStack;
import java.util.*;


public class mainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*SortedSet<String> menge2 = new TreeSet<String>();
		menge2.add("Erster");
		menge2.add("Zweiter");
		menge2.add("Dritter");
		System.out.println(menge2);*/
		
		ListStack<Integer> ls = new ListStack<Integer>();
		ls.push(1);
		ls.push(2);
		ls.push(3);
		System.out.println(ls.pop());
		System.out.println(ls.peek());
		System.out.println(ls.pop());
		
		
		

	}

}
