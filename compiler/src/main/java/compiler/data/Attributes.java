package compiler.data;

import java.util.HashMap;

public class Attributes extends HashMap<String, Attribute> {
	private static final long serialVersionUID = 4221116251772352473L;

	@Override
	public String toString() {
		String result = "";
		for (Attribute atttribute : values())
			result += atttribute;
		return result;
	}
}
