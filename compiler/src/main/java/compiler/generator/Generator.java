package compiler.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Generator {
	public void writeToFile(String fileName, String content) {
		try {
			File file = new File(fileName);
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(content, 0, content.length());
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
