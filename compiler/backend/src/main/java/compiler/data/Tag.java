package compiler.data;

import java.util.ArrayList;

public class Tag extends Findable {
	private String type = "";
	private final ArrayList<Attribute> attributes;

	public Tag(String type) {
		this.setType(type);
		attributes = new ArrayList<Attribute>();
	}

	public void addAttribute(Attribute attribute) {
		attributes.add(attribute);
	}

	public ArrayList<Attribute> getAttributes() {
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
