package aufgaben.geometrie;
import java.util.Vector;


public class Figur {
	
	/*protected, um noch einmal zu verdeutlichen, dass die unteren 
	Klassen darauf zugreifen können. Beachten Sie aber, dass 
	in Java alls Dateien des Verzeichnis auf diese Attribute zugreifen 
	können*/
	protected Vector<Punkt> punkte; 
	
	public Figur(Vector<Punkt> punkte){
		this.punkte=punkte;
	}
	
	public void ausgeben(){
		for(int i=0; i<punkte.size();i++){
			punkte.elementAt(i).ausgeben();
		}
	}
	
	public Vector<Punkt> getPunkte(){
		return this.punkte;
	}
	
	public void verschiebe(double umX, double umY){
		for(int i=0; i<punkte.size(); i++){
			punkte.elementAt(i).verschiebe(umX, umY);
		}
	}
	
	public String toString(){
		String ausgabe="";
		for(int i=0; i<punkte.size(); i++){
			ausgabe=ausgabe+" Punkt ("+punkte.elementAt(i).getX()+"/"+punkte.elementAt(i).getY()+") \n" ;
		}
		return ausgabe;
	}
}
