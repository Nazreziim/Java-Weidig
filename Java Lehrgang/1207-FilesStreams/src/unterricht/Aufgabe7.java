package unterricht;

import java.io.Console;
import java.io.File;

public class Aufgabe7{

	public static void main(String[] agrs){
		File aktVerz = new File("");
		Console con = System.console();
		
		if ( con != null ){
		   con.printf("<jAvA::%s>", aktVerz.getAbsolutePath());
		   String eingabe = null;
		   do {
			   
			   eingabe = con.readLine();
			   switch (eingabe) {
			   		case "rm" :
			   			break;
			   		case "cd" :
			   			break;
			   		case "ls" :
			   			break;
			   		case "mkdir" :
			   			break;
			   		case "" :
			   			break;
			   		default:
					   System.out.println("Befehl nicht bekannt!");
			   }
			   System.out.println(eingabe);
		   
		   }while(!eingabe.isEmpty());
		}
	}

}