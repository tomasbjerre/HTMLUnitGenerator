package compiler.data.flow;



public class Attributes extends compiler.data.Attributes {
	private static final long serialVersionUID = 2499989891790656323L;

	@Override
	public String toString() {
		String result = "";
		for (compiler.data.Attribute atttribute : values()) {
			result += atttribute.toString();
		}
		return result;
	}
}
