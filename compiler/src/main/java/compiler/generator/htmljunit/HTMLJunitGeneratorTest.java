package compiler.generator.htmljunit;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import compiler.data.Flow;

public class HTMLJunitGeneratorTest extends TestCase {

	private HTMLJunitGenerator generator;

	@Override
	@Before
	public void setUp() throws Exception {
		Flow flow = new Flow();
		generator = new HTMLJunitGenerator(flow);
	}

	@Test
	public void testEscapeString1() {
		String input = "//*[@id=\"_eventId_search\"]";
		assertEquals("//*[@id=\\\"_eventId_search\\\"]",generator.escapeString(input));
		assertEquals("//*[@id=\"_eventId_search\"]",input);
	}

	@Test
	public void testEscapeString2() {
		String input = "/html/body/div[2]/div/div[2]/div[2]/div/div[3]";
		assertEquals("/html/body/div[2]/div/div[2]/div[2]/div/div[3]",generator.escapeString(input));
		assertEquals("/html/body/div[2]/div/div[2]/div[2]/div/div[3]",input);
	}

}
