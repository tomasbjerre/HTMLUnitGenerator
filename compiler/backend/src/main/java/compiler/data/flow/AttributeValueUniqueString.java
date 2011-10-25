package compiler.data.flow;


public class AttributeValueUniqueString extends compiler.data.AttributeValueUniqueString {
	public AttributeValueUniqueString() {
		super();
	}

	public AttributeValueUniqueString(int length) {
		super(length);
	}

	public AttributeValueUniqueString(int length, String start) {
		super(length,start);
	}

	@Override
	public String toString() {
		String toString = "unique string";
		if (string.length() != defaultLength)
			toString += " of length " + string.length();
		if (start != null && !start.isEmpty())
			toString += " starting with " + start;
		return toString;
	}
}
