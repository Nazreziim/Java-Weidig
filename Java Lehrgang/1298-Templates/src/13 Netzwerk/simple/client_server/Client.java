package simple.client_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;



public class Client {
	Socket socket;
	OutputStream out;
	InputStream in;
	
	public void clientStart(){
		try {
			//Adresse des ITU-Servers erfragen
			//InetAddress adresse = InetAddress.getLocalHost();
			//Socket/ Verbindung erstellen: itu.it-training.fus
			socket = new Socket("10.0.26.13",7);
			//Timeout in ms
			//socket.setSoTimeout(5000);
			//Stream für Anfrage an Webserver
			OutputStream out = socket.getOutputStream();
			//Anfrage String
			String s = "Moin Moin\n";
			//Anfrage wird als Byte-Array an Server gesendet
			out.write(s.getBytes());
			//Stream für Antwort des Servers
			InputStream in = socket.getInputStream();
			//Byte-Buffer in dem die Antwort geschrieben wird
			byte[] b = new byte[4096];
			//Länge des empfangen Blocks
			int len;
			String erg ="";			
			//Solange wie Blocklänge nicht -1 ist(dann kommt nix mehr!)
			//Read blockiert solange, bis wieder Daten anstehen, oder -1 geliefert wird
			while((len = in.read(b))!= -1){
				//Schreibe die Blöcke auf die Konsole
				//System.out.write(b, 0,len);
				for(int i = 0; i<len; i++){
					erg += (char)b[i];
				}
			}
			System.out.println(erg);	
			out.close();
			in.close();
			socket.close();
			
		}catch (ConnectException e) {
			JOptionPane.showMessageDialog(null, "Es konnte keine Verbindung zum Server aufgebaut werden");
		}catch (InterruptedIOException e) {
			JOptionPane.showMessageDialog(null, "Zeit abgelaufen! Wiederhole Anfrage");
			this.clientStart();
		}
		catch (SocketException e) {
			JOptionPane.showMessageDialog(null, "Abbruch der Verbindung:\n" + e.getMessage());
		} 
		catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		(new Client()).clientStart();

	}

}
