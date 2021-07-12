package schritt2MitGenericHG;

import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.*;

import java.util.Iterator;
import java.util.LinkedList;

public class Box< T > {
  private T inhalt;
  LinkedList<String> methodNames;
  
  public Box( T inhalt ) {
    this.setInhalt( inhalt );
    methodNames = new LinkedList<String>();
  }

  public T getInhalt() {
    return this.inhalt;
  }

  public void setInhalt( T inhalt ) {
    this.inhalt = inhalt;
  }
  
  
  public void registerNewMethod(String methodName) {
	  //register name of new method within LinkedList
	  methodNames.add(methodName);
  }
  
  public void callAllRegisteredMethods() {
	  //calls all registered methods of registered class
	// iterate through list descending
	Iterator<String> it = this.methodNames.listIterator();
			
			while ( it.hasNext()){
				//call method within iteration
				try {
					this.getInhalt().getClass().getMethod(it.next()).invoke(this.getInhalt());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}			
	  
  }  
  
  public String getKlassentyp() {
	  /* liefert Klassentyp als SimpleName zurück */	  
	  String KlassenTyp;
	  KlassenTyp=this.getInhalt().getClass().getSimpleName();
	  return KlassenTyp;
  }
  
 
  
}
