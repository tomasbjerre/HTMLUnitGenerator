package compiler.data;


public class Tag {
	private String type = "";
	protected Attributes attributes = null;

	public Tag(String type) {
		this.setType(type);
		attributes = new Attributes();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
