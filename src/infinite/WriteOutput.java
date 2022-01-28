package infinite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteOutput {
	FileWriter fileWriter;
	public WriteOutput(String outputFile) {
		try {
			this.fileWriter = new FileWriter(new File(outputFile));
		}catch(IOException e){
			System.out.println("Error: "+outputFile+" not found.");
		}
	}
	public FileWriter getFileWriter() {
		return fileWriter;
	}
}
