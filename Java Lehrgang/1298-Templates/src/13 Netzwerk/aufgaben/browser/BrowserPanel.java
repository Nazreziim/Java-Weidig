package aufgaben.browser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


	public class BrowserPanel extends JEditorPane implements HyperlinkListener {
		
		public BrowserPanel(String url) {
			setEditable(false);			
			addHyperlinkListener(this);// Den Event-Listener registrieren
			setHTMLContent(url);

		}

		/**
		 * Hilfsmethode zum Lesen von HTML-Content aus einer URL. Nutzt den Proxy der FüUstgS
		 * 
		 * @param url - Als String übergebene URL
		 */
		private void setHTMLContent(String url) {
			// Proxy für FüUstgS
			SocketAddress pAddr = new InetSocketAddress("192.168.4.200", 3128);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, pAddr);

			try {
				// Für das Setzen des Editor-Inhaltes wird das im Programmaufruf
				// übergeben URL-Objekt zugewiesen

//				URLConnection conn = new URL(url).openConnection(proxy);
				URLConnection conn = new URL(url).openConnection();
				this.setText("");
				this.setContentType("text/html");
				
				// Variante 1: Buffered Reader
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuffer readString = new StringBuffer();
				String buffStr = "";
				while ((buffStr = br.readLine()) != null) {
					readString.append(buffStr);
				}
				
				// Variante 2: BufferedInputStream
//				BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
//				byte[] buffer = new byte[1024];
//				int count = 0;
//				while ((count = bis.read(buffer)) != -1) {
//					for (int i = 0; i < count; i++) {
//						readString += (char) buffer[i];
//					}
//				}
//				bis.close();

				
				
				this.setText(readString.toString());
				this.repaint();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		/** 
		 * Die Methode des HyperlinkListener implementieren
		 * 
		 * @param Das ausgelöste Event
		 */
		public void hyperlinkUpdate(HyperlinkEvent event) {
			if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
				System.out.println(event);
				System.out.println(event.getURL());
				if (event.getURL() != null) {
					this.setHTMLContent(event.getURL().toExternalForm());
				}
			}
			
//			// Eine Instanz der Klasse Console für Ausgaben am Bildschirm
//			// erzeugen
//			Console konsole = System.console();
//			// Wurde ein Hyperlink aktiviert,
//			HyperlinkEvent.EventType typ = event.getEventType();
//			if (typ == HyperlinkEvent.EventType.ACTIVATED) {
//				// soll für das Setzen des Editor-Inhaltes ein URL-Objekt
//				// zugewiesen werden
//				setHTMLContent(event.getURL().toString());
//				//setPage(event.getURL());
//				konsole.printf("URL: %s%n", event.getURL());
//				konsole.printf("Hyperlink: %s%n", event.getURL()
//						.toExternalForm());
//			}
		}
	}