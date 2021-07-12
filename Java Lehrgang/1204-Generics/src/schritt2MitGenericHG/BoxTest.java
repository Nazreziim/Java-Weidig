package schritt2MitGenericHG;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedList;

import schritt1OhneGeneric.hund.Hund;
import schritt1OhneGeneric.katze.Katze;
import schritt1OhneGeneric.object.Mensch;
import schritt1OhneGeneric.object.Schueler;


public class BoxTest {
  public static void main( String[] args ) {

    Box< Hund > box1 = new Box< Hund >( new Hund() );
    Box< Katze > box2 = new Box< Katze >( new Katze() );
    Box< Mensch > box3 = new Box< Mensch >( new Mensch() );
    Box< Schueler > box4 = new Box< Schueler >( new Schueler() );

    System.out.println( box1.getInhalt() );
    box1.getInhalt().bellen();
    // box1.getInhalt().miau(); // Geht nicht, weil kein Hund

    System.out.println( box2.getInhalt() );
    // box2.getInhalt().bellen();
    box2.getInhalt().miau();

    System.out.println( box3.getInhalt() );
    box3.getInhalt().sprechen();

    System.out.println( box4.getInhalt() );
    box4.getInhalt().sprechen();
    box4.getInhalt().lernen();

    Box< Box< Hund > > hbbox = new Box<>( new Box<>( new Hund() ) );
    System.out.println( hbbox.getClass().getCanonicalName() );
    System.out.println( hbbox.getClass().getSimpleName() );
    System.out.println( hbbox.getClass().getName() );
    
        
    //Klassentyp der Box ermitteln    
    System.out.println("Klassentyp: "+box1.getKlassentyp());
    try {
		System.out.println("Dynamischer Methodenaufruf:");
    	box4.getInhalt().getClass().getMethod("sprechen").invoke(box4.getInhalt());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
    /* -----------------------------*/    
    /*dynamische Methodenaufrufe */
    /* -----------------------------*/
   
    
    System.out.println("--------------------");
    System.out.println("Dynamische Methodenaufrufe");    
    
    
    //Methode für Box1 registrieren
  	//box1.registerNewMethod("bellen");

    //Methode für Box1 registrieren
  	//box2.registerNewMethod("miau");

    //Methode für Box1 registrieren
  	//box3.registerNewMethod("sprechen");

    //Methode für Box1 registrieren
  	//box4.registerNewMethod("sprechen");
  	//box4.registerNewMethod("lernen");

  	
  	
    //Klassen registrieren
    LinkedList<Object> klassenNamen = new LinkedList<Object>();
    klassenNamen.add(box1);
    klassenNamen.add(box2);
    klassenNamen.add(box3);
    klassenNamen.add(box4);

    //create dynamicHelperObject    
    DynamicHelper dynhelper = new DynamicHelper();

    //calls all registered methods of registered class
  	// iterate through list descending
  	Iterator<Object> it = klassenNamen.listIterator();
  			
  			while ( it.hasNext()){
  				//call method within class in iteration
  				Box nextObj = ((Box)it.next()); 
  				System.out.println("--------------------");
  		  		System.out.println("Aktuelle Klasse: " + nextObj.getInhalt().getClass().getSimpleName());		
  		  		
  		  		
  		  		LinkedList methodList = dynhelper.getMethodNamesOfObjectInBox(nextObj);
  		  		Iterator<String> methodIterator = methodList.listIterator();
  		  		while (methodIterator.hasNext()) {
  		  			String methodName = ((String)methodIterator.next());
  		  			//register Method
  		  			System.out.println("Registrierung der Methode: " + methodName);
  		  			nextObj.registerNewMethod(methodName);
  		  		}
  		  		//call all registered methods  		  		
  		  		System.out.println("Aufruf aller Methoden der Klasse " + nextObj.getInhalt().getClass().getSimpleName());
 		  		nextObj.callAllRegisteredMethods();
  		  		

  			}
 
  	  	
  } 
    
  	
  
}

