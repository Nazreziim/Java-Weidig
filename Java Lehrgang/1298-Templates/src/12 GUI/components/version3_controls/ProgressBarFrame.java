package components.version3_controls;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

public class ProgressBarFrame extends JFrame {
	/**
	 * Scrollbares Panel mit mehr Komponenten als Darstellbar soll hier scrollbar gemacht werden.
	 */
	public JProgressBar progress; 
	public ProgressBarFrame(){
		//Hier setzt man die Höhe/Breite die tatsächlich zur Verfügung steht
		
		this.setSize(600,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		progress = new JProgressBar(0,100);
		
		this.add(progress,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		ProgressBarFrame of = new ProgressBarFrame();
		for(int i = 0; i <= 100; i++){
			of.progress.setValue(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}