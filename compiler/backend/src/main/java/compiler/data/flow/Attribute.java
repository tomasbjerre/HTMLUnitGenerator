package compiler.data.flow;

public class Attribute extends compiler.data.Attribute {

	public Attribute(String name, String value) {
		super(name, value);
	}

	@Override
	public String toString() {
		String result = " with attribute "+name+" set to "+value;
		return result;
	}
}
