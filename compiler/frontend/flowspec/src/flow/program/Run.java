package flow.program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import compiler.Utils;
import compiler.data.TargetFactory;


public class Run extends compiler.Utils {

	private static void compileTest(String input, String output)
			throws FileNotFoundException, IOException {
		System.out.println("Parsing test case \"" + input + "\".");
		System.out.println("Writing to \"" + output + "\".");
		System.out.println();

		TargetFactory targetFactory = new compiler.data.xml.TargetFactory();
		new FlowParser(new FileReader(input), new FileWriter(new File(output)), getInputName(input), targetFactory );
	}

	protected static ArrayList<String> getFilesToCompile(String input) {
		ArrayList<String> filesToCompile = new ArrayList<String>();
		if (input.indexOf("*") != input.lastIndexOf("*")) {
			System.err.println("Wildcard only allowed once in input.");
			System.exit(1);
		} else {
			String inputPath = Utils.getInputPath(input);
			ArrayList<File> filesInPath = Utils.getFiles(inputPath);
			for (File file : filesInPath) {
				if (input.startsWith("*")) {
					if (file.getName().toLowerCase().endsWith(getLastHalf(input))) {
						filesToCompile.add(file.getName());
					}
				} else if (input.endsWith("*")) {
					if (file.getName().toLowerCase().startsWith(getFirstHalf(input))) {
						filesToCompile.add(file.getName());
					}
				} else {
					if (file.getName().toLowerCase().startsWith(getFirstHalf(input))) {
						if (file.getName().toLowerCase().endsWith(getLastHalf(input))) {
							filesToCompile.add(file.getName());
						}
					}
				}
			}
		}
		return filesToCompile;
	}

	private static String getFirstHalf(String input) {
		return input.substring(0,input.indexOf("*")).toLowerCase();
	}

	private static String getLastHalf(String input) {
		return input.substring(input.indexOf("*")+1).toLowerCase();
	}

	protected static String getOutput(String input) {
		if (getInputPath(input).isEmpty())
			return getInputName(input) + ".java";
		else if (getInputPath(input).equals("/"))
			return "/" + getInputName(input) + ".java";
		else
			return getInputPath(input) + "/" + getInputName(input) + ".java";
	}

	public static void main(String[] args) throws IOException {
		String input = "";
		String output = "";
		if (args.length == 0) {
			System.err.println("Missing testcase path");
			System.exit(1);
		}

		for (int i = 0; i < args.length; i++) {
			input = args[i];
			output = getOutput(input);

			if (input.indexOf("*") == -1) {
				compileTest(input, output);
			} else {
				ArrayList<String> filesToCompile = getFilesToCompile(input);
				for (String file : filesToCompile) {
					input = file;
					output = getOutput(input);
					compileTest(input, output);
				}
			}
		}
	}
}
