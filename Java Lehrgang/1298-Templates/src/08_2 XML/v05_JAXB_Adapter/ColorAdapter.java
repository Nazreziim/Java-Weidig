package v05_JAXB_Adapter;

import java.awt.Color;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ColorAdapter extends XmlAdapter<String, Color> {

	private final String trenner = " ";

	public Color unmarshal(String value) throws Exception {
		String[] list = value.split(this.trenner);
		Color c = new Color(Integer.parseInt((list[0])), Integer.parseInt(list[1]), Integer.parseInt(list[2]), Integer.parseInt(list[3]));
		return c;
	}

	public String marshal(Color c) throws Exception {
		StringBuilder sb = new StringBuilder("");
		sb.append(c.getRed());
		sb.append(this.trenner);
		sb.append(c.getGreen());
		sb.append(this.trenner);
		sb.append(c.getBlue());
		sb.append(this.trenner);
		sb.append(c.getAlpha());
		return sb.toString();
	}
}