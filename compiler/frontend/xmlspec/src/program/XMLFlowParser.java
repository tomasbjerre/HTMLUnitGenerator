package program;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.TreeMap;

import parser.ParseException;
import parser.Parser;
import parser.Start;
import semanticlib.SymbolTable;

import compiler.Frontend;
import compiler.data.TargetFactory;
import compiler.data.xml.Flow;
import compiler.generator.htmljunit.HTMLJunitGenerator;

public class XMLFlowParser extends Flow implements Frontend {

	public XMLFlowParser() {

	}

	public XMLFlowParser(Reader reader, Writer output, String testFileName, TargetFactory targetFactory) {
		compile(reader, output, testFileName, targetFactory);
	}

	@Override
	public String compile(Reader reader, Writer output, String testFileName, TargetFactory targetFactory) {
		String messages = "";
		try {
			// Check grammar
			Parser parser = new Parser(reader);
			Start start = parser.start();

			// Check references
			TreeMap<Integer, String> errors = new TreeMap<Integer, String>();
			SymbolTable symbolTable = start.nameAnalysis(errors);
			if (errors.size() > 0) {
				for (Integer key : errors.keySet()) {
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
		}

		return messages;
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
