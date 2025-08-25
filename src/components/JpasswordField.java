package components;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JpasswordField {
	public static void main(String[] args) {
		JFrame f = new JFrame("password example");
		
		JLabel l1 = new JLabel("username:");
		l1.setBounds(10, 10, 100, 20);
		JTextField t1 = new JTextField();
		t1.setBounds(100, 10, 100, 20);
		
		JLabel l2 = new JLabel("Password:");
		l2.setBounds(10, 40, 100, 20);
		JPasswordField p1 = new JPasswordField();
		p1.setBounds(100, 45, 100, 20);
		
		
		f.setLayout(null);
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(p1);
		f.setSize(400, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
