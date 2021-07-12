package components.dialoge.dialog2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OwnDialog extends JDialog {
	private JTextField name;
	private JTextField vorname;
	private JComboBox anrede;
	public boolean ok = false;  // zur not auch private mit getter und setter ;-)
	
	public OwnDialog(JFrame owner){
		super(owner,"Namenabfrage");
		this.setLayout(new GridLayout(0, 2));

		JLabel nameL = new JLabel("Name:");
		nameL.setHorizontalAlignment(JLabel.CENTER);
		this.add(nameL);

		// Erstellen eines Textfeldes mit 20 Zeichen
		name = new JTextField( "", 20);		
		this.add(name);
		
		JLabel vornameL = new JLabel("Vorname:");
		vornameL.setHorizontalAlignment(JLabel.CENTER);
		this.add(vornameL);
		
		vorname = new JTextField( "", 20);		
		this.add(vorname);
		
		JLabel anredeL = new JLabel("Anrede:");
		anredeL.setHorizontalAlignment(JLabel.CENTER);
		this.add(anredeL);

		anrede = new JComboBox();
		anrede.addItem("Herr");
		anrede.addItem("Frau");
		this.add(anrede);
		
		ActionListener a = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("OK")){
					ok = true;
				}
				else{
					ok = false;
				}
				setVisible(false);
			}
			
		};
		
		JButton ok = new JButton("OK");
		ok.addActionListener(a);
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(a);
		
		this.add(ok);
		this.add(cancel);
		
		this.pack();
	}

	public String getName() {
		return name.getText();
	}

	public String getVorname() {
		return vorname.getText();
	}

	public String getAnrede() {
		return anrede.getSelectedItem().toString();
	}
}
