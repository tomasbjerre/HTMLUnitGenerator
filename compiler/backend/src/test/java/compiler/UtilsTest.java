package compiler;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UtilsTest {

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
		assertEquals("HTMLUnitGeneratedTest1", Utils.getInputName(string1));
		assertEquals("HTMLUnitGeneratedTest2", Utils.getInputName(string2));
		assertEquals("HTMLUnitGeneratedTest3", Utils.getInputName(string3));
		assertEquals("HTMLUnitGeneratedTest4", Utils.getInputName(string4));
		assertEquals("HTMLUnitGeneratedTest5", Utils.getInputName(string5));
		assertEquals("HTMLUnitGeneratedTest5", Utils.getInputName(string6));
		assertEquals("HTMLUnitGeneratedTest5", Utils.getInputName(string7));
		assertEquals("HTMLUnitGeneratedTest5", Utils.getInputName(string8));
		assertEquals("test_bbb", Utils.getInputName(string9));
	}

	@Test
	public void testGetInputPath() {
		assertEquals("src/test/java/generatedtest", Utils.getInputPath(string1));
		assertEquals("/src/test/java/generatedtest", Utils.getInputPath(string2));
		assertEquals("src/test/java/generatedtest", Utils.getInputPath(string3));
		assertEquals("", Utils.getInputPath(string4));
		assertEquals("", Utils.getInputPath(string5));
		assertEquals("/", Utils.getInputPath(string6));
		assertEquals("one", Utils.getInputPath(string7));
		assertEquals("/one", Utils.getInputPath(string8));
		assertEquals("testspec/data", Utils.getInputPath(string9));
	}

	@Test
	public void testGetNear() {
		String sourceCode = new String("");
		assertEquals("",Utils.getNear(null, null));
		assertEquals("",Utils.getNear(null, sourceCode));
		assertEquals("",Utils.getNear(new Integer(0), null));
		assertEquals("1: \n",Utils.getNear(new Integer(0), sourceCode));

		sourceCode = new String("line1");
		assertEquals("1: line1\n",Utils.getNear(new Integer(0), sourceCode));
		assertEquals("1: line1\n",Utils.getNear(new Integer(1), sourceCode));
		assertEquals("1: line1\n",Utils.getNear(new Integer(2), sourceCode));
		assertEquals("1: line1\n",Utils.getNear(new Integer(3), sourceCode));
		assertEquals("1: line1\n",Utils.getNear(new Integer(4), sourceCode));
		assertEquals("1: line1\n",Utils.getNear(new Integer(5), sourceCode));

		sourceCode = new String("line1\n");
		assertEquals("1: line1\n",Utils.getNear(new Integer(0), sourceCode));
		assertEquals("1: line1\n",Utils.getNear(new Integer(1), sourceCode));
		assertEquals("1: line1\n",Utils.getNear(new Integer(2), sourceCode));
		assertEquals("1: line1\n",Utils.getNear(new Integer(3), sourceCode));
		assertEquals("1: line1\n",Utils.getNear(new Integer(4), sourceCode));
		assertEquals("1: line1\n",Utils.getNear(new Integer(5), sourceCode));

		sourceCode = new String("line1\nline2\n");
		assertEquals("1: line1\n",Utils.getNear(new Integer(0), sourceCode));
		assertEquals("1: line1\n2: line2\n",Utils.getNear(new Integer(1), sourceCode));
		assertEquals("1: line1\n2: line2\n",Utils.getNear(new Integer(2), sourceCode));
		assertEquals("1: line1\n2: line2\n",Utils.getNear(new Integer(3), sourceCode));
		assertEquals("1: line1\n2: line2\n",Utils.getNear(new Integer(4), sourceCode));
		assertEquals("1: line1\n2: line2\n",Utils.getNear(new Integer(5), sourceCode));

		sourceCode = new String("line1\nline2\nline3\n");
		assertEquals("1: line1\n",Utils.getNear(new Integer(0), sourceCode));
		assertEquals("1: line1\n2: line2\n",Utils.getNear(new Integer(1), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n",Utils.getNear(new Integer(2), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n",Utils.getNear(new Integer(3), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n",Utils.getNear(new Integer(4), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n",Utils.getNear(new Integer(5), sourceCode));

		sourceCode = new String("line1\nline2\nline3\nline4\n");
		assertEquals("1: line1\n",Utils.getNear(new Integer(0), sourceCode));
		assertEquals("1: line1\n2: line2\n",Utils.getNear(new Integer(1), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n",Utils.getNear(new Integer(2), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n4: line4\n",Utils.getNear(new Integer(3), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n4: line4\n",Utils.getNear(new Integer(4), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n4: line4\n",Utils.getNear(new Integer(5), sourceCode));

		sourceCode = new String("line1\nline2\nline3\nline4\nline5\n");
		assertEquals("1: line1\n",Utils.getNear(new Integer(0), sourceCode));
		assertEquals("1: line1\n2: line2\n",Utils.getNear(new Integer(1), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n",Utils.getNear(new Integer(2), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n4: line4\n",Utils.getNear(new Integer(3), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n4: line4\n5: line5\n",Utils.getNear(new Integer(4), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n4: line4\n5: line5\n",Utils.getNear(new Integer(5), sourceCode));

		sourceCode = new String("line1\nline2\nline3\nline4\nline5\nline6\n");
		assertEquals("1: line1\n",Utils.getNear(new Integer(0), sourceCode));
		assertEquals("1: line1\n2: line2\n",Utils.getNear(new Integer(1), sourceCode));
		assertEquals("1: line1\n2: line2\n3: line3\n4: line4\n5: line5\n",Utils.getNear(new Integer(2), sourceCode));
		assertEquals("2: line2\n3: line3\n4: line4\n5: line5\n6: line6\n",Utils.getNear(new Integer(3), sourceCode));
		assertEquals("3: line3\n4: line4\n5: line5\n6: line6\n",Utils.getNear(new Integer(4), sourceCode));
		assertEquals("4: line4\n5: line5\n6: line6\n",Utils.getNear(new Integer(5), sourceCode));
	}

	@Test
	public void testNormalizedEquals() {

	}
}
