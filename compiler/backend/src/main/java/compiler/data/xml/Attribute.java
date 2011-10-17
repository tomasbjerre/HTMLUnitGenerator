package compiler.data.xml;

public class Attribute extends compiler.data.Attribute {

	public Attribute(String name, String value) {
		super(name, value);
	}

	@Override
	public String toString() {
		String result = " name=\""+name+"\"";
		result += " value=\""+value+"\"";
		return result;
	}
}
