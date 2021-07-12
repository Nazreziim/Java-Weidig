package vererbung;

public class Ich extends Mensch {

	public Ich() {
		this.setName("Weidig");
		super.setName("Hugo");

	}

	@Override
	public void setAlter(int alter) {
		System.out.println("Klasse: Ich");
	}
	
	

}
