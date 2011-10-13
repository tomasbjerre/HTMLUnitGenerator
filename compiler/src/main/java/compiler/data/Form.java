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
		String result = "-Form\n";
		result += "Name:" + name + "\n";
		if (tags.size() > 0) {
			for (Tag tag : tags)
				result += tag + "\n";
			result += "\n";
		}
		return result;
	}
}
