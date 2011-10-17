package compiler;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import compiler.data.xml.TargetFactory;

public class Utils {
	protected static String getInputName(String string) {
		String firstDotPart = string;
		if (string.indexOf(".") != -1) {
			String[] dotSplit = string.split("\\.");
			firstDotPart = dotSplit[0];
		}

		if (firstDotPart.indexOf("/") != -1) {
			String[] slashSplit = firstDotPart.split("\\/");
			return slashSplit[slashSplit.length-1];
		}
		return firstDotPart;
	}

	protected static String getInputPath(String string) {
		if (string.indexOf("/") != -1) {
			String[] slashSplit = string.split("\\/");
			String result = "";
			if (!slashSplit[0].isEmpty())
				result += slashSplit[0];
			else if (slashSplit.length == 2)
				result += "/";
			for (int i = 1; i < slashSplit.length-1; i++) {
				result += "/" + slashSplit[i];
			}
			return result;
		}
		return "";
	}

	protected ArrayList<File> getFiles(String path, String endian) {
		ArrayList<File> matches = new ArrayList<File>();
		File folder = new File(path);
		File files[] = folder.listFiles();
		for (File f : files)
			if (f.getName().endsWith(endian))
				matches.add(f);
		return matches;
	}

	private boolean normalizedEquals(String expectedTestResultContent,
			String actualTestResultContent) {
		return expectedTestResultContent.equals(actualTestResultContent);
	}

	protected String readFile(File file) {
		try {
			String content = "";
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while (true) {
				String line = bufferedReader.readLine();
				if (line == null)
					return content;
				content += line + "\n";
			}
		} catch (Exception e) {

		}
		return null;
	}

	protected String readFile(String expectedResultFilename) {
		return readFile(new File(expectedResultFilename));
	}

	protected void runTests(Frontend frontend, ArrayList<File> testCases, String resultEndian) {
		try {
			for (File testCase : testCases) {
				System.out.println((testCases.indexOf(testCase)+1)+"/"+testCases.size()+"> Running test: "+testCase.getAbsoluteFile());
				String expectedResultFilename = testCase.getAbsoluteFile() + "." + resultEndian;
				String expectedTestResultContent = readFile(expectedResultFilename);
				StringWriter stringWriter = new StringWriter();
				frontend.compile(
						new FileReader(testCase),
						stringWriter,
						getInputName(testCase.getName()),new TargetFactory());
				String actualTestResultContent = stringWriter.toString();
				if (expectedTestResultContent == null) {
					System.out.println("Did not find expeced result file, writing result to"+expectedResultFilename);
					writeFile(expectedResultFilename,actualTestResultContent);
				}else{
					if (!normalizedEquals(expectedTestResultContent,actualTestResultContent))
						assertEquals(expectedTestResultContent,actualTestResultContent);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void writeFile(String filename, String content) {
		try {
			Writer wrtiter = new FileWriter(filename);;
			BufferedWriter bufferedWriter = new BufferedWriter(wrtiter);
			bufferedWriter.write(content);
			bufferedWriter.close();
		} catch (IOException e) {

		}
	}
}
