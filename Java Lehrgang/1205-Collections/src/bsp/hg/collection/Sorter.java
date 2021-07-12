package bsp.hg.collection;

public class Sorter {
	
	//constants
	private static int MAXMEMBERS;
	
	//Variables / Attributes
	private NumericalCollector collector;
	private static Integer[] integers;
	
	
	//Constructor	
	public Sorter(NumericalCollector collector) {
		super();
		this.collector = collector;
	}

	public Sorter() {
		super();
	}

	//Getter / Setter
	public NumericalCollector getCollector() {
		return collector;
	}

	public void setCollector(NumericalCollector collector) {
		this.collector = collector;
	}

	/*------------------------------------------------------------------------------------------------
	Sort-method which gets the position of current start of search within int-Array as a parameter
	------------------------------------------------------------------------------------------------*/	
	public void sort (int posArray){
		
		int lowest=integers[posArray];
		int poslowest = 0;
		int exchangeInt = 0;
		boolean tobechanged = false;
		
		//search lowest integer and its position
		for(int i=posArray+1; i<integers.length; i++) {
			if(integers[i]!=null){
				if(integers[i]<lowest) {
					lowest=integers[i];
					poslowest=i;
					//set flag to true
					tobechanged=true;
				}				
			}
			
		}
		
		
		//swap position of current integer (which is NOT the lowest!) and lowest integer
		//during next cycle the search will start at next position after current position
		//example:
		//current order: 3 5 1 4
		//after switch: 1 5 3 4
		//order at next cycle (start pos moved to next position): 5 3 4
		if (tobechanged) {
			exchangeInt = integers[poslowest];
			integers[poslowest]=integers[posArray];
			integers[posArray] = exchangeInt;					
		}
			
		if(posArray==(MAXMEMBERS-2)) {
			return;
		}
		else {	
			
			//recursive call of sort method with posArray moved to next position
			sort(posArray+1);
		}
			
	}
	
	
	
	/*------------------------------------------------------------------------------------------------
	Sort-method which gets a NumericalCollector as a parameter and returns a sorted NumnericalCollector as a result
	------------------------------------------------------------------------------------------------*/
	 
	public NumericalCollector sort (NumericalCollector collector) {
		Numerical <Integer> numericalcheck;
		NumericalCollector sortcollector=new NumericalCollector();
		
		//set MAXMEMBERS to count of NumericalCollector
		MAXMEMBERS = collector.getCount();
		//create instance of integer Array
		integers = new Integer[MAXMEMBERS];
				
		//iterate through array and fill integers array
		for(int i=0; i<MAXMEMBERS;i++) {
			numericalcheck = collector.getNumerical(i);
			integers[i]=numericalcheck.getContent();
		}
		
		
		//call sort method (recursive)
		sort(0);
		
		//iterate through sortarray and fill sortcollector
		for(int i=0; i<MAXMEMBERS;i++) {			
			sortcollector.addNumerical(new Numerical(integers[i]));
			
		}
		
		return sortcollector;
		
	}
	
	
}
