package baeume.vorlage;

public class Test{

	public static void main(String args[]){
		Tree baum = new Tree();
		baum.add(5);
		baum.add(4);
		baum.add(2);
		baum.add(7);
		baum.add(6);
		baum.print_io();
		baum.delete(5);
		System.out.println();
		baum.print_io();
		
	}
}
