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
		toString += " of length " + getLength();
		if (string != null && !string.isEmpty())
			if (string.indexOf(" ") == -1)
				toString += " starting with " + string;
			else
				toString += " starting with \"" + string + "\"";
		return toString;
	}
}
