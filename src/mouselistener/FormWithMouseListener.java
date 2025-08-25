package mouselistener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FormWithMouseListener {
	public static void main(String[] args) {
		JFrame f = new JFrame("UserForm");
		f.setLayout(new FlowLayout());
		f.setSize(400,150);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel l1 = new JLabel("UserName:");
		JTextField t1 = new JTextField(10);

		JLabel l2 = new JLabel("Password:");		
		JPasswordField t2 = new JPasswordField(10);
		
		JButton b1 = new JButton("Submit");
		JButton b2 = new JButton("Cancel");
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == b1) {
				JOptionPane.showMessageDialog(f, "Submitted Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
				String username = t1.getText();
				String password = new String(t2.getPassword());
				System.out.println("Username: " + username);
				System.out.println("Password: " + password);
				}else if(e.getSource() == b2) {
					JOptionPane.showMessageDialog(f, "Cancelled", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		};
		
		b1.addActionListener(al);
		b2.addActionListener(al);
		
		
		//MouseListener
		MouseListener ml  = new MouseListener() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				e.getComponent().setBackground(java.awt.Color.YELLOW);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
                e.getComponent().setBackground(java.awt.Color.RED);	
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				e.getComponent().setBackground(java.awt.Color.GREEN);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(java.awt.Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(java.awt.Color.WHITE);
				
			}
		};
		b1.addMouseListener(ml);
		b2.addMouseListener(ml);
		
		
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(b2);
		f.add(b1);
		f.setVisible(true);
		
		
	}

}
