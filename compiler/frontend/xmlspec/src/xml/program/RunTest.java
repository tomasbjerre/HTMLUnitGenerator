package xml.program;

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
