/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package einsortieren.meindatenbankclient.exceptions;

/**
 *
 * @author dborkowitz
 */
public class StillConnectedException extends Exception {

    public StillConnectedException() {
        super("Es besteht bereits eine Verbindung. Bitte die Verbindung vorher schließen!");
    }

}
