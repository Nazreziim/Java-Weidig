package v05_JAXB_XSD;

import java.io.File;
import java.util.*;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Raum {
	private List<Spieler> spielerliste = new ArrayList<Spieler>();

	public int zahl = 9;
	public String name;

	@XmlElementWrapper
	@XmlElement(name="Spieler")
		public List<Spieler> getSpielerliste() {
		return spielerliste;
	}
	
	public void setSpielerliste(List<Spieler> spielerliste) {
		this.spielerliste = spielerliste;
	}

	public static void main(String[] args) {
		Spieler johnDoe = new Spieler();
		johnDoe.setName("John D.");
		johnDoe.setBirthday(new GregorianCalendar(1938, Calendar.AUGUST, 30).getTime());

		Spieler janeDoe = new Spieler();
		janeDoe.setName("Jane D.");
		//janeDoe.setBirthday(new GregorianCalendar(1949, Calendar.AUGUST, 30).getTime());

		Raum r = new Raum();
		r.name = "Kaffeerauminnenfach";
		r.zahl = 2;
		r.setSpielerliste(Arrays.asList(johnDoe, janeDoe));
		
		JAXB.marshal(r, new File("./src/xml/v06_JAXB/v04_MitXSD/raum.xml"));
		Raum newRaum = JAXB.unmarshal(new File("./src/xml/v06_JAXB/v04_MitXSD/raum.xml"), Raum.class);
		
		System.out.println(((Raum)newRaum).name);
		System.out.println(newRaum.getSpielerliste().get(0).getName());
		System.out.println(newRaum.getSpielerliste().get(1).getName());
		System.out.println(newRaum.getSpielerliste().get(0).getBirthday());
		System.out.println(newRaum.getSpielerliste().get(1).getBirthday());
	}
}