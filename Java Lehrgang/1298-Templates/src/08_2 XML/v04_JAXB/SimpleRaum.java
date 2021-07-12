package v04_JAXB;

import java.io.File;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="EinfacherRaum")
public class SimpleRaum {

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

	// Automatische Speicherung mit mit annonymen Konstruktor
	public SimpleRaum() {
	}

	public SimpleRaum(String name, int kapa) {
		this.kapa = kapa;
		this.name = name;
		this.insassen = 0;
	}

	public static void main(String[] args) {
		SimpleRaum r1 = new SimpleRaum("WC", 3);
		@SuppressWarnings("unused")
		SimpleRaum r2;

//		JAXB.marshal(r1, System.out);
		
		File file = new File("./10 XML/v04_JAXB/raum.xml");
		
		JAXB.marshal(r1, file);
		
		
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SimpleRaum sr = JAXB.unmarshal(file, SimpleRaum.class);
		System.out.println(sr.name);
		
	}
}