package advancedcomponents;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeExample {
	
	public JTreeExample() {
		JFrame f = new JFrame("Tree example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Programming languages");
		DefaultMutableTreeNode java = new DefaultMutableTreeNode("java");
		DefaultMutableTreeNode python = new DefaultMutableTreeNode("python");
		DefaultMutableTreeNode cpp = new DefaultMutableTreeNode("c++");
		
		root.add(java);
		root.add(python);
		root.add(cpp);
		
		java.add(new DefaultMutableTreeNode("java swing"));
		java.add(new DefaultMutableTreeNode("Springboot"));
		
		python.add(new DefaultMutableTreeNode("Django"));
		
		
		
		
		JTree t = new JTree(root);
		
		JScrollPane p = new JScrollPane(t);
		
		f.add(p);
		f.setSize(400,300);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new JTreeExample();
	}

}
