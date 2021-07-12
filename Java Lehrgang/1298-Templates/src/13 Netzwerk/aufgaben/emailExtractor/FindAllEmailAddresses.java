package aufgaben.emailExtractor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAllEmailAddresses {
	public static void main(String[] args) {
		printAllEMailAddresses("https://www.galileo-press.de/impressum/");
	}

	static void printAllEMailAddresses(String urlString) {
		try {
			// Proxy für FüUstgS
			SocketAddress pAddr = new InetSocketAddress("192.168.4.200", 3128);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, pAddr);

			URL url = new URL(urlString);
			Scanner scanner = new Scanner(url.openConnection(proxy).getInputStream()); //url.openStream());
			Pattern pattern = Pattern
					.compile("[\\w|-]+@[\\w|-]+\\.[a-z|A-Z]{2,3}"); //"[\\w|-]+@\\w[\\w|-]*\\.[a-z]{2,3}");

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				for (Matcher m = pattern.matcher(line); m.find();)
					System.out.println(line.substring(m.start(), m.end()));
			}
		} catch (MalformedURLException e) {
			System.err.println("URL ist falsch aufgebaut!");
		} catch (IOException e) {
			System.err.println("URL konnte nicht geöffnet werden!");
		}
	}
}