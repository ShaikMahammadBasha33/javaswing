package advancedcomponents;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class JTableExample {
	public static void main(String[] args) {
		new JTableExample();
		JFrame f = new JFrame("Table Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[][] details = {
				{"101","mahmmad","22"},
				{"102","sakshi","22"},
				{"103","akhila","21"},
				{"104","boya","25"},
				{"105","raju","51"},
				{"106","neeru","18"},
				{"107","dhanu","20"}
		

			};
		
		String[] columns = {"ID","NAME","AGE"};
		
		JTable tab = new JTable(details,columns);
		tab.setRowSelectionAllowed(true);
		tab.setColumnSelectionAllowed(false);
		
		JScrollPane p = new JScrollPane(tab);
		f.add(p);

		
		f.setSize(400,150);
		f.setVisible(true);
		
	}
	
	
	public JTableExample() {
	
	
		JFrame f1 = new JFrame("Table demo");
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("AGE");
		
		
		JTable t1= new JTable(model);
		t1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scroll = new JScrollPane(t1);
		f1.add(scroll,BorderLayout.CENTER);
		
		 JPanel panel = new JPanel();
	        JTextField idField = new JTextField(3);
	        JTextField nameField = new JTextField(8);
	        JTextField ageField = new JTextField(3);
	        JButton addButton = new JButton("Add Row");
	        JButton deleteButton = new JButton("Delete Row");
	        
	        
	        panel.add(new JLabel("ID:")); panel.add(idField);
	        panel.add(new JLabel("NAME:")); panel.add(nameField);
	        panel.add(new JLabel("AGE:")); panel.add(ageField);
	        panel.add(deleteButton); panel.add(addButton);
	        
	        f1.add(panel,BorderLayout.SOUTH);
	        
	        addButton.addActionListener(e->{
	        	model.addRow(new Object[] {
	        			idField.getText(), nameField.getText(),ageField.getText()
	        	});
	        });
	        
	        deleteButton.addActionListener(e -> {
	            int selectedRow = t1.getSelectedRow();
	            if (selectedRow != -1) {
	                model.removeRow(selectedRow);
	            }
	        });
	        f1.setSize(600,300);
	        f1.setLocationRelativeTo(null);
	        f1.setVisible(true);
	        
	}

}
