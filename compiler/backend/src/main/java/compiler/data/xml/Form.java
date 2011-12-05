package compiler.data.xml;

import compiler.data.Path;

public class Form extends compiler.data.Form {
	public Form(String name, Path submit) {
		super(name, submit);
	}

	@Override
	public String toString() {
		String result = "  <form id=\""+getName()+"\" submit=\""+getSubmit().getName()+"\">\n";
		for (compiler.data.Tag tag : getTags()) {
			result += "   <" + tag.getType();
			for (compiler.data.Attribute attribute : tag.getAttributes()) {
				result += " name=\"" + attribute.getName() + "\" value=\"" + attribute.getValue() + "\"";
			}
			result += "/>\n";
		}
		result += "  </form>\n";
		return result;
	}
}
