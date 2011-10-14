package program;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.TreeMap;

import parser.ParseException;
import parser.Parser;
import parser.Start;
import semanticlib.SymbolTable;

import compiler.data.Flow;
import compiler.generator.htmljunit.HTMLJunitGenerator;

public class XMLFlowParser extends Flow {
	public XMLFlowParser(Reader reader, Writer output, String testFileName) {
		try {
			// Check grammar
			Parser parser = new Parser(reader);
			Start start = parser.start();

			// Check references
			TreeMap<Integer, String> errors = new TreeMap<Integer, String>();
			SymbolTable symbolTable = start.nameAnalysis(errors);
			if (errors.size() > 0) {
				for (Integer key : errors.keySet())
					System.out.println(key + ") " + errors.get(key));
				return;
			}

			// Populate data
			start.populate(this,symbolTable);
			HTMLJunitGenerator junitGenerator = new HTMLJunitGenerator(this,testFileName);
			write(output, junitGenerator.toString());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
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
