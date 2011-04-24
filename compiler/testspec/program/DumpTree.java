package program;

import parser.*;
import java.io.*;

public class DumpTree {

  public static void main(String args[]) {
    if(args.length != 1) {
      System.err.println("DumpTree: missing file command line argument");
      System.exit(1);
    }
    try {
      Parser parser = new Parser(new FileReader(args[0]));

      // Start parsing from the nonterminal "Start".
      Start start = parser.start();

      // Print the resulting AST on standard output.
      start.dumpTreeWithSourceLines("  ", System.out);
    }
    catch (FileNotFoundException e) {
      System.err.println("DumpTree: file " + args[0] + " not found");
    }
    catch (ParseException e) {
      System.out.println(e.getMessage());
    }
  }
  
}
