package demo;

import java.awt.FlowLayout;

import javax.swing.*;

public class HelloWorld {
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Message");
		frame.setVisible(true);
		frame.setSize(400, 300);
		JLabel label = new JLabel("Hello, World!");
		frame.setLayout(new FlowLayout());
		frame.add(label);
	}

}
