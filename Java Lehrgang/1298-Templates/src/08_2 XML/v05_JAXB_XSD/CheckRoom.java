package v05_JAXB_XSD;

import java.io.*;
import java.net.URL;
import javax.xml.*;
import javax.xml.bind.*;
import javax.xml.validation.*;
import org.xml.sax.SAXException;

public class CheckRoom {

	public static void main(String[] args) {
		try {
			File file = new File("./src/xml/v06_JAXB/v04_MitXSD/raum.xml");
			JAXBContext context;
			context = JAXBContext.newInstance(Raum.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(CheckRoom.class.getResource("/xml/v06_JAXB/v04_MitXSD/Raum.xsd"));
			unmarshaller.setSchema(schema);
			Raum room = (Raum) unmarshaller.unmarshal(file);
			System.out.println(room.name);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}