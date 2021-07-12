package alt.zeichnen.version3_images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private BufferedImage img;
	
	protected void paintComponent(Graphics g) {
		// 0.) ImageIcon
		ImageIcon icon = new ImageIcon("./12 GUI/res/trash.gif","Testbild");
		g.drawImage(icon.getImage(), 500,50, this);
		
		
		// 1.) ImageIO: aus Datei
		try {
			File f = new File("./12 GUI/res/cartoon.jpg");			
			img = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, 350, 150, this);
		
		
		// 2.) ImageIO: aus URL
		try {
			// Proxy für FüUstgS
			SocketAddress pAddr = new InetSocketAddress("192.168.4.200", 3128);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, pAddr);
			// URL
			URL url = new URL("http://data.motor-talk.de/data/galleries/0/162/7209/38104823/na-toll-7923864596178008268.jpg");
			URLConnection conn = url.openConnection(proxy);
			// Bild lesen
			img = ImageIO.read(conn.getInputStream());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, this);
	}
}
