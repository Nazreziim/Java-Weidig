package schritt2MitGenericHG;

import java.awt.List;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.LinkedList;

public class DynamicHelper {
	
	public LinkedList getMethodNamesOfObjectInBox(Box box) {
		LinkedList methodNames = new LinkedList();
		//get Object within box
		Object content = box.getInhalt();
		//get methods of content (embedded object within box)
		Method[] methods = content.getClass().getDeclaredMethods();
		String actualMethods;	
		for (int i=0; i<methods.length; i++) {
			actualMethods = methods[i].getName();
		    System.out.println("Method: " + actualMethods);
		    methodNames.add(actualMethods);
		}
		return methodNames;
	 
	}

	public static void main(String[] args) {
		

	}
}

