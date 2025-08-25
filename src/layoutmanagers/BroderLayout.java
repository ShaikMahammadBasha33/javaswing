package layoutmanagers;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BroderLayout {
	public static void main(String[] args) {
		JFrame f = new JFrame("BroderLayout");
		JLabel l1 = new JLabel();
		JButton a1 = new JButton("NORTH");
		JButton a2 = new JButton("SOUTH");
		JButton a3 = new JButton("EAST");
		JButton a4 = new JButton("WEST");
		JButton a5 = new JButton("CENTRE");
		

//		f.setLayout(new BorderLayout(20,15));
	    f.add(a1, BorderLayout.NORTH);
	    f.add(a2, BorderLayout.SOUTH);  
	    f.add(a3,BorderLayout.EAST);
	    f.add(a4,BorderLayout.WEST);
	    f.add(a5,BorderLayout.CENTER);
	    f.setSize(500,500);
	    
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    
		JFrame f2 = new JFrame("Broder layout with Region");
		
		JButton b1 = new JButton("NORTH");
		JButton b2 = new JButton("SOUTH");
		JButton b3 = new JButton("EAST");
		JButton b4 = new JButton("WEST");
		JButton b5 = new JButton("CENTRE");
		
	    f2.setLayout(new BorderLayout(100,150));

	    f2.add(b1, BorderLayout.NORTH);
	    f2.add(b2, BorderLayout.SOUTH);  
	    f2.add(b3,BorderLayout.EAST);
	    f2.add(b4,BorderLayout.WEST);
	    f2.add(b5,BorderLayout.CENTER);		
		f2.setSize(500,500);
	    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setVisible(true);
		
		//if we dont specify region then in such a case, 
		//only the latest component added is shown in the frame
		
		JFrame f3 = new JFrame("Broder layout without specify Region");
		
		JButton c1 = new JButton("NORTH");
		JButton c2 = new JButton("SOUTH");
		JButton c3 = new JButton("EAST");
		JButton c4 = new JButton("WEST");
		JButton c5 = new JButton("CENTRE");
		
	    f3.setLayout(new BorderLayout(100,150));
	    f3.add(c1);
	    f3.add(c2 );  
	    f3.add(c3);
	    f3.add(c4);
	    f3.add(c5);		
		f3.setSize(500,500);
		f3.setVisible(true);
	    
	    
	}

}
