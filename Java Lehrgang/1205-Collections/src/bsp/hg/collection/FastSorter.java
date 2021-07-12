package bsp.hg.collection;
import java.util.ArrayList;


public class FastSorter extends Sorter{

	@Override
	public NumericalCollector sort(NumericalCollector collector) {
		
		ArrayList sortArray = new ArrayList();
		NumericalCollector sortedNumericals;
		
		//create an ArrayList with content of collector
		for(int i=0; i<collector.getCount(); i++) {
			sortArray.add((Integer)collector.getNumerical(i).getContent());
		}
		
		//sort Array List		
		sortArray.sort(null);
		
		//create new Numerical Collector for return
		sortedNumericals=new NumericalCollector();
		
		//fill sortedNumericals
		for (int j=0; j<sortArray.size();j++) {
			sortedNumericals.addNumerical(new Numerical(sortArray.get(j)));
		}
		
		//return sorted numericals
		return sortedNumericals;
		
	}//sort

	
}//FastSorter
