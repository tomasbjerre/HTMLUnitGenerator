package flow.program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import compiler.Utils;
import compiler.data.xml.TargetFactory;

public class FunctionalTest{
	private ArrayList<File> testCases;
	private static String testEndian = "flow";
	private static String testFolderPath = "testcases";
	private static String resultEndian = "java";

	@Test
	public void runAll() {
		try {
			for (File testCase : testCases) {
				System.out.println((testCases.indexOf(testCase)+1)+"/"+testCases.size()+"> Running test: "+testCase.getAbsoluteFile());
				String expectedResultFilename = testCase.getAbsoluteFile() + "." + resultEndian ;
				String expectedTestResultContent = Utils.readFile(expectedResultFilename);
				StringWriter stringWriter = new StringWriter();
				new FlowParser().compile(
						new FileReader(testCase),
						stringWriter,
						Utils.getInputName(testCase.getName()),new TargetFactory());
				Utils.postCompile(expectedResultFilename, expectedTestResultContent,
						stringWriter);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setUp() throws Exception {
		testCases = new ArrayList<File>();
		testCases.addAll(Utils.getFiles(testFolderPath, testEndian));
		testCases.addAll(Utils.getFiles(testFolderPath+"/todo", testEndian));
	}
}
