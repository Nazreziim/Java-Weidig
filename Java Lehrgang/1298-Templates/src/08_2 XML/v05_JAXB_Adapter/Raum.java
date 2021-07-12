package v05_JAXB_Adapter;

import java.awt.Color;
import java.io.File;
import java.util.*;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

@XmlRootElement
public class Raum {
	private List<Spieler> spielerliste = new ArrayList<Spieler>();

	@XmlJavaTypeAdapter(ColorAdapter.class)
	public Color raumfarbe;

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
		johnDoe.setBirthday(new GregorianCalendar(1939, Calendar.AUGUST, 30).getTime());

		Spieler janeDoe = new Spieler();
		janeDoe.setName("Jane D.");
		//janeDoe.setBirthday(new GregorianCalendar(1949, Calendar.AUGUST, 30).getTime());

		Raum r = new Raum();
		r.name = "Kaffeerauminnenfach";
		r.zahl = 2;
		r.raumfarbe = Color.LIGHT_GRAY;
		r.setSpielerliste(Arrays.asList(johnDoe, janeDoe));
		System.out.println("Farbe r1: "+r.raumfarbe.toString() + " " + r.raumfarbe.getAlpha());
		
		JAXB.marshal(r, new File("./src/xml/v06_JAXB/v03_Adapter/raum.xml"));
		Raum r2 = JAXB.unmarshal(new File("./src/xml/v06_JAXB/v03_Adapter/raum.xml"), Raum.class);
		
		System.out.println(((Raum)r2).name);
		System.out.println(r2.getSpielerliste().get(0).getName());
		System.out.println(r2.getSpielerliste().get(1).getName());
		System.out.println(r2.getSpielerliste().get(0).getBirthday());
		System.out.println(r2.getSpielerliste().get(1).getBirthday());
		System.out.println("Farbe r2: "+r2.raumfarbe.toString() + " " + r2.raumfarbe.getAlpha());
	}
}