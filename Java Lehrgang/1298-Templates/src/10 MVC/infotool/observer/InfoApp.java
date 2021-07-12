package infotool.observer;

/**
 * @author dborkowitz
 * @version 1.0 @created 15-Feb-2013 11:39:40
 */
public class InfoApp {
    
    public static void main(String args[]) {

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            InfoModel m = new InfoModel();
            InfoView v1 = new InfoView(m);
            InfoController c1 = new InfoController(m, v1);
            InfoView v2 = new InfoView(m);
            InfoController c2 = new InfoController(m, v2);

            public void run() {
                v1.setVisible(true);
                v2.setVisible(true);
            }
        });
    }
}//end InfoApp
