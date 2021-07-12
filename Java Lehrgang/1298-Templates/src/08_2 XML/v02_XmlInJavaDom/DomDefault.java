package v02_XmlInJavaDom;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


public class DomDefault {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("08_2 XML/v01_Basics/example.xml"));
			System.out.println(doc.getFirstChild().getChildNodes().item(1).getChildNodes().item(1).getTextContent());
			System.out.println(doc.getFirstChild().getChildNodes().item(1).getChildNodes().item(1).getAttributes().getNamedItem("Alter").getNodeValue());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}