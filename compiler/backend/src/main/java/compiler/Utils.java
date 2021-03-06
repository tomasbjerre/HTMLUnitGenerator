package compiler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Utils {
	public static String fixLineEndings(String expectedTestResultContent) {
		expectedTestResultContent = splitUnsplit(expectedTestResultContent,"\n\r");
		expectedTestResultContent = splitUnsplit(expectedTestResultContent,"\n");
		return expectedTestResultContent;
	}

	public static String getAbsolutePath(String filename) {
		return new File("").getAbsolutePath() + "/" + filename;
	}

	public static ArrayList<File> getFiles(String path) {
		ArrayList<File> matches = new ArrayList<File>();
		File folder = new File(path);
		File files[] = folder.listFiles();
		for (File f : files)
			matches.add(f);
		return matches;
	}

	public static ArrayList<File> getFiles(String path, String endian) {
		ArrayList<File> matches = new ArrayList<File>();
		File folder = new File(path);
		File files[] = folder.listFiles();
		for (File f : files)
			if (f.getName().endsWith(endian))
				matches.add(f);
		return matches;
	}

	public static String getInputName(String string) {
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

	public static String getInputPath(String string) {
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

	public static String getNear(Integer line, String source) {
		if (source == null || line == null)
			return "";

		int l = line.intValue();

		String[] lines = source.split("\n");
		if (lines.length <= 5) {
			String linesStr = "";
			for (int i = 0; i <= l && i < lines.length ; i++)
				linesStr += (i+1) + ": " + lines[i] + "\n";
			return linesStr;
		}

		if (line <= 1) {
			String linesStr = "";
			for (int i = 0; i <= line.intValue() ; i++)
				linesStr += (i+1) + ": " + lines[i] + "\n";
			return linesStr;
		}

		String linesStr = "";
		for (int i = 0; i < 5 && (l-1+i-1) < lines.length ; i++)
			linesStr += (l-1+i) + ": " + lines[l-1+i-1] + "\n";
		return linesStr;
	}

	public static boolean normalizedEquals(String expectedTestResultContent,
			String actualTestResultContent) {
		expectedTestResultContent = fixLineEndings(expectedTestResultContent);
		actualTestResultContent = fixLineEndings(actualTestResultContent);
		return expectedTestResultContent.equals(actualTestResultContent);
	}

	public static void postCompile(String expectedResultFilename,
			String expectedTestResultContent,
			StringWriter actualTestResultWriter) {
		String actualTestResultContent = actualTestResultWriter.toString();
		if (expectedTestResultContent == null) {
			System.out.println("Did not find expeced result file, writing result to"+expectedResultFilename);
			writeFile(expectedResultFilename,actualTestResultContent);
		}else{
			if (!normalizedEquals(expectedTestResultContent,actualTestResultContent))
				assertEquals(expectedTestResultContent,actualTestResultContent);
		}
	}

	public static void postCompileUnique(String expectedResultFilename,
			String expectedTestResultContent,
			StringWriter actualTestResultWriter) {
		String actualTestResultContent = actualTestResultWriter.toString();
		if (expectedTestResultContent == null) {
			System.out.println("Did not find expeced result file, writing result to"+expectedResultFilename);
			writeFile(expectedResultFilename,actualTestResultContent);
		}else{
			if (normalizedEquals(expectedTestResultContent,actualTestResultContent))
				fail("Did not differ!");
		}
	}

	public static String readFile(File file) {
		try {
			return readReader(new FileReader(file));
		} catch (FileNotFoundException e) {
		}
		return null;
	}

	public static String readFile(String filename) {
		return readFile(new File(filename));
	}

	public static String readReader(Reader reader) {
		String content = "";
		try {
			BufferedReader bufferedReader = new BufferedReader(reader);
			while (true) {
				String line;
				line = bufferedReader.readLine();
				if (line == null)
					return content;
				content += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String splitUnsplit(String expectedTestResultContent, String divider) {
		String[] expectedTestResultContentSplit = expectedTestResultContent.split(divider);
		expectedTestResultContent = "";
		for (int i = 0; i < expectedTestResultContentSplit.length; i++) {
			if (!expectedTestResultContentSplit[i].trim().isEmpty())
				expectedTestResultContent += expectedTestResultContentSplit[i].trim() + "\n";
		}
		return expectedTestResultContent;
	}

	public static void writeFile(String filename, String content) {
		try {
			Writer wrtiter = new FileWriter(filename);;
			BufferedWriter bufferedWriter = new BufferedWriter(wrtiter);
			bufferedWriter.write(content);
			bufferedWriter.close();
		} catch (IOException e) {

		}
	}
}
