package filechooser;

import java.io.FileWriter;

import javax.swing.*;

public class FileChooserToSave {
	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("file to save");
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			java.io.File fileToSave = fileChooser.getSelectedFile();
			try (FileWriter fw = new FileWriter(fileToSave)) {
				fw.write("This is a sample text to save in the file.");
				fw.write("\nYou can write any content here.");
				System.out.println("File to save: " + fileToSave.getAbsolutePath());

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No file selected");
		}
	}

}
