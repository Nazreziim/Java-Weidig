package components.tabbed_panel;

import java.awt.*;

import javax.swing.*;

public class TabbedPanelFrame extends JFrame {
	
	public TabbedPanelFrame(int x, int y){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(x,y);
                this.setLocation(1400, 20);

                JTabbedPane tab = new JTabbedPane(JTabbedPane.BOTTOM,JTabbedPane.SCROLL_TAB_LAYOUT);
                JPanel p1 = new JPanel();
                p1.setBackground(Color.red);
                tab.add(p1,"Panel1");

                JPanel p2 = new JPanel();
                p2.setBackground(Color.blue);
                tab.add(p2,"Panel2");

                JPanel p3 = new JPanel();
                p3.setBackground(Color.green);
                tab.add(p3,"Panel3");

                JPanel p4 = new JPanel();
                p4.setBackground(Color.black);
                tab.addTab("Panel4",new ImageIcon("bilder/trash.gif"),p4,"Panel 4 ist schwarz");



                
                this.add(tab);

		this.setVisible(true);
	}
	
	public static void main(String[] args){
		TabbedPanelFrame of = new TabbedPanelFrame(300,200);
               
	}
}