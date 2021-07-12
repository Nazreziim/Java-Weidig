package components.listen.list_version2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OwnFrame extends JFrame {

	public OwnFrame(int x, int y) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(10));

		final DefaultListModel listModel = new DefaultListModel();
		final JList list = new JList(listModel);
		list.setPreferredSize(new Dimension(100,200));
		JButton btn = new JButton("Remove");
		JTextField tf = new JTextField(20);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if (index == -1)
					return;
				listModel.remove(index);
			}
		});

		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = ((JTextField) e.getSource()).getText();
				listModel.addElement(text);
				((JTextField) e.getSource()).setText("");
			}
		});
		
		this.add(list);
		this.add(btn);
		this.add(tf);
		
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		OwnFrame of = new OwnFrame(300, 200);
	}
}