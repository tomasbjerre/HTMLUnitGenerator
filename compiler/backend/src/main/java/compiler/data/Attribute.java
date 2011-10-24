package compiler.data;

public class Attribute {
	protected AttributeValue value;
	protected String name;

	public Attribute(String name, AttributeValue value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public AttributeValue getValue() {
		return value;
	}
}
