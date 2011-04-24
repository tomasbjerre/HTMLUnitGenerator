package program;


public class Run {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Missing testcase path");
            System.exit(1);
        }
        String output = "src/test/java/generatedtest/HTMLUnitGeneratedTest.java";

        System.out.println("Parsing test case \"" + args[0] + "\".");
        System.out.println("Writing to \"" + output + "\".");
        System.out.println();

        new XMLFlowParser(args[0],output);
    }
}
