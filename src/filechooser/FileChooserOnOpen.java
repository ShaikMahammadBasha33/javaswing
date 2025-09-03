package filechooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;

public class FileChooserOnOpen {
	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select a file");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // to select only directories
		int result = fileChooser.showOpenDialog(null);
		if(result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			
			//to read the file
			try(BufferedReader br = new BufferedReader(new FileReader(selectedFile))){
				String line = br.readLine();
				while(line!=null) {
					System.out.println(line);
					line = br.readLine();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//to show the selected file path
			System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}
		else{
			System.out.println("No file selected");
		}

	}

}
