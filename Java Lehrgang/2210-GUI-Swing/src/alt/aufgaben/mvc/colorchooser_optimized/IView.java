/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package alt.aufgaben.mvc.colorchooser_optimized;

import java.util.Observer;

/**
 *
 * @author dborkowitz
 */
public interface IView extends Observer{
    public void display(String s);
}
