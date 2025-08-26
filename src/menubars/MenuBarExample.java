package menubars;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarExample {
	public static void main(String[] args) {
		JFrame f = new JFrame("Menu bars example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 400);
		
		JMenuBar menuBar = new JMenuBar();
		
		
		JMenu fileMenu = new JMenu("FILE");
		JMenu editMenu = new JMenu("EDIT");
		JMenu helpMenu = new JMenu("HELP");
		
		
		
		
		JMenuItem newItem = new JMenuItem("new");
		JMenuItem openItem = new JMenuItem("open");
		JMenuItem saveItem = new JMenuItem("save");
		JMenuItem exitItem = new JMenuItem("exit");
		
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		
		JMenuItem cutItem = new JMenuItem("cut");
		JMenuItem copyItem = new JMenuItem("copy");
		JMenuItem pasteItem = new JMenuItem("paste");
		
		editMenu.add(cutItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		
		
		JMenuItem about = new JMenuItem("about");
		
		helpMenu.add(about);
		
		



		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		f.setJMenuBar(menuBar);
		
		f.setVisible(true);
	}

}
