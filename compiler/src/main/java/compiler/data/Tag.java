package compiler.data;


public class Tag {
	private String type = "";
	protected Attributes attributes = new Attributes();

	public Tag(String type) {
		this.setType(type);
	}

	public void addAttribute(Attribute attribute) {
		attributes.put(attribute.getName(), attribute);
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public String getName() {
		return getType();
	}

	@Override
	public String toString() {
		String result = "    <tag type=\""+getType()+"\">\n";
		result += attributes.toString();
		result += "    </tag>\n";
		return result;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
