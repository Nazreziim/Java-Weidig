package events.sonstiges;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JFrame;

public class SoundWiedergabeFrame extends JFrame {
	
	public SoundWiedergabeFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		File f = new File( "./12 GUI/res/tick.wav" ); 
		
		while (true) {
		AudioClip sound;
		try {
			sound = Applet.newAudioClip( f.toURI().toURL() );
			sound.play(); 
		} catch (MalformedURLException e1) {

			e1.printStackTrace();
		} 
		try {
			Thread.sleep( 100 );
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	}
	
	public static void main(String[] args) {
		new SoundWiedergabeFrame();

	}

}
