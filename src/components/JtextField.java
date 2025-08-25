package components;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JtextField {
	public static void main(String[] args) {
		JFrame f = new JFrame("TextFeild example");
		
		f.setLayout(null);
		JLabel l1 = new JLabel("Q1.what is Swing?");
		l1.setBounds(10, 10, 200, 30);
		JLabel l2 = new JLabel("Q2.what are use case of swing?");
		l2.setBounds(10, 60, 200, 25);
	
		JTextField textField= new JTextField();
		textField.setBounds(10,40,200, 25);
		JTextField textField2= new JTextField();
		textField2.setBounds(10,80,200, 25);
		
		JButton b1 = new JButton("Cancel");
		JButton b2 = new JButton("Submit");
		
		b1.setBounds(10, 120, 100, 25);
		b2.setBounds(125,120,100,25);
		
		b1.addActionListener(e ->{
			textField.setText("");
			textField2.setText("");
			JOptionPane.showMessageDialog(b1, "Cancelled");
		});
		
		b2.addActionListener(e ->{
			String ans1 = textField.getText();
			String ans2 = textField2.getText();
		
			 JOptionPane.showMessageDialog(f,"Answer 1:"+ans1+"/nAnswer 2:"+ans2,"Submission Result",JOptionPane.INFORMATION_MESSAGE);
			 System.out.println(ans1);
		});
		
		f.add(l1);
		f.add(textField);
		f.add(l2);
		f.add(textField2);
		f.add(b1);
		f.add(b2);
		f.setSize(250, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		

	}

}
