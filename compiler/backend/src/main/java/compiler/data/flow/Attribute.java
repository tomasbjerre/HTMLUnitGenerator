package compiler.data.flow;

import compiler.data.AttributeValue;

public class Attribute extends compiler.data.Attribute {

	public Attribute(String name, AttributeValue value) {
		super(name, value);
	}

	@Override
	public String toString() {
		String result = " with attribute "+name+" set to "+value;
		return result;
	}
}
