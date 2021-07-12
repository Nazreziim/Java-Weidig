package v03_JDOM;

import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.*;
import org.jdom2.output.*;


public class JDOMWrite {

	public static void main(String[] args) {
		Element root = new Element("Wurzel");
		Element kind1 = new Element("Kind");
		Element kind2 = new Element("Kind");
		kind1.addContent("Beschreibung des ersten Knotens.");
		kind2.addContent("Beschreibung des zweiten Knotens.");
		root.addContent(kind1);
		root.addContent(kind2);
		Attribute a = new Attribute("Alter","23");
		kind2.setAttribute(a);
		
		Document doc = new Document(root);
		
		try {
			XMLOutputter outConsole = new XMLOutputter();
			outConsole.output(doc, System.out);
			
			XMLOutputter outFile = new XMLOutputter();
			outFile.setFormat(Format.getPrettyFormat());
			FileOutputStream fos = new FileOutputStream("./08_2 XML/v03_JDOM/example2.xml");
			outFile.output(doc, fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
