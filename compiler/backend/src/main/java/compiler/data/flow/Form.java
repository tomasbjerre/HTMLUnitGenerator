package compiler.data.flow;

import compiler.data.Path;

public class Form extends compiler.data.Form {
	public Form(String name, Path submit) {
		super(name, submit);
	}

	@Override
	public String toString() {
		String result = "Fill in "+getName();
		int i = 0;
		for (compiler.data.Tag tag : getTags()) {
			for (compiler.data.Attribute attribute : tag.getAttributes().values()) {
				if (i > 0)
					result += "and " + attribute.getName() + " set to " + attribute.getValue() + "";
				else
					result += "with " + attribute.getName() + " set to " + attribute.getValue() + "";
				i++;
			}
		}
		result += "\n";
		return result;
	}
}
