package compiler.data.xml;

import compiler.data.Path;

public class Find extends compiler.data.Find {
	public Find(Path path) {
		super(path);
	}

	@Override
	public String toString() {
		String result = "  <find path=\""+path.getName()+"\">\n";
		if (getFindable().size() > 0) {
			for (compiler.data.Findable findable : getFindable()) {
				Tag tag = (Tag)findable;
				result += tag.toString();
			}
		}
		result += "  </find>\n";
		return result;
	}
}
