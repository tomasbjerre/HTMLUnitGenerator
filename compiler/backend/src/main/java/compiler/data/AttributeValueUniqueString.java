package compiler.data;

import java.util.Random;

public class AttributeValueUniqueString extends AttributeValue {
	protected String string;
	protected static int defaultLength = 5;

	public AttributeValueUniqueString() {
		string = createString(defaultLength);
	}

	public AttributeValueUniqueString(int length) {
		string = createString(length);
	}

	private String createString(int length) {
		string = "";
		Random generator = new Random(System.currentTimeMillis());
		String candidates = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < length; i++) {
			string += candidates.charAt(generator.nextInt(candidates.length()));
		}
		return string;
	}

	@Override
	public String getValue() {
		return string;
	}

	@Override
	public String toString() {
		return string;
	}
}
