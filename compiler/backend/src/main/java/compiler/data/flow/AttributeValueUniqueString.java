package compiler.data.flow;


public class AttributeValueUniqueString extends compiler.data.AttributeValueUniqueString {
	public AttributeValueUniqueString() {
		super();
	}

	public AttributeValueUniqueString(int length) {
		super(length);
	}

	@Override
	public String toString() {
		String toString = "unique string";
		if (string.length() != defaultLength)
			toString += " of length " + string.length();
		return toString;
	}
}
