package layoutmanagers;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayout {
	public static void main(String[] args) {
		JFrame f = new JFrame("Grid Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 200);
		
		f.setLayout(new java.awt.GridLayout(4, 3,10,10));
		
		for(int i=1;i<=9;i++)
		{
			f.add(new JButton(String.valueOf(i)));
		}
		f.add(new JButton("*"));
		f.add(new JButton("0"));
		f.add(new JButton("#"));

		f.setVisible(true);

	}

}
