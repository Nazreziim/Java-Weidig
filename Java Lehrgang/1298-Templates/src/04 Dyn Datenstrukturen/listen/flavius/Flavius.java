package listen.flavius;

public class Flavius {
	private Sklave start;
	
	public Flavius() {
		this.start = null;
	}
	
	public void nimm_auf(String name) {
		if (name != "_") {
			Sklave neu = new Sklave(name);
			if (start == null) {
				start = neu;
			} else {
				start.add_hinten(neu);
			}
		}else {
			this.start.schliesse_kreis(start);
		}
	}

	public void zaehle_aus(int anz_silben) {
		System.out.println("Start bei: " + start.getName());
		
		// Wenn der next-Zeiger auf dasselbe Element zeigt, ist nur noch einer übrig
		while (start.getNext() != start) {
			// Abzählen: Weitersetzen eines Hilfpointers (anz_silben - 1 Mal!)
			// danach steht start auf dem Vorgänger des zu entfernenden Sklaven 
			for (int i=1; i < anz_silben; i++) {
				start = start.getNext();
			}

			System.out.println(start.getNext().getName() + " stirbt.");
			// Ausketten = Entfernen
			start.setNext(start.getNext().getNext());
		}
		System.out.println(start.getName() + " ueberlebt.");		
	}
}
