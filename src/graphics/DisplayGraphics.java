package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayGraphics extends JPanel {
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		
		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.drawString("Hello, Graphics!", 20, 20);
		
		g.setColor(java.awt.Color.BLUE);
		g.fillRect(50, 50, 100, 100);
		g.drawRect(50, 50, 100, 100);

		
		
		g.setColor(java.awt.Color.RED);
		g.fillOval(200, 50, 100, 100);
		g.drawOval(200, 50, 100, 100);
		
		g.setColor(java.awt.Color.MAGENTA);
		g.drawLine(50, 200, 150, 300);
		
		

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Graphics Demo");
		DisplayGraphics graphics = new DisplayGraphics();
		frame.add(graphics);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	


}
