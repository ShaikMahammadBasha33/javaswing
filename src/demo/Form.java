package demo;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Form {
	public static void main(String[] args) {
		JFrame f = new JFrame("UserForm");
		f.setLayout(new FlowLayout());
		f.setSize(200,150);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel l1 = new JLabel("UserName:");
		JTextField t1 = new JTextField(10);

		JLabel l2 = new JLabel("Password:");		
		JPasswordField t2 = new JPasswordField(10);
		
		JButton b = new JButton("Submit");
		
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(b);
		f.setVisible(true);
		
		
	}

}
