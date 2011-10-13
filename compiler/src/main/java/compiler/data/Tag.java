package compiler.data;


public class Tag {
	protected String type = "";
	protected Attributes attributes = new Attributes();

	public Tag(String type) {
		this.type = type;
	}

	public void addAttribute(Attribute attribute) {
		attributes.put(attribute.getName(), attribute);
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public String getName() {
		return type;
	}

	@Override
	public String toString() {
		String result = "    <tag type=\""+type+"\">\n";
		result += attributes.toString();
		result += "    </tag>\n";
		return result;
	}
}
