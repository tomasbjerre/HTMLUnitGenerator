package compiler.data;

import java.util.Random;

public class AttributeValueUniqueString extends AttributeValue {
	protected String string;
	protected String start;
	protected static int defaultLength = 5;

	public AttributeValueUniqueString() {
		string = createString(defaultLength);
	}

	public AttributeValueUniqueString(int length) {
		string = createString(length);
	}

	public AttributeValueUniqueString(int length, String start) {
		this.start = start;
		string = createString(length);
	}

	private String createString(int length) {
		string = start;
		if (start == null)
			string = "";
		Random generator = new Random(System.currentTimeMillis());
		String candidates = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = string.length(); i < length; i++) {
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
