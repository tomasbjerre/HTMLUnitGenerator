package program;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Run {

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

	public static void main(String[] args) throws IOException {
		String input = "";
		String output = "";
		if (args.length == 0) {
			System.err.println("Missing testcase path");
			System.exit(1);
		}
		input = args[0];
		output = getInputPath(args[0]) + "/" + getInputName(args[0]) + ".java";

		System.out.println("Parsing test case \"" + input + "\".");
		System.out.println("Writing to \"" + output + "\".");
		System.out.println();

		new XMLFlowParser(new FileReader(input), new FileWriter(new File(output)), getInputName(args[0]));
	}
}
