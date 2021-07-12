package listen.flavius;

public class Sklave {
	private String name;
	private Sklave next;
	
	
	public Sklave(String name) {
		this.name = name;
		this.next = null;
	}

	public void setNext(Sklave neu) {
		this.next = neu;
		
	}

	public Sklave getNext() {
		return this.next;
	}	
	
	public String getName() {
		return name;
	}
	
	public void add_hinten(Sklave neu) {
		if (this.getNext() == null) {
			this.setNext(neu);
		} else {
			this.getNext().add_hinten(neu);
		}
		
	}

	public void schliesse_kreis(Sklave start) {
		if (this.getNext() == null) {
			this.setNext(start);
		} else {
			this.getNext().schliesse_kreis(start);
		}		
	}





}
