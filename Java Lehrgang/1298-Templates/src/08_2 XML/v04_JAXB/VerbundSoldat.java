package v04_JAXB;

import java.util.Date;

public class VerbundSoldat {
	
	private String name;
	
	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public Date getGebTag() {
		return gebTag;
	}

	
	public void setGebTag(Date gebTag) {
		this.gebTag = gebTag;
	}

	private Date gebTag;

}
