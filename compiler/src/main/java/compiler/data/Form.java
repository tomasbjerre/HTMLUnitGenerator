package compiler.data;

import java.util.ArrayList;
import java.util.List;

public class Form extends Referencable {
	protected List<Tag> tags = new ArrayList<Tag>();
	protected Path submit = null;

	public Form(String name, Path submit) {
		super(name);
		this.submit = submit;
	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}

	public Path getSubmit() {
		return submit;
	}

	public List<Tag> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		String result = "  <form id=\""+getName()+"\" submit=\""+getSubmit().getName()+"\">\n";
		for (Tag tag : getTags()) {
			result += "   <" + tag.getType();
			for (Attribute attribute : tag.getAttributes().values()) {
				result += " name=\"" + attribute.getName() + "\" value=\"" + attribute.getValue() + "\"";
			}
			result += "/>\n";
		}
		result += "  </form>\n";
		return result;
	}
}
