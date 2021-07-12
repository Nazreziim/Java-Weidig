package v03_JDOM;

import java.io.IOException;
import java.util.Iterator;
import org.jdom2.*;
import org.jdom2.input.*;

public class JDOMRead {

	public static void main(String[] args) {
		try {
			Document doc = new SAXBuilder().build("./08_2 XML/v03_JDOM/example.xml");
			Element root = doc.getRootElement();
			System.out.println(root.getName());
			Iterator<Content> it = root.getContent().iterator();
			while (it.hasNext()) {
				Content c = it.next();
				if(c.getClass().toString().equals("class org.jdom2.Text"))
					System.out.println(c.getValue());
			}
			
		} catch (JDOMException e) {
			System.out.println(e.getMessage());
			//e.p .printStackTrace();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
