package compiler.data.flow;

import compiler.data.Path;

public class Find extends compiler.data.Find {
	public Find(Path path) {
		super(path);
	}
	@Override
	public String toString() {
		String result = "";
		if (tags.size() > 0) {
			for (compiler.data.Tag tag : tags) {
				for (compiler.data.Attribute atttribute : tag.getAttributes().values()) {
					result += "Find "+tag.getType()+" with attribute "+atttribute.getName()+" set to "+atttribute.getValue()+" in "+path.getName()+"\n";
				}
			}
		}
		return result;
	}
}
