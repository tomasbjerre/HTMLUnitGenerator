package xml.program;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import compiler.data.TargetFactory;


public class Run extends compiler.Utils {

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
		input = args[0];
		output = getOutput(input);

		System.out.println("Parsing test case \"" + input + "\".");
		System.out.println("Writing to \"" + output + "\".");
		System.out.println();

		TargetFactory targetFactory = new compiler.data.xml.TargetFactory();
		new XMLFlowParser(new FileReader(input), new FileWriter(new File(output)), getInputName(args[0]), targetFactory );
	}
}
