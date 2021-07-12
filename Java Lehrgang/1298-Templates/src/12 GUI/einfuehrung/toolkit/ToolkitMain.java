package einfuehrung.toolkit;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 *
 * @author LGerhard
 */
public class ToolkitMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        
        // 1.) Bildschirmgröße
        Dimension d = tk.getScreenSize();
        System.out.println(d);
        
        // 2.) Beep
        for(int i=0; i<50; i++){
			Toolkit.getDefaultToolkit().beep();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        
        // 3.) Clipboard
        Clipboard cb = tk.getSystemClipboard();
        Transferable t = cb.getContents(tk);
        String s;
        try {
            if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                s = (String) (t.getTransferData(DataFlavor.stringFlavor));
                System.out.println(s);
            }
        } catch (Exception ee) {
        }
        cb.setContents(new StringSelection("Hello World"), null);        
    }
}
