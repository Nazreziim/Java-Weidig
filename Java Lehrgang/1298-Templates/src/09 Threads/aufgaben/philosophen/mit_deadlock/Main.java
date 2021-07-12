package aufgaben.philosophen.mit_deadlock;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gabel g1 = new Gabel();
		Gabel g2 = new Gabel();
		Gabel g3 = new Gabel();
		Gabel g4 = new Gabel();
		Philosoph p = new Philosoph("Platon",g2,g1);
		Philosoph a = new Philosoph("Aristoteles",g3,g2);
		Philosoph f = new Philosoph("Freud",g4,g3);
		Philosoph k = new Philosoph("Kant",g1,g4);
		p.start();
		a.start();
		f.start();
		k.start();
	}

}

/*
 * p.setDaemon(true);
		a.setDaemon(true);
		f.setDaemon(true);
		k.setDaemon(true);
 */
