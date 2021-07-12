/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotool.observer;

import java.util.ArrayList;
/**
 * Subject ist eine Klasse deren Objekte von Observern überwaht werden können.
 * Es stellt Methoden zur Verwaltung von Observern bereit. 
 * Observer sind Objekte, die an den Änderungen des Zustandes interessiert sind. 
 * Diese können sich beim Subject anmelden. Jedes Mal, wenn die fireModelChangeEvent 
 * aufgerufen wird, werden die angemeldeten Observer informiert. Die Observer können sich 
 * auch vom Subject wieder abmelden, sobald sie nicht mehr an den Zustandsänderungen 
 * interessiert sind.
*/
public class Subject {
     private ArrayList<Observer> observer;
     public Subject(){
          this.observer = new ArrayList<>();
     }
     /**
     * Methode zum Anmelden von Observern.
     * @param obs Observer der an Zustandsänderung interessiert ist.
     */
    public void addModelChangeListener(Observer obs) {
        this.observer.add(obs);
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
        for(Observer obs : this.observer){
            obs.processChange(o);
        }
    }
    /**
     * Methode zum Abmelden von Observern.
     * @param obs Observer der nicht mehr an Zustandsänderung interessiert ist.
     */
    public void removeModelChangeListener(Observer obs) {
        this.observer.remove(obs);
    }
    
}
