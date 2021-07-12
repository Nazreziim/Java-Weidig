/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotool.observer;

/**
 *Interface für alle Klassen, die ein Subjekt beobachten wollen.
 * @author dborkowitz
 */
public interface Observer {
    
      /**
     * Methode zu Benachrichtigung über Zustandsänderungen des InfoModels. Diese
     * wird jedes mal vom InfoModel, bei dem sich der Observer registriert hat, aufgerufen,
     * sobald sich der Zustand ändert.
     * @param event - Informationsobjekt über das der Aufrufer zusätzliche Informationen
     * an den Observer übergeben kann. 
     */
   public void processChange(Object event); 
}
