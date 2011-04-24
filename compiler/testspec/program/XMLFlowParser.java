package program;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.TreeMap;

import parser.ParseException;
import parser.Parser;
import parser.Start;
import semanticlib.SymbolTable;

import compiler.data.Flow;
import compiler.generator.htmljunit.HTMLJunitGenerator;

public class XMLFlowParser extends Flow {
    public XMLFlowParser(String testCase, String output) {
        try {
            // Check grammar
            Parser parser = new Parser(new FileReader(testCase));
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

            HTMLJunitGenerator junitGenerator = new HTMLJunitGenerator(this);
            junitGenerator.writeToFile(output, junitGenerator.toString());
        } catch (FileNotFoundException e) {
            System.err.println("File " + testCase + " not found");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
