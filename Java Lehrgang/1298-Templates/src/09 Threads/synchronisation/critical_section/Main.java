package synchronisation.critical_section;

public class Main {
	public static void main(String[] args) {
		Counter c = new Counter();
		CriticalThread t1 = new CriticalThread(c);
		CriticalThread t2 = new CriticalThread(c);
		//CriticalThread t3 = new CriticalThread(c);
		//CriticalThread t4 = new CriticalThread(c);
		System.out.println("Eine kritische Sektion:");
		t1.start();
		t2.start();
		//t3.start();
		//t4.start();
		
		

	}

}
