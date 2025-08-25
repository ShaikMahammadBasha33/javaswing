package layoutmanagers;

import java.awt.*;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutExample {
	public static void main(String[] args) {
		JFrame f = new JFrame("FlowLayout Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 200);

		for(int i=0;i<=9;i++)
		{
			f.add(new JButton(String.valueOf(i)));
		}
		//It arranges components in a row, one after another,
		//like words in a paragraph.
		//JPanal uses Flow layout by default
		f.setLayout(new FlowLayout(FlowLayout.LEFT,55,10));
		f.setVisible(true);
	}

}
