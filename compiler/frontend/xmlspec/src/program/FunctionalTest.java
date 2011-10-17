package program;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import compiler.Utils;

public class FunctionalTest extends Utils {
	private ArrayList<File> testCases;
	private static String testEndian = "xml";
	private static String testFolderPath = "testcases";

	@Test
	public void runAll() {
		runTests(new XMLFlowParser(),testCases,"javaresult");
	}

	@Before
	public void setUp() throws Exception {
		testCases = getFiles(testFolderPath, testEndian);
	}
}
