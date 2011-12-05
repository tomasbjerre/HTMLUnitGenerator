package compiler.data.xml;


public class Tag extends compiler.data.Tag {
	public Tag(String type) {
		super(type);
	}

	@Override
	public String toString() {
		String result = "    <tag type=\""+getType()+"\">\n";
		for (compiler.data.Attribute attribute : getAttributes()) {
			result += "     <attribute";
			result += " name=\""+attribute.getName()+"\"";
			result += " value=\""+attribute.getValue()+"\"";
			result += "/>\n";
		}
		result += "    </tag>\n";
		return result;
	}
}
