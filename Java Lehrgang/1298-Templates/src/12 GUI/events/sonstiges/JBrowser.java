package events.sonstiges;

import javax.swing.*;
import javax.swing.event.*; 
import java.io.*; 
import java.net.*;  

public class JBrowser extends JEditorPane implements HyperlinkListener { 
	
	JBrowser( String url )   {     
		setEditable( false );     
		this.setContentType("text/html");
		addHyperlinkListener( this );   
		try     {       
			setPage( new URL(url) );    
			}     
		catch ( IOException e ) {
			e.printStackTrace();
		}   
	}    
	
	@Override 
	public void hyperlinkUpdate( HyperlinkEvent event )   {
		HyperlinkEvent.EventType typ = event.getEventType();   
		if ( typ == HyperlinkEvent.EventType.ACTIVATED ) {
			try       {       
				setPage( event.getURL() ); 
			}      
			catch( IOException e ) {  
				JOptionPane.showMessageDialog( this,
						"Kann dem Link nicht folgen: " + event.getURL().toExternalForm(),  
						"Ladefehler",      
						JOptionPane.ERROR_MESSAGE ); 
			}
		}  
	}    
	
	public static void main( String[] args )   { 
		JFrame f = new JFrame();
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
		f.setSize( 600, 500 ); 
		f.add( new JScrollPane(new JBrowser("http://www.w3.org")) ); 
		f.setVisible( true );  
	} 
}

