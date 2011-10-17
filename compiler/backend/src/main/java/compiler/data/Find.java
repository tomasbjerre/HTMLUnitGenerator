package compiler.data;

import java.util.ArrayList;
import java.util.List;

public class Find {
	protected Path path = null;
	protected List<Tag> tags = new ArrayList<Tag>();
	private final List<Text> texts = new ArrayList<Text>();

	public Find(Path path) {
		this.path = path;
	}

	public void addTag(Tag tag) {
		this.tags.add(tag);
	}

	public void addText(Text text) {
		texts.add(text);
	}
	public Path getPath() {
		return path;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public List<Text> getTexts() {
		return texts;
	}
}
