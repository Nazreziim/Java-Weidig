Name:
Dienstgrad:

public class Aufgabe5{
	
	public static void main(String[] args){
		Hund putzi = new Hund(503, 510152, "Rottweiler", 'w', 1998 );
		putzi.setIsKastriert( HilfsMeth.readBoolean("Ist Putzi kastriert?") );
		Hund bello = new Hund(504, 640631);
		fillHundeDaten(bello);
		if( bello.isKreuzbarMit(putzi) ){
			System.out.println("Putzi und Bello dürfen heiraten");
		}
		
		if(bello.impfungFaellig(2006) == true){
			System.out.println("Bello muss 2006 geimpft werden.");
		}
		else{
			System.out.println("Bello muss 2006 nicht geimpft werden.");
		}
	}
	
	public static void fillHundeDaten(Hund hund){
		hund.setRasse( HilfsMeth.readString("Bitte Hundesrasse eingeben: ") );
		hund.setGeschlecht( HilfsMeth.readChar("Bitte Geschlecht eingeben: ") );
		hund.setGeburtsjahr( HilfsMeth.readInt("Bitte Geburtsjahr eingeben: ") );
		hund.setIsKastriert( HilfsMeth.readBoolean("Bitte Kastrationsstatus eingeben: ") );
	}
	
}
