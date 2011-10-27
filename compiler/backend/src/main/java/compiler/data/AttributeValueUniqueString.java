package compiler.data;


public class AttributeValueUniqueString extends AttributeValue {
	protected String string;
	private int length;
	protected static int defaultLength = 5;

	public AttributeValueUniqueString() {
		this.string = "";
		this.setLength(defaultLength);
	}

	public AttributeValueUniqueString(int length) {
		this.string = "";
		this.setLength(length);
	}

	public AttributeValueUniqueString(int length, String string) {
		this.string = string;
		this.setLength(length);
	}

	public int getLength() {
		return length;
	}

	@Override
	public String getValue() {
		return string;
	}

	public void setLength(int length) {
		if (length == 0)
			this.length = defaultLength;
		else
			this.length = length;
	}

	@Override
	public String toString() {
		return string;
	}
}
