package bsp.hg.collection;
import java.util.Random;


public class NumericalTest {
	
	private static final int MAXTESTNUMERICALS = 250;
	private static final int MAXRANDOMVAL = 90000;
	private static double startTime;	
	private static double runningTime1, runningTime2;
	
	
	
	/*------------------------------------------------------------------------------------------------
	main method
	------------------------------------------------------------------------------------------------*/
	public static void main(String[] args) {

		
		//create new storage for numericals
		NumericalCollector collectorSlow;
		NumericalCollector collectorFast;
		NumericalCollector collector;
		
		
		//create new collector with random numbers
		collectorSlow=createRandomNumericals(MAXTESTNUMERICALS, MAXRANDOMVAL);
		collectorFast=createRandomNumericals(MAXTESTNUMERICALS, MAXRANDOMVAL);
		
		
		
		//Output
		System.out.println("---------------Before Sort!------------------");
		//output(collector);
		
		//sort
		Sorter sorterSlow=new Sorter();
		FastSorter sorterFast=new FastSorter();
		
		//Slow Sort
		startTime = System.nanoTime();
		System.out.println("Sort 1: ---------------Before Sort!------------------");
		collector=sorterSlow.sort(collectorSlow);
		runningTime1 = (System.nanoTime() - startTime) / 1000;
		

		//Fast Sort
		startTime = System.nanoTime();
		System.out.println("Sort 2: ---------------Before Sort!------------------");
		collector=sorterFast.sort(collectorFast);
		runningTime2 = (System.nanoTime() - startTime) / 1000;
	
		
		//Output		
		System.out.println("---------------After Sort!------------------");
		output(collector);				
		System.out.printf("Laufzeit Sort 1: %.6f Mikrosekunden\n",runningTime1);
		System.out.printf("Laufzeit Sort 2: %.6f Mikrosekunden\n",runningTime2);

	}//main
	
	
	/*------------------------------------------------------------------------------------------------
	createRandomNumericals: creates random numericals and saves them within NumericalCollector. 
	Size of collector is delivered to method as parameter
	------------------------------------------------------------------------------------------------*/		
	private static NumericalCollector createRandomNumericals(int numcount, int maxRandomValue) {
		
		Random rnd = new Random();
		
		//create new storage for numericals
		NumericalCollector collector = new NumericalCollector();
		
		
		//Create numericals
		for(int i=0; i<numcount;i++) {
			
			//Create numerical with random number
			Numerical <Integer> numerical =  new Numerical<Integer>(rnd.nextInt(maxRandomValue));
			
			//save numerical within storage
			collector.addNumerical(numerical);
			
		}
		
		return collector;
	}
	
	/*------------------------------------------------------------------------------------------------
	output method
	------------------------------------------------------------------------------------------------*/	
	
	private static void output (NumericalCollector collector) {
		//output
		for(int j=0; j<MAXTESTNUMERICALS;j++) {
							
			//Create String Container
			Numerical <Integer> numericalout;
			
			//save numerical within storage
			numericalout = collector.getNumerical(j);
			
			//Output
			System.out.println("Numerical Nr"+j+": "+ numericalout.getContent());
		
		}//for
		
	}//output
	
	
}//NumericalTest
