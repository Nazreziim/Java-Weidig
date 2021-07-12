
package alt.aufgaben.mvc.mouse_events;

/**
 *
 * @author c-ix-03-08
 */
public class Main {
   public static void main(String[] args) {
      PunktModel model = new PunktModel();
      Control control = new Control(model);
      View v = new View(model, control);
      v.setVisible(true);
   }

}
