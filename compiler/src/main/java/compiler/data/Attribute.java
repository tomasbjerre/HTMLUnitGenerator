package compiler.data;

public class Attribute {
	protected String value;
	protected String name;

	public Attribute(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		String result = " name=\""+name+"\"";
		result += " value=\""+value+"\"";
		return result;
	}
}
