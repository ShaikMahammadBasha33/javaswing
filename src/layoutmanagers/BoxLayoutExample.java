package layoutmanagers;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxLayoutExample {
	public BoxLayoutExample() {
		JFrame f = new JFrame("BoxLayout Example");
		f.setSize(400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//BoxLayout must be applied on a container (like JPanel or f.getContentPane()), 
		//not directly on JFrame.
		f.setLayout(new BoxLayout(f.getContentPane(),BoxLayout.Y_AXIS));

		for(int i =1;i<=5;i++)
		{
			f.add(new JButton(String.valueOf(i)));
		}
		
		f.setVisible(true);		}
	
	public static void main(String[] args) {
		BoxLayoutExample a = new BoxLayoutExample();
		
	}

}
