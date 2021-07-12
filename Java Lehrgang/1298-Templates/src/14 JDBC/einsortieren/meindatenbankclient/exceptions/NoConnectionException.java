/*
 * Diese Exception wird geworfen, wenn Abfrage an Datenbanken gesendet werden, obwohl keine Verbindung besteht.
 */

package einsortieren.meindatenbankclient.exceptions;

/**
 *
 * @author dborkowitz
 */
public class NoConnectionException extends Exception{

    public NoConnectionException() {
        super("Es besteht keine Verbindung!");
    }

}
