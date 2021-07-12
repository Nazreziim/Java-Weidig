package infotool.simple;



/**
* Der Controller des InfoTools. Der InfoController interpretiert die Nutzeraktionen, 
* die durch die View erkannt wurden. Damit diese möglich ist gibt es zwei Phasen:
* <ol>
* <li>
*    Zum Start registriert sich der InfoController mittels addUserGestureListener 
*    bei der InfoView. 
* </li>
* <li>
*    Nun wird bei jeder Nutzeraktion der InfoController durch die InfoView informiert. 
*    Je nach Aktion des Nutzer werden die Callback – Funktionen des InfoController 
*    von der View aufgerufen.
* </li>
* </ol>
* Der Controller reagiert auf die Aufrufe der View wie folgt:
* <ol>
* <li>
*   Kleiner Kreislauf: Aufruf der showDisplay(String display) um die View darüber zu informieren, 
*   welches Display angezeigt werden sollen. 
* </li>
* <li>
*   Großer Kreislauf: Aufruf der Zustandsverändernden  Methoden von InfoModel, 
*   damit dieses die gekapselten internen Attribute verändert.
* </li>
* </ol>

 * @author dborkowitz
 * @version 1.0 @created 15-Feb-2013 11:39:41
 */
public class InfoController {

    private InfoView view;
    private InfoModel model;

    public InfoController(InfoModel model, InfoView view) {
        this.model = model;
        this.view = view;
        //Die View könnte null sein, dies ist aber ein Programmierfehler. Deshalb
        //könnte diese Prüfung auch weg bleiben und eine Nullpointer - Exception
        //provoziert werden.
        if (this.view != null) {
            this.view.addUserGestureListener(this);
        }
        else{
            System.err.println("Fehler! Keine View zum Controller zugeordnet");
        }
    }

    /**
     * Destruktor des Controller. Dieser sorgt dafür, dass sich der Controll bei der
     * View abmeldet, sobald das Objekt vernichtet wird.
     * @throws Throwable 
     */
    @Override
    protected void finalize() throws Throwable {
        if (this.view != null) {
            this.view.removeUserGestureListener(this);
        } 
        else{
            System.err.println("Fehler! Keine View zum Controller zugeordnet");
        }
        super.finalize();
    }

    /**
     * Handler der die Nutzeraktion Get Message verarbeitet. Diese wird von der 
     * View aufgerufen und sorgt dafür, dass die View ihr Display umschaltet.
     */
    public void processGetMessage() {
        if (this.view != null) {
            this.view.showDisplay("MESSAGE");
        }
         else{
            System.err.println("Fehler! Keine View zum Controller zugeordnet");
        }
    }
    /**
     * Handler der die Nutzeraktion Get Weather verarbeitet. Diese wird von der 
     * View aufgerufen und sorgt dafür, dass die View ihr Display umschaltet.
     */
    public void processGetWeather() {
        if (this.view != null) {
            this.view.showDisplay("WEATHER");
        }
        else{
            System.err.println("Fehler! Keine View zum Controller zugeordnet");
        }
    }

    /**
     * Handler der die Nutzeraktion Message Update verarbeitet. Diese wird von der 
     * View aufgerufen und sorgt dafür, dass sich der Zustand des InfoModels verändert
     * in dem es die setMessage aufruft.
     * @param msg Neuer Wert für das message - Attribut des InfoModels
     */
    public void processMsgUpdate(String msg) {
        if (this.model != null) {
            this.model.setMessage(msg);
        }
        else{
            System.err.println("Fehler! Kein Modell zum Controller zugeordnet");
        }
    }
    /**
     * Handler der die Nutzeraktion Weather Update verarbeitet. Diese wird von der 
     * View aufgerufen und sorgt dafür, dass sich der Zustand des InfoModels verändert
     * in dem es die setWeather aufruft.
     * @param wth Neuer Wert für das weather - Attribut des InfoModels
     */
    public void processWthUpdate(String wth) {
        if (this.model != null) {
            this.model.setWeather(wth);
        }
        else{
            System.err.println("Fehler! Kein Modell zum Controller zugeordnet");
        }
    }
}//end InfoController