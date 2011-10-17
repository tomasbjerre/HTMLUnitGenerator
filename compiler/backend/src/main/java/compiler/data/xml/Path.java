package compiler.data.xml;

public class Path extends compiler.data.Path {
	public Path(String name, String value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return " <path id=\""+name+"\">\n  " + value + "\n </path>\n";
	}
}
