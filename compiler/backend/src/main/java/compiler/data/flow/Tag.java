package compiler.data.flow;


public class Tag extends compiler.data.Tag {
	public Tag(String type) {
		super(type);
		attributes = new compiler.data.xml.Attributes();
	}

	@Override
	public String toString() {
		String result = "";
		return result;
	}
}
