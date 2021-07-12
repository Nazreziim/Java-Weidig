package observer.version1;

import java.util.Vector;

public class Model {
	private Vector<Observer> observers;
	
	private int zaehler;
	
	
	
	public Model(){
		zaehler=0;
		observers=new Vector<Observer>();
	}
	
	public void addObserver(Observer observer){
		observers.add(observer);
	}
	
	
	public void erhoehe(){
		zaehler++;
		update();
	}
	
	public int getZaehler(){
		return zaehler;
	}
	
	public void update(){
		for(int i=0; i<observers.size(); i++){
			observers.elementAt(i).update();
		}
	}
}
