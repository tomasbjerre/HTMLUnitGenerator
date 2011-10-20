package flow.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.TreeMap;

import compiler.Frontend;
import compiler.SymbolTable;
import compiler.Utils;
import compiler.data.TargetFactory;
import compiler.data.flow.Flow;
import compiler.generator.htmljunit.HTMLJunitGenerator;

import flow.parser.ParseException;
import flow.parser.Parser;
import flow.parser.Start;

public class FlowParser extends Flow implements Frontend {

	public FlowParser() {

	}

	public FlowParser(Reader reader, Writer output, String testFileName, TargetFactory targetFactory) {
		compile(reader, output, testFileName, targetFactory);
	}

	@Override
	public String compile(Reader reader, Writer output, String testFileName, TargetFactory targetFactory) {
		String messages = "";
		try {
			TreeMap<Integer, String> errors = new TreeMap<Integer, String>();

			//Handle See statement
			reader = preProcess(reader, errors);

			Parser parser = null;
			Start start = null;
			SymbolTable symbolTable = null;
			if (errors.size() == 0) {
				// Check grammar
				parser = new Parser(reader);
				start = parser.start();

				//Check references
				symbolTable = start.nameAnalysis(errors);
			}

			if (errors.size() > 0) {
				for (Integer key : errors.keySet()) {
					messages += Utils.getNear(key,Utils.readReader(reader));
					messages += key + ") " + errors.get(key) + "\n";
				}
				write(output,messages);
				return messages;
			}

			// Populate data
			start.populate(this,symbolTable);
			HTMLJunitGenerator junitGenerator = new HTMLJunitGenerator(this,testFileName);
			write(output, junitGenerator.toString());
		} catch (ParseException e) {
			messages += e.getMessage();
			write(output,messages);
		} catch (Error e) {
			messages += e.getMessage();
			write(output,messages);
		} catch (Exception e) {
			messages += e.getMessage();
			write(output,messages);
		}

		return messages;
	}

	protected Reader preProcess(Reader reader, TreeMap<Integer, String> errors) {
		return preProcess(reader, errors, new HashMap<String,Boolean>());
	}

	protected Reader preProcess(Reader reader, TreeMap<Integer, String> errors, HashMap<String,Boolean> isInside) {
		String previousContent = "";
		String content = "";
		while (true) {
			content = "";
			try {
				BufferedReader bufferedReader = new BufferedReader(reader);
				while (true) {
					String line = bufferedReader.readLine();
					if (line == null) {
						content += "\n";
						break;
					}
					content += processSee(line, errors, isInside) + "\n\r";
					if (errors.size() > 0)
						return reader;
				}
			} catch (IOException e) {
				return reader;
			}
			if (Utils.normalizedEquals(content,previousContent) || errors.size() != 0) {
				break;
			} else {
				previousContent = content;
				reader = new StringReader(content);
			}
		}
		return new StringReader(Utils.fixLineEndings(content)+"\n");
	}

	private String processSee(String line, TreeMap<Integer, String> errors, HashMap<String,Boolean> isInside) {
		if (line.startsWith("See ")) {
			String filename = line.substring(4);
			String absoluteFile = Utils.getAbsolutePath(filename);
			String newLine = null;
			if (isInside.containsKey(filename)) {
				errors.put(new Integer(0), "File "+filename+" is included twice!");
				return line;
			}
			isInside.put(filename, true);
			if (filename.startsWith("/"))
				newLine = Utils.readFile(filename);
			else
				newLine = Utils.readFile(absoluteFile);
			if (newLine == null) {
				errors.put(new Integer(0), "Can not read file "+absoluteFile);
				return line;
			} else {
				line = Utils.readReader(preProcess(new StringReader(newLine), errors, isInside));
			}
			isInside.remove(filename);
		}
		return line;
	}

	private void write(Writer writer, String content) {
		try {
			writer.write(content, 0, content.length());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
