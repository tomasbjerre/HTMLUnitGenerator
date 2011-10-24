package compiler.data.xml;

import compiler.data.AttributeValue;

public class Attribute extends compiler.data.Attribute {

	public Attribute(String name, AttributeValue value) {
		super(name, value);
	}

	@Override
	public String toString() {
		String result = " name=\""+name+"\"";
		result += " value=\""+value+"\"";
		return result;
	}
}
