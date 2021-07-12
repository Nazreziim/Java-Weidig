package infotool.observer;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * View des Infotools. Es stellt den Zustand des InfoModels visuell dar. 
 * Die InfoView holt sich die Informationen aus dem InfoModel 
 * über die Zustandsabfrage – Methoden (getter). Das geschieht einmal zum Beginn 
 * des Programmes, wenn sich die InfoView beim InfoModel mittels 
 * addModelChange-Listeners registriert. Jedes Mal, wenn das InfoModel seinen 
 * Zustand ändert und die fireModelChangeEvent aufruft, wird die InfoView darüber 
 * informiert. Sie holt dann den neuen Zustand des InfoModels und stellt ihn aktualisiert 
 * dar. 
 * Das InfoModel informiert die InfoView in dem sie die Methode processModelChange(Object event) 
 * aufruft.
 * Des Weiteren behandelt sie die Anforderung des Controllers, das Display zu wechseln.
 * Die InfoView nimmt die Nutzereingaben entgegen und leitet diese an den InfoController 
 * weiter, der sie dann interpretiert. Deshalb muss dieser bei jeder Eingabe informiert 
 * werden. In gewissen Situationen kann es sogar mehrere Objekte geben, die an den 
 * Nutzeraktionen interessiert sind. Aus diesem Grund gibt es im View einen 
 * Mechanismus, mit dem sich diese Interessenten bei der View registrieren können. 
 * Jedes Mal wenn eine Nutzeraktion durchgeführt wird, werden alle registrierten 
 * Interessenten informiert. Diese Interessenten können sich natürlich auch wieder
 * abmelden.

 * @author dborkowitz
 * @version 1.0 @created 15-Feb-2013 11:39:43
 */
public class InfoView extends JFrame implements Observer{

    private ActionListener msgUpdateHandler;
    private ActionListener msgGetHandler;
    private ActionListener wthUpdateHandler;
    private ActionListener wthGetHandler;
    private ArrayList<InfoController> listeners;
    private InfoModel model;
    private CardLayout layout;

