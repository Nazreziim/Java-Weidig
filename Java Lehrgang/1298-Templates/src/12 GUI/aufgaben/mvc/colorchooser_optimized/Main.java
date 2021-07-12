package aufgaben.mvc.colorchooser_optimized;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dborkowitz
 */
public class Main {

    public static void main(String[] args) {

        Model m = new Model();
        IControl c = new Control(m);
        IView konsole = new ViewKonsole(m, c);
        ViewFrame f = new ViewFrame(m, c, "Das Fenster zur Welt");
        f.setVisible(true);



    }
}
