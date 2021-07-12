package aufgaben.listStack;

import java.util.*;


public class ListStack<E> implements Stack<E> {
	private Deque<E> st = new LinkedList<E>();
	
	public boolean empty() {
		 return st.size()==0;
	}
	public E pop() {
		return st.removeLast();		
	}
	public void push(E elem) {
		st.add(elem);
	}
	public E peek() {
		return st.getFirst();
	}


}
