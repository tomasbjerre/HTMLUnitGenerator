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

	@Before
	public void setUp() throws Exception {
		valueUniqueStringDefault = new AttributeValueUniqueString();
		valueUniqueStringDefault10 = new AttributeValueUniqueString(10);
		valueUniqueStringDefault100 = new AttributeValueUniqueString(100);
	}

	@Test
	public void test10() {
		System.out.println(valueUniqueStringDefault10.toString());
		assertNotNull(valueUniqueStringDefault10.toString());
		assertEquals(10,valueUniqueStringDefault10.toString().length());
	}

	@Test
	public void test100() {
		System.out.println(valueUniqueStringDefault100.toString());
		assertNotNull(valueUniqueStringDefault100.toString());
		assertEquals(100,valueUniqueStringDefault100.toString().length());
	}

	@Test
	public void testDefault() {
		System.out.println(valueUniqueStringDefault.toString());
		assertNotNull(valueUniqueStringDefault.toString());
		assertTrue(valueUniqueStringDefault.toString().length() == AttributeValueUniqueString.defaultLength);
	}
}
