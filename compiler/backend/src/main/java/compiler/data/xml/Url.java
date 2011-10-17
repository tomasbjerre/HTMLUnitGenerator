package compiler.data.xml;

public class Url extends compiler.data.Url {
	public Url(String name, String value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return " <url id=\""+name+"\">\n  " + value + "\n </url>\n";
	}
}
