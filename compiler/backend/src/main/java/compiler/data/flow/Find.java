package compiler.data.flow;

import compiler.data.Findable;
import compiler.data.Path;

public class Find extends compiler.data.Find {
	public Find(Path path) {
		super(path);
	}

	@Override
	public String toString() {
		String result = "";
		if (getFindable().size() > 0) {
			result += "Find ";
			for (Findable findable : getFindable()) {
				if (!getFindable().get(0).equals(findable))
					if (findable.isAnd())
						result += " and ";
					else
						result += " or ";
				if (findable instanceof Tag) {
					Tag tag = (Tag)findable;
					result += tag.getType();
					for (compiler.data.Attribute atttribute : tag.getAttributes()) {
						if (!tag.getAttributes().get(0).equals(atttribute)) {
							if (atttribute.isAnd())
								result += " and";
							else
								result += " or";
						} else {
							result += " with";
						}
						result += " attribute "+atttribute.getName()+" set to ";
						if (atttribute.getValue().toString().indexOf(" ") == -1)
							result += atttribute.getValue();
						else
							result += "\"" + atttribute.getValue() + "\"";
					}
				} else if (findable instanceof Text) {
					Text text = (Text)findable;
					result += "containing ";
					if (text.getContent().indexOf(" ") == -1)
						result += text.getContent();
					else
						result += "\"" + text.getContent() + "\"";
				}

				if (path != null && !path.getValue().isEmpty() && !path.getValue().equals("/html/body"))
					result += " in "+path.getName();
				if (getWaitAtMost() != null && !getWaitAtMost().equals("0"))
					result += " or wait at most "+(Integer.parseInt(getWaitAtMost())/1000)+" seconds";
			}
			result += "\n";
		}
		return result;
	}
}
