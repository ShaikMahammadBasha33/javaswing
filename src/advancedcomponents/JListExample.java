package advancedcomponents;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JListExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("JList Multiple Selection Example");
        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] fruits = {
            "Mango", "Pineapple", "Grapes", "Apple", "Kiwi",
            "Dragon Fruit", "Raw Mango", "Banana"
        };

        // Create JList with multiple selection
        JList<String> list = new JList<>(fruits);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Wrap JList inside JScrollPane
        JScrollPane scrollPane = new JScrollPane(list);

        // Button to show selected fruits
        JButton showButton = new JButton("Show Selected");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<String> selectedFruits = list.getSelectedValuesList();
                if (selectedFruits.isEmpty()) {
                    JOptionPane.showMessageDialog(f, "No fruits selected!");
                } else {
                    JOptionPane.showMessageDialog(f, "Selected Fruits: " + selectedFruits);
                }
            }
        });

        // Panel to hold the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showButton);

        // Add components to frame
        f.add(scrollPane, BorderLayout.CENTER);
        f.add(buttonPanel, BorderLayout.SOUTH);

        f.setVisible(true);
    }
}
