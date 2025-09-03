package graphics;

import java.awt.*;
import javax.swing.*;

public class ImageGraphicsExample extends JPanel {
    private Image image;

    public ImageGraphicsExample() {
        // Load image from local path
       image = new ImageIcon("C:\\Users\\shaikmahammad_basha\\Pictures\\Saved Pictures\\R (2).jpg").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set background color
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        // Draw the image at (100, 100) with width=300, height=200
        g.drawImage(image, 100, 100, 300, 200, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Graphics Example");
        ImageGraphicsExample panel = new ImageGraphicsExample();
        frame.add(panel);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}