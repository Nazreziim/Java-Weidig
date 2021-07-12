package v05_JAXB_XSD;

import java.util.Date;

public class Spieler {

	private String name;
	private Date birthday;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String s) {
		this.name = s;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}