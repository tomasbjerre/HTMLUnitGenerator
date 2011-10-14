package program;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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
	public void testGetInputName() {
		assertEquals("HTMLUnitGeneratedTest1", Run.getInputName(string1));
		assertEquals("HTMLUnitGeneratedTest2", Run.getInputName(string2));
		assertEquals("HTMLUnitGeneratedTest3", Run.getInputName(string3));
		assertEquals("HTMLUnitGeneratedTest4", Run.getInputName(string4));
		assertEquals("HTMLUnitGeneratedTest5", Run.getInputName(string5));
		assertEquals("HTMLUnitGeneratedTest5", Run.getInputName(string6));
		assertEquals("HTMLUnitGeneratedTest5", Run.getInputName(string7));
		assertEquals("HTMLUnitGeneratedTest5", Run.getInputName(string8));
		assertEquals("test_bbb", Run.getInputName(string9));
	}

	@Test
	public void testGetInputPath() {
		assertEquals("src/test/java/generatedtest", Run.getInputPath(string1));
		assertEquals("/src/test/java/generatedtest", Run.getInputPath(string2));
		assertEquals("src/test/java/generatedtest", Run.getInputPath(string3));
		assertEquals("", Run.getInputPath(string4));
		assertEquals("", Run.getInputPath(string5));
		assertEquals("/", Run.getInputPath(string6));
		assertEquals("one", Run.getInputPath(string7));
		assertEquals("/one", Run.getInputPath(string8));
		assertEquals("testspec/data", Run.getInputPath(string9));
	}

}
