package flow.program;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import compiler.Utils;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utils.class)
public class RunTest {

	private String string1;
	private String string2;
	private String string3;
	private String string4;
	private String string5;
	private String string6;
	private String string7;
	private String string8;
	private String string9;
	private ArrayList<String> filesToCompile;

	private void mockGetInputPath() {
		ArrayList<File> filesInDir = new ArrayList<File>();
		filesInDir.add(new File("myInputFile.flow"));
		filesInDir.add(new File("InputFile.flow"));
		filesInDir.add(new File("myInputFileInput"));
		filesInDir.add(new File("myOtherInputFileInput.flow"));

		PowerMockito.mockStatic(Utils.class);
		PowerMockito.when(Utils.getFiles(Utils.getInputPath("*input"))).thenReturn(filesInDir);
		PowerMockito.when(Utils.getFiles(Utils.getInputPath("input*"))).thenReturn(filesInDir);
		PowerMockito.when(Utils.getFiles(Utils.getInputPath("my*.flow"))).thenReturn(filesInDir);
	}

	@Before
	public void setUp() throws Exception {
		string1 = "src/test/java/generatedtest/HTMLUnitGeneratedTest1.java";
		string2 = "/src/test/java/generatedtest/HTMLUnitGeneratedTest2.java123";
		string3 = "src/test/java/generatedtest/HTMLUnitGeneratedTest3";
		string4 = "HTMLUnitGeneratedTest4";
		string5 = "HTMLUnitGeneratedTest5.java";
		string6 = "/HTMLUnitGeneratedTest5.java";
		string7 = "one/HTMLUnitGeneratedTest5.java";
		string8 = "/one/HTMLUnitGeneratedTest5.java";
		string9 = "testspec/data/test_bbb.xml";
	}

	@Test
	public void testGetFilesToCompileStarAfter() {
		mockGetInputPath();
		filesToCompile = Run.getFilesToCompile("input*");
		assertEquals(1,filesToCompile.size());
		assertEquals("InputFile.flow",filesToCompile.get(0));
	}

	@Test
	public void testGetFilesToCompileStarBefore() {
		mockGetInputPath();
		filesToCompile = Run.getFilesToCompile("*input");
		assertEquals(1,filesToCompile.size());
		assertEquals("myInputFileInput",filesToCompile.get(0));
	}

	@Test
	public void testGetFilesToCompileStarMiddle() {
		mockGetInputPath();
		filesToCompile = Run.getFilesToCompile("my*.flow");
		assertEquals(2,filesToCompile.size());
		assertEquals("myInputFile.flow",filesToCompile.get(0));
		assertEquals("myOtherInputFileInput.flow",filesToCompile.get(1));
	}

	@Test
	public void testGetOutput() {
		assertEquals("src/test/java/generatedtest/HTMLUnitGeneratedTest1.java", Run.getOutput(string1));
		assertEquals("/src/test/java/generatedtest/HTMLUnitGeneratedTest2.java", Run.getOutput(string2));
		assertEquals("src/test/java/generatedtest/HTMLUnitGeneratedTest3.java", Run.getOutput(string3));
		assertEquals("HTMLUnitGeneratedTest4.java", Run.getOutput(string4));
		assertEquals("HTMLUnitGeneratedTest5.java", Run.getOutput(string5));
		assertEquals("/HTMLUnitGeneratedTest5.java", Run.getOutput(string6));
		assertEquals("one/HTMLUnitGeneratedTest5.java", Run.getOutput(string7));
		assertEquals("/one/HTMLUnitGeneratedTest5.java", Run.getOutput(string8));
		assertEquals("testspec/data/test_bbb.java", Run.getOutput(string9));
	}
}
