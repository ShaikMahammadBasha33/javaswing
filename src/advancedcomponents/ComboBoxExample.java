package advancedcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxExample {
	public static void main(String[] args) {
		JFrame f = new JFrame("ComboBox Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 250);
		f.setLayout(null);
		JLabel l = new JLabel();
		l.setBounds(50, 150, 200, 20);
		String[] languages = {"java","python","c","c++"};
		
		
		JComboBox<String> combo = new JComboBox<String>(languages);
		combo.setBounds(50, 50, 150, 20);
		JButton b = new JButton("show the selected item");
		b.setBounds(50, 100, 200, 20);
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String data = "language selected is :"+combo.getItemAt(combo.getSelectedIndex());
				l.setText(data);
				System.out.println(data);
				
			}
		});
//		combo.addItemListener(e -> {
//		    if (e.getStateChange() == ItemEvent.SELECTED) {
//		        System.out.println("Now selected: " + e.getItem());
//		    }
//		});
		
		f.add(combo);
		f.add(b);
		f.add(l);
		
		f.setVisible(true);
	}

}
