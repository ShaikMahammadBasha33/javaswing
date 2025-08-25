package components;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Jlabel {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Label Example");
		frame.setLayout(null); //by default it uses a broder layout so make it null when we have bounds

		
		
		JLabel l1 = new JLabel("name of the first Label");
		l1.setBounds(10, 10, 200,200);
		JLabel l2 = new JLabel("name of the second Label");
		l2.setBounds(10, 20, 300,300);
		
		
		
		frame.add(l1);
		frame.add(l2);
		
		
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
		
	}

}
