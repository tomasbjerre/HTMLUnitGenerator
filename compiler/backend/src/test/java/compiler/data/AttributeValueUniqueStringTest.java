package compiler.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AttributeValueUniqueStringTest {

	private AttributeValueUniqueString valueUniqueStringDefault;
	private AttributeValueUniqueString valueUniqueStringDefault10;
	private AttributeValueUniqueString valueUniqueStringDefault100;
	private AttributeValueUniqueString valueUniqueStringDefault10Start;
	private AttributeValueUniqueString valueUniqueStringDefault100Start;

	@Before
	public void setUp() throws Exception {
		valueUniqueStringDefault = new AttributeValueUniqueString();
		valueUniqueStringDefault10 = new AttributeValueUniqueString(10);
		valueUniqueStringDefault100 = new AttributeValueUniqueString(100);
		valueUniqueStringDefault10Start = new AttributeValueUniqueString(10, "minstart");
		valueUniqueStringDefault100Start = new AttributeValueUniqueString(100, "enstart");
	}

	@Test
	public void test10() {
		System.out.println(valueUniqueStringDefault10.toString());
		assertNotNull(valueUniqueStringDefault10.toString());
		assertEquals(0,valueUniqueStringDefault10.toString().length());
	}

	@Test
	public void test100() {
		System.out.println(valueUniqueStringDefault100.toString());
		assertNotNull(valueUniqueStringDefault100.toString());
		assertEquals(0,valueUniqueStringDefault100.toString().length());
	}

	@Test
	public void test100Start() {
		System.out.println(valueUniqueStringDefault100Start.toString());
		assertNotNull(valueUniqueStringDefault100Start.toString());
		assertEquals(7,valueUniqueStringDefault100Start.toString().length());
		assertTrue(valueUniqueStringDefault100Start.toString().startsWith("enstart"));
	}

	@Test
	public void test10Start() {
		System.out.println(valueUniqueStringDefault10Start.toString());
		assertNotNull(valueUniqueStringDefault10Start.toString());
		assertEquals(8,valueUniqueStringDefault10Start.toString().length());
		assertTrue(valueUniqueStringDefault10Start.toString().startsWith("minstart"));
	}

	@Test
	public void testDefault() {
		System.out.println(valueUniqueStringDefault.toString());
		assertNotNull(valueUniqueStringDefault.toString());
		assertTrue(valueUniqueStringDefault.getLength() == AttributeValueUniqueString.defaultLength);
	}
}
