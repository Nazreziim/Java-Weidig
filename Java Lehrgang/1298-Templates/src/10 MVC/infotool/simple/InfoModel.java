package infotool.simple;

import java.util.ArrayList;

/**
 * Modell des Infotools. 
 * Es kapselt die Daten der Anwendung und verhindern den Direktzugriff.
 * Es stellt Methoden zum Abfragen des internen Zustandes (diese werden von der 
 * View aufgerufen) bereit. Es stellt Methoden zum Verändern des internen Zustands 
 * zur Verfügung. Diese Methoden werden durch den Controller aufgerufen.
 * Das InfoModel stellt des Weiteren Methoden zur Verwaltung von Listenern bereit. 
 * Listener sind Objekte, die an den Änderungen des Zustandes interessiert sind. 
 * Diese können sich beim Model anmelden. Jedes Mal, wenn sich der Zustand ändert 
 * werden die angemeldeten Listener darüber informiert. Die Listener können sich 
 * auch vom Model abmelden, sobald sie nicht mehr an den Zustandsänderungen 
 * interessiert sind.

 * @version 1.0 @created 15-Feb-2013 11:39:42
 */
public class InfoModel {

    private String message;
    private String weather;
    private ArrayList<InfoView> listeners;

    public InfoModel() {
        this.message = "Hallo";
        this.weather = "Sonnig";
        this.listeners = new ArrayList<>();
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
    
    /**
     * Methode zum Anmelden von Listenern.
     * @param view Listener der an Zustandsänderung interessiert ist.
     */
    public void addModelChangeListener(InfoView view) {
        this.listeners.add(view);
    }
    
    /**
     * Methode zum informieren aller Listener, dass sich der Zustand des Modells
     * verändert hat. Dies geschieht durch Aufruf der Methode processModelChange 
     * aller Listener. Die Methode wird von allen zustandsverändernten Methoden als letztes
     * aufgerufen.
     * @param o - Zusätzliches Informationsobjekt, welches an die Listener mit übermittelt
     * wird. Zum Beispiel könnte es als String das Attribut beinhalten, was sich verändert hat.
     * Dies könnte den unnötigen Aufruf von Gettern reduzieren.
     */
    protected void fireModelChangeEvent(Object o) {
        for(InfoView v : this.listeners){
            v.processModelChange(o);
        }
    }
    /**
     * Methode zum Abmelden von Listenern.
     * @param view Listener der nicht mehr an Zustandsänderung interessiert ist.
     */
    public void removeModelChangeListener(InfoView view) {
        this.listeners.remove(view);
    }
}//end InfoModel