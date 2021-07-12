package zusammenfassung;



/**
 * @author lgerhard
 * @version 1.0
 * @created 17-Jun-2014 14:19:25
 */
public class Person implements Lebewesen {

	private String name;
	private int schuhgroesse;
	private Haustier[] tiere;
	public Haustier m_Haustier;

	public Person(){

	}

	public void finalize() throws Throwable {

	}
	public void bewegen(){

	}

	public String getName(){
		return "";
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name){

	}
}//end Person