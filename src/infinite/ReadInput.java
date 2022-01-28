package infinite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadInput {
	private Scanner scan;
	public ReadInput(String inputFile) {
		try {
			this.scan = new Scanner(new File(inputFile));
		}catch(FileNotFoundException e) {
			System.out.println("Error: "+inputFile+" not found.");
		}
	}
	public Scanner getScan() {
		return this.scan;
	}
}
