package components;

import java.awt.Color;

import javax.swing.*;

public class JtextArea {
	public static void main(String[] args) {
		JFrame f = new JFrame("text area example");
		
		JTextArea a = new JTextArea(10,20);
		a.setBounds(10, 10, 100, 100);
		a.setBackground(Color.LIGHT_GRAY);
		
		JScrollPane scroll = new JScrollPane(a);
		scroll.setBounds(10, 10, 200, 150);
		
		
		f.setLayout(null);
//		f.add(a); //no need to add a testArea to the frame because testArea is inside the scrollpane 
		f.add(scroll);
		f.setSize(250,250);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
