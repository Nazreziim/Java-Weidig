package bsp.hg.collection;
import java.util.*;

public class NumericalCollector {
	
	//stores Numericals
	//private Numerical[] numericals;
	private ArrayList numericalsArray;
	private int lastPosition;

	//Constructor, which creates storage for numericals 
	public NumericalCollector() {
		super();
		//numericals = new Numerical[100];
		numericalsArray = new ArrayList();
	}

	//Getter / Setter
	
	//add Numerical to end of ArrayList
	public void addNumerical(Numerical numerical) {
		//numericals[lastPosition++]=numerical;
		numericalsArray.add(numerical);
	}
	
	
	//get entry at position within ArrayList (position is a function parameter)
	public Numerical getNumerical(int position) {
		Numerical retNumerical;
		//retNumerical = this.numericals[position];
		retNumerical = (Numerical) numericalsArray.get(position);		
		return retNumerical;
				
	}
	
	//get number of elements within list
	public int getCount() {
		return numericalsArray.size();					
	}

}
