package vererbung.firma;

public class Firma{
	private Mitarbeiter mitarbeiter[];
	
	public Firma(){
		mitarbeiter = new Mitarbeiter[50];
	}
	
	public void add(Mitarbeiter arbeiter){		
		boolean b = true;
		for(int i = 0; i < this.mitarbeiter.length && b; i++){
			if(this.mitarbeiter[i]==null){
				this.mitarbeiter[i]=arbeiter;
				b = false;
			}
		}
	}
	public void printMitPersNr(int persNr){
		for(int i = 0; i < this.mitarbeiter.length; i++){
			if(this.mitarbeiter[i]!=null){
				if(this.mitarbeiter[i].getPersNr() == persNr){
					this.mitarbeiter[i].print();
				}
			}
		}
	}

}