    public InfoView(InfoModel model) {
        this.model = model;
        //Modell könnte null sein, dies ist aber ein Programmierfehler. Deshalb
        //könnte diese Prüfung auch weg bleiben und eine Nullpointer - Exception
        //provoziert werden.
        if (this.model != null) {
            //Schon beim Erzeugen der View meldet sie sich beim Modell als Listener
            //an.
            this.model.addModelChangeListener(this);
        } 
        else{
            System.err.println("Fehler! Kein Modell zur View zugeordnet");
        }
        this.listeners = new ArrayList<>();

        this.msgGetHandler = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getMessageButtonActionPerformed(e);
            }
        };
        this.msgUpdateHandler = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateMessageButtonActionPerformed(e);
            }
        };
        this.wthGetHandler = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getWeatherButtonActionPerformed(e);
            }
        };
        this.wthUpdateHandler = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateWeatherButtonActionPerformed(e);
            }
        };
        this.buildDisplay();
        //Initialisierung der View mit dem aktuellen Zustand des InfoModels
        refresh();
    }
    /**
     * Destruktor der View. Dieser sorgt dafür, dass sich die View beim Modell abmeldet,
     * sobald das Objekt vernichtet wird.
     * @throws Throwable 
     */
    @Override
    protected void finalize() throws Throwable {
        if (this.model != null) {
            this.model.removeModelChangeListener(this);
        } 
        else{
            System.err.println("Fehler! Keine View zum Controller zugeordnet");
        }
        super.finalize();
    }
    /**
     * Methode zu Benachrichtigung über Zustandsänderungen des InfoModels. Diese
     * wird jedes mal vom InfoModel, bei dem sich die View registriert hat, aufgerufen,
     * sobald sich der Zustand ändert.
     * @param event - Informationsobjekt über das der Aufrufer zusätzliche Informationen
     * an den Listener übergeben kann. Dies wird hier nicht weiter ausgewertet, könnte
     * aber zur Steuerung genutzt werden, damit nur das betroffene Textfeld aktualisiert
     * wird.
     */
    public void processChange(Object event) {
        this.refresh();
    }

    /**
     * Methode zur Aktualisierung der View. Sie holt sich den aktuellen Zustand
     * aus dem InfoModel und stellt ihn visuell dar.
     */
    private void refresh() {
        if (model != null) {
            this.messageText.setText(this.model.getMessage());
            this.weatherText.setText(this.model.getWeather());
        }
        else{
            System.err.println("Fehler! Kein Modell zur View zugeordnet");
        }
    }

    /**
     * Methode zum Anmelden von Listenern.
     * @param con Listener der an Nutzeraktionen interessiert ist.
     */
    public void addUserGestureListener(InfoController con) {
        this.listeners.add(con);
    }

    /**
     * Methode zum Abmelden von Listenern.
     * @param con Listener der nicht mehr an Nutzeraktionen interessiert ist.
     */
    void removeUserGestureListener(InfoController cont) {
        this.listeners.remove(cont);
    }

    /**
     * Methode zum Umschalten der View. Diese wird im kleinen Kreislauf von der Control
     * aufgerufen.
     * @param display - Das anzuzeigende Display (\"weather\" oder \"panel\")
     */
    public void showDisplay(String display) {
        if (display.equalsIgnoreCase("WEATHER")) {
            this.layout.show(this.getContentPane(), "weather");
        } else {
            this.layout.show(this.getContentPane(), "message");
        }
    }

    /**
     * Methode zum Aufbau der View.
     */
    private void buildDisplay() {
        messagePanel = new javax.swing.JPanel();
        getWeatherButton = new javax.swing.JButton();
        messageText = new javax.swing.JTextField();
        messageLabel = new javax.swing.JLabel();
        updateMessageButton = new javax.swing.JButton();
        weatherPanel = new javax.swing.JPanel();
        getMessageButton = new javax.swing.JButton();
        weatherText = new javax.swing.JTextField();
        weatherLabel = new javax.swing.JLabel();
        updateWeatherButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Info Client 1");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        layout = new java.awt.CardLayout();
        this.getContentPane().setLayout(layout);

        getWeatherButton.setText("Get Weather");
        getWeatherButton.addActionListener(this.wthGetHandler);

        messageText.setText("Newest Story!");

        messageLabel.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setText("Message Display");

        updateMessageButton.setText("Update Message");
        updateMessageButton.addActionListener(this.msgUpdateHandler);

        javax.swing.GroupLayout messagePanelLayout = new javax.swing.GroupLayout(messagePanel);
        messagePanel.setLayout(messagePanelLayout);
        messagePanelLayout.setHorizontalGroup(
                messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(messagePanelLayout.createSequentialGroup().addContainerGap().addGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(messagePanelLayout.createSequentialGroup().addComponent(getWeatherButton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(messageText, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(updateMessageButton)).addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap(15, Short.MAX_VALUE)));

        messagePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{getWeatherButton, updateMessageButton});

        messagePanelLayout.setVerticalGroup(
                messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(messagePanelLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(messageLabel).addGap(18, 18, 18).addGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(messageText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(getWeatherButton).addComponent(updateMessageButton)).addGap(47, 47, 47)));

        this.getContentPane().add(messagePanel, "message");

        getMessageButton.setText("Get Message");
        getMessageButton.addActionListener(this.msgGetHandler);

        weatherText.setText("It's sunny");

        weatherLabel.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        weatherLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weatherLabel.setText("Weather Display");

        updateWeatherButton.setText("Update Weather");
        updateWeatherButton.addActionListener(this.wthUpdateHandler);

        javax.swing.GroupLayout weatherPanelLayout = new javax.swing.GroupLayout(weatherPanel);
        weatherPanel.setLayout(weatherPanelLayout);
        weatherPanelLayout.setHorizontalGroup(
                weatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(weatherPanelLayout.createSequentialGroup().addContainerGap().addGroup(weatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(weatherPanelLayout.createSequentialGroup().addComponent(getMessageButton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(weatherText, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(updateWeatherButton)).addComponent(weatherLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap(15, Short.MAX_VALUE)));

        weatherPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{getMessageButton, updateWeatherButton});

        weatherPanelLayout.setVerticalGroup(
                weatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(weatherPanelLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(weatherLabel).addGap(18, 18, 18).addGroup(weatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(weatherText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(getMessageButton).addComponent(updateWeatherButton)).addGap(47, 47, 47)));

        this.getContentPane().add(weatherPanel, "weather");

        pack();
    }

    /**
     * ActionHandler Methode für den "Get Weather Button". Sie informiert alle
     * angemeldeten Controller über die Nutzeraktion.
     * @param evt 
     */
    private void getWeatherButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for (InfoController c : this.listeners) {
            c.processGetWeather();
        }
    }
/**
     * ActionHandler Methode für den "Get Message Button". Sie informiert alle
     * angemeldeten Controller über die Nutzeraktion.
     * @param evt 
     */
    private void getMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for (InfoController c : this.listeners) {
            c.processGetMessage();
        }
    }
    /**
     * ActionHandler Methode für den "Update Weather Button". Sie informiert alle
     * angemeldeten Controller über die Nutzeraktion.
     * @param evt 
     */
    private void updateWeatherButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for (InfoController c : this.listeners) {
            c.processWthUpdate(this.weatherText.getText());
        }
    }
    /**
     * ActionHandler Methode für den "Update Message Button". Sie informiert alle
     * angemeldeten Controller über die Nutzeraktion.
     * @param evt 
     */
    private void updateMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for (InfoController c : this.listeners) {
            c.processMsgUpdate(this.messageText.getText());
        }
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton getMessageButton;
    private javax.swing.JButton getWeatherButton;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JTextField messageText;
    private javax.swing.JButton updateMessageButton;
    private javax.swing.JButton updateWeatherButton;
    private javax.swing.JLabel weatherLabel;
    private javax.swing.JPanel weatherPanel;
    private javax.swing.JTextField weatherText;
    // End of variables declaration                   
}
