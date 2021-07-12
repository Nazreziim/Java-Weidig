package generic.hg.ueb;

public class GenericTest {
	
	public static void main(String[] args) {

		//create String Object
		String name1 = new String ("Garbas1");
		
		//Create String Container
		GenericContainer <String> firstcont =  new GenericContainer<String>();
		
		//Store String into container
		firstcont.setContent(name1);
		//set next pointer 
		firstcont.setNext(null);
		
		//create some names...
		String[] examplenames=new String[29];
		for(int i=0;i<examplenames.length;i++) {
			examplenames[i]="Garbas"+(i+2);
			
		}
		
		
		//fill container with names
		GenericContainer <String> prevcont;
		prevcont=firstcont;		
		GenericContainer <String> lastcont = null;
		
		for(int j=0; j<examplenames.length; j++) {
			//Create String Container
			GenericContainer <String> newcont =  new GenericContainer<String>();
			//Store content
			newcont.setContent(examplenames[j]);
			//set pointer to current container within previous container
			prevcont.setNext(newcont);
			newcont.setNext(null);
			newcont.setPrev(prevcont);			
			prevcont=newcont;
			lastcont=newcont;
		}
		
		//output forwards..		
		output(1, firstcont, lastcont);
		
		
		//output backwards..
		output(0, firstcont, lastcont);
		
		//"delete" element number 5
		GenericContainer <String> workcont, workprev, worknext;
		workcont=firstcont;
		System.out.println("Workcont: "+workcont.getContent());
		
		for(int j=0; j<4; j++) {
			//Create String Container
			workcont=workcont.getNext();
			
		}
		//System.out.println("Workcont: "+workcont.getContent());
		workprev=workcont.getPrev();
		//System.out.println("Worprev: "+workprev.getContent());
		worknext=workcont.getNext();
		//System.out.println("Worknext: "+worknext.getContent());
		workprev.setNext(workcont.getNext());
		worknext.setPrev(workcont.getPrev());

		System.out.println("-------------------------------");
		System.out.println("Element 5 deleted - NEW output!");
		//output forwards..		
		output(1, firstcont, lastcont);
				
				
		//output backwards..
		output(0, firstcont, lastcont);
		
		
	}
	
	
	private static void output(int direction, GenericContainer <String> first, GenericContainer <String> last) {
		
		GenericContainer <String> contout;
		
		//0=backwards, 1=forwards
		if(direction==1) {//forwards
		
			System.out.println("----Forwards-----");
			contout=first;
			do {
				System.out.println("Output: "+contout.getContent());			
				contout=contout.getNext();			
			}while(contout!=null);
			
			
		}
		else {//backwards
			
			System.out.println("----Backwards-----");				
			contout=last;
			do {
				System.out.println("Output: "+contout.getContent());
				contout=contout.getPrev();
			}while(contout!=null);
					
		}
		
	}

}
