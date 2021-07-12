/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package observer.version3_eigene_nachbildung;

import java.util.ArrayList;

/**
 *
 * @author dborkowitz
 */
public class Observable{
    ArrayList<Observer> obs = new ArrayList<Observer>();

    public void addObserver(Observer ob){
        this.obs.add(ob);
    }


    public void removeObserver(Observer ob){
        this.obs.remove(ob);
    }

    public void updateAll(){
        for(Observer ob : this.obs){
            ob.update();
        }
    }
}
