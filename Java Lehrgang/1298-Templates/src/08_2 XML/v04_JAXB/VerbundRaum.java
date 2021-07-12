package v04_JAXB;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="EinfacherRaum")
public class VerbundRaum {

	//private Attribute ohne Getter und Setter werden nicht gespeichert
	// um sie doch zu speichern, können Annotations genutzt werden
	@XmlElement(name="LgTlnImRaum")
	private int insassen;

	//öffentliche Attribute werden automatisch gespeichert 
	public String name;

	// private Attribute mit öffentlichen Getter UND Setter werden automatisch gepseichert
	private int kapa;
	public int getKapa() {
		return this.kapa;
	}
	public void setKapa(int kapa) {
		this.kapa = kapa;
	}
	
	@XmlElement(name="VerbundSoldat")
	public VerbundSoldat vs;
	
	@XmlElementWrapper(name="Soldaten")
	@XmlElement(name="SoldatenListe")
	public List<VerbundSoldat> solList;

	// Automatische Speicherung mit mit annonymen Konstruktor
	public VerbundRaum() {
	}

	public VerbundRaum(String name, int kapa) {
		this.kapa = kapa;
		this.name = name;
		this.insassen = 0;
		
		this.vs = new VerbundSoldat();
		vs.setName("WC-Soldat");
//		vs.setGebTag(new GregorianCalendar(1938, Calendar.AUGUST, 30).getTime());
	}

	public static void main(String[] args) {
		VerbundRaum r1 = new VerbundRaum("WC", 3);
		@SuppressWarnings("unused")
		
		// SoldatenListe
		VerbundSoldat vs1 = new VerbundSoldat();
		vs1.setName("OberAufpasser");
		VerbundSoldat vs2 = new VerbundSoldat();
		vs2.setName("UnterAufpasser");
		r1.solList = Arrays.asList(vs1, vs2);

		File file = new File("./10 XML/v04_JAXB/raum.xml");
		
		JAXB.marshal(r1, file);
		
		VerbundRaum sr = JAXB.unmarshal(file, VerbundRaum.class);
		System.out.println(sr.name);
		System.out.println(sr.vs.getGebTag());
		
	}
}