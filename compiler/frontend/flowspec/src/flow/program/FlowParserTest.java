package flow.program;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

import java.io.Reader;
import java.io.StringReader;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import compiler.Utils;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utils.class)
public class FlowParserTest {
	private FlowParser flowParser;
	private final TreeMap<Integer, String> errors = new TreeMap<Integer, String>();

	private Object preCompile(String string, TreeMap<Integer, String> errors) {
		Reader preCompiled = flowParser.preProcess(new StringReader(string), errors);
		return Utils.readReader(preCompiled);
	}

	@Before
	public void setUp() {
		flowParser = new FlowParser();
		PowerMockito.mockStatic(Utils.class);
		PowerMockito.when(Utils.readReader(any(Reader.class))).thenCallRealMethod();
		PowerMockito.when(Utils.getAbsolutePath(any(String.class))).thenCallRealMethod();
		PowerMockito.when(Utils.fixLineEndings(any(String.class))).thenCallRealMethod();
		PowerMockito.when(Utils.normalizedEquals(any(String.class),any(String.class))).thenCallRealMethod();
		PowerMockito.when(Utils.splitUnsplit(any(String.class),any(String.class))).thenCallRealMethod();
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("MyOtherTestFile.flow"))).thenReturn("OtherTestContent");
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("MyOtherTestFileError.flow"))).thenReturn(null);
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("MyOtherTestFile2.flow"))).thenReturn("OtherTestContent2");
	}

	@Test
	public void testPreCompileEmpty() {
		assertEquals("\n",preCompile("",errors));
		assertEquals(0,errors.size());
	}

	@Test
	public void testPreCompileMultiLines() {
		assertEquals("line1\nline2\nline3\nline4\nline5\nline6\n\n",preCompile("line1\nline2\nline3\nline4\nline5\nline6\n",errors));
		assertEquals(0,errors.size());
	}

	@Test
	public void testPreCompileMultiLinesSee() {
		assertEquals("line1\nline2\nline3\nOtherTestContent\nline4\nline5\nline6\n\n",preCompile("line1\nline2\nline3\nSee MyOtherTestFile.flow\nline4\nline5\nline6\n",errors));
		assertEquals(0,errors.size());
	}

	@Test
	public void testPreCompileMultiLinesSeeNotFound() {
		assertEquals("",preCompile("line1\nline2\nline3\nSee MyOtherTestFileError.flow\nline4\nline5\nline6\n",errors));
		assertEquals(1,errors.size());
		assertEquals(new Integer(0),errors.keySet().iterator().next());
		assertEquals("Can not read file "+Utils.getAbsolutePath("MyOtherTestFileError.flow"),errors.values().iterator().next());
	}

	@Test
	public void testPreCompileMultiLinesSeeTwice() {
		assertEquals("line1\nline2\nline3\nOtherTestContent\nline4\nline5\nline6\nOtherTestContent2\n\n",preCompile("line1\nline2\nline3\nSee MyOtherTestFile.flow\nline4\nline5\nline6\nSee MyOtherTestFile2.flow\n",errors));
		assertEquals(0,errors.size());
	}

	@Test
	public void testPreCompileOneLine() {
		assertEquals("line1\n\n",preCompile("line1",errors));
		assertEquals(0,errors.size());
	}

	@Test
	public void testPreCompileOneLineNL() {
		assertEquals("line1\n\n",preCompile("line1\n",errors));
		assertEquals(0,errors.size());
	}

	@Test
	public void testPreCompileThreeLinesSeeSame() {
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("line1"))).thenReturn("line1Content");
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("line2"))).thenReturn("line2Content");
		assertEquals("line1Content\nline2Content\nline1Content\n\n",preCompile("See line1\nSee line2\nSee line1\n\n",errors));
		assertEquals(0,errors.size());
	}

	@Test
	public void testPreCompileThreeLinesSeeSameInSeeTwice() {
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("line1"))).thenReturn("line1Content");
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("line2"))).thenReturn("line2Content");
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("line3"))).thenReturn("See line2");
		assertEquals("line1Content\nline2Content\nline2Content\n\n",preCompile("See line1\nSee line2\nSee line3\n\n",errors));
		assertEquals(0,errors.size());
	}

	@Test
	public void testPreCompileThreeLinesSeeSameInSeeTwice2() {
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("line1"))).thenReturn("See line2");
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("line2"))).thenReturn("line2Content");
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("line3"))).thenReturn("See line2");
		assertEquals("line2Content\nline2Content\nline2Content\n\n",preCompile("See line1\nSee line2\nSee line3\n\n",errors));
		assertEquals(0,errors.size());
	}

	@Test
	public void testPreCompileThreeLinesTrippleSee() {
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("line1"))).thenReturn("See line2");
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("line2"))).thenReturn("See line3");
		PowerMockito.when(Utils.readFile(Utils.getAbsolutePath("line3"))).thenReturn("line3Content");
		assertEquals("line3Content\nline3Content\nline3Content\n\n",preCompile("See line1\nSee line2\nSee line3\n\n",errors));
		assertEquals(0,errors.size());
	}

	@Test
	public void testPreCompileTwoLines() {
		assertEquals("line1\nline2\n\n",preCompile("line1\nline2\n",errors));
		assertEquals(0,errors.size());
	}
}
