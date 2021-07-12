package infotool.observer;

import java.util.ArrayList;

/**
 * Modell des Infotools. 
 * Es kapselt die Daten der Anwendung und verhindern den Direktzugriff.
 * Es stellt Methoden zum Abfragen des internen Zustandes (diese werden von der 
 * View aufgerufen) bereit. Es stellt Methoden zum Verändern des internen Zustands 
 * zur Verfügung. Diese Methoden werden durch den Controller aufgerufen.
 * 

 * @version 1.0 @created 15-Feb-2013 11:39:42
 */
public class InfoModel extends Subject{

    private String message;
    private String weather;
   

    public InfoModel() {
        this.message = "Hallo";
        this.weather = "Sonnig";
    }

    
    public String getMessage() {
        return this.message;
    }

    public String getWeather() {
        return this.weather;
    }

    /**
     * Zustandsverändernde Methode die den Inhalt des Attributs message ändert. 
     * Alle Listener werden über die Änderung informiert.
     * @param msg 
     */
    public void setMessage(String msg) {
        this.message = msg;
        this.fireModelChangeEvent(msg);
    }
   
    /**
     * Zustandsverändernde Methode die den Inhalt des Attributs weather ändert. 
     * Alle Listener werden über die Änderung informiert.
     * @param msg 
     */
    public void setWeather(String wth) {
        this.weather = wth;
        this.fireModelChangeEvent(wth);
    }
    
    
}//end InfoModel