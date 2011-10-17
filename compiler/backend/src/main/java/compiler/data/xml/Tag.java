package compiler.data.xml;


public class Tag extends compiler.data.Tag {
	public Tag(String type) {
		super(type);
		attributes = new compiler.data.xml.Attributes();
	}

	@Override
	public String toString() {
		String result = "    <tag type=\""+getType()+"\">\n";
		result += attributes.toString();
		result += "    </tag>\n";
		return result;
	}
}
