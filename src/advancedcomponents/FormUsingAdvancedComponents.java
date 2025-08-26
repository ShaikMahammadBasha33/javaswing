package advancedcomponents;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormUsingAdvancedComponents {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Form Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // JComboBox
        String[] countries = {"India", "USA", "UK", "Canada"};
        JComboBox<String> comboBox = new JComboBox<>(countries);

        // JList
        String[] fruits = {"Apple", "Banana", "Mango", "Orange"};
        JList<String> fruitList = new JList<>(fruits);
        fruitList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // JTable
        String[] columnNames = {"ID", "Name", "Age"};
        Object[][] data = {
                {1, "John", 25},
                {2, "Alice", 30},
                {3, "Bob", 28}
        };
        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane tableScroll = new JScrollPane(table);

        // JTree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Languages");
        DefaultMutableTreeNode java = new DefaultMutableTreeNode("Java");
        java.add(new DefaultMutableTreeNode("Spring"));
        java.add(new DefaultMutableTreeNode("Hibernate"));
        DefaultMutableTreeNode python = new DefaultMutableTreeNode("Python");
        python.add(new DefaultMutableTreeNode("Django"));
        python.add(new DefaultMutableTreeNode("Flask"));
        root.add(java);
        root.add(python);
        JTree tree = new JTree(root);
        JScrollPane treeScroll = new JScrollPane(tree);

        // Add components to panel
        panel.add(comboBox);
        panel.add(new JScrollPane(fruitList));
        panel.add(tableScroll);
        panel.add(treeScroll);

        // Show button
        JButton showBtn = new JButton("Show Selection");
        showBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ComboBox selection
                String country = (String) comboBox.getSelectedItem();

                // JList selections
                java.util.List<String> selectedFruits = fruitList.getSelectedValuesList();

                // JTable selection
                int selectedRow = table.getSelectedRow();
                String tableSelection = "";
                if (selectedRow != -1) {
                    tableSelection = "ID: " + table.getValueAt(selectedRow, 0) +
                            ", Name: " + table.getValueAt(selectedRow, 1) +
                            ", Age: " + table.getValueAt(selectedRow, 2);
                } else {
                    tableSelection = "No row selected";
                }

                // JTree selection
                Object treeSelection = tree.getLastSelectedPathComponent();
                String treeNode = (treeSelection != null) ? treeSelection.toString() : "No node selected";

                // Show in dialog
                JOptionPane.showMessageDialog(frame,
                        "Country: " + country +
                                "\nFruits: " + selectedFruits +
                                "\nTable: " + tableSelection +
                                "\nTree: " + treeNode);
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(showBtn, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

